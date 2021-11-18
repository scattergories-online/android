package online.scattergories.android.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import kotlinx.coroutines.ExperimentalCoroutinesApi
import online.scattergories.android.ui.components.BottomNavbar

@ExperimentalCoroutinesApi
@ExperimentalMaterial3Api
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier.background(MaterialTheme.colorScheme.background),
        topBar = {
            SmallTopAppBar(
                modifier = Modifier.background(Color.Black),
                title = { Text(text = "ScattergoriesOnline") })
        },
        bottomBar = {
            BottomNavbar(navController = navController)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

        }
    }
}
