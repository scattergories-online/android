package online.scattergories.android.ui.screens

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.apollographql.apollo.api.Input
import com.apollographql.apollo.coroutines.await
import com.apollographql.apollo.coroutines.toFlow
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import online.scattergories.android.GetAllGamesQuery
import online.scattergories.android.SubscribeGetAllGamesSubscription
import online.scattergories.android.core.ScattergoriesOnline
import online.scattergories.android.models.PartialCategory
import online.scattergories.android.models.PartialGame
import online.scattergories.android.models.PartialUser
import online.scattergories.android.ui.components.BottomNavbar
import online.scattergories.android.ui.components.discover.CreateGameButton
import online.scattergories.android.ui.components.discover.GameCard

@ExperimentalCoroutinesApi
@ExperimentalAnimationApi
@ExperimentalMaterial3Api
@Composable
fun DiscoverScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier.background(MaterialTheme.colorScheme.background),
        topBar = {
            SmallTopAppBar(
                modifier = Modifier.background(Color.Black),
                title = { Text(text = "Discover Games") })
        },
        bottomBar = {
            BottomNavbar(navController = navController)
        }
    ) {
        Column {
            Column(modifier = Modifier.fillMaxSize()) {
                CreateGameButton()
                GameList(modifier = Modifier.padding(top = 10.dp))
            }
        }
    }
}

@ExperimentalCoroutinesApi
@SuppressLint("CoroutineCreationDuringComposition")
@ExperimentalAnimationApi
@Composable
fun GameList(modifier: Modifier) {
    val coroutineScope = rememberCoroutineScope()
    var games by remember {
        mutableStateOf<List<PartialGame>>(listOf())
    }
    coroutineScope.launch {
        ScattergoriesOnline.apolloClient.subscribe(SubscribeGetAllGamesSubscription(Input.optional(
            listOf("en", "de"))))
            .toFlow().collect {
                val mappedGames = it.data?.games?.map { game ->
                    PartialGame(
                        game.id.toString(),
                        game.language,
                        game.categories.map { category ->
                            PartialCategory(
                                category.category!!.id.toString(),
                                category.category.display_name
                            )
                        },
                        game.players_aggregate.aggregate?.count ?: -1,
                        game.max_members,
                        PartialUser(game.creator!!.id.toString(), game.creator.username)
                    )
                } ?: listOf()
                games = mappedGames
            }
    }
    val scrollState = rememberScrollState()
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
        ) {
            for (game in games) {
                GameCard(game)
            }
        }
    }
}