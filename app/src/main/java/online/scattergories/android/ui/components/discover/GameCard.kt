package online.scattergories.android.ui.components.discover

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import online.scattergories.android.R
import online.scattergories.android.models.PartialGame

@ExperimentalAnimationApi
@Composable
fun GameCard(game: PartialGame) {
    var expanded by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .clickable { expanded = !expanded }
    ) {
        Column(
            modifier = Modifier
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = RoundedCornerShape(8.dp)
                )
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .height(60.dp)
                    .fillMaxWidth()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = rememberImagePainter("https://www.unknown.nu/flags/images/${game.language}-100"),
                        contentDescription = "${game.language} flag",
                        modifier = Modifier.clip(
                            RoundedCornerShape(4.dp)
                        )
                    )
                    AnimatedVisibility(!expanded) {
                        Text(
                            text = game.categories.joinToString(", ") { it.displayName },
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .fillMaxWidth(0.8f)
                        )
                    }
                }
                AnimatedVisibility(!expanded) {
                    Text(text = "${game.currentMembers}/${game.maxMembers}")
                }
                AnimatedVisibility(expanded) {
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Button(onClick = { /*TODO Join Game */ }) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    Icons.Filled.KeyboardArrowRight,
                                    contentDescription = stringResource(R.string.game_card_join_game)
                                )
                                Text(text = stringResource(R.string.game_card_join_game))
                            }
                        }
                    }
                }
            }
            AnimatedVisibility(expanded, modifier = Modifier.padding(bottom = 20.dp)) {
                Column {
                    Box {
                        Row {
                            Text(text = stringResource(R.string.game_card_players), fontWeight = FontWeight.Bold)
                            Text(text = "${game.currentMembers}/${game.maxMembers}")
                        }
                    }
                    Box(modifier = Modifier.padding(top = 5.dp)) {
                        Row {
                            Text(text = stringResource(R.string.game_card_created_by), fontWeight = FontWeight.Bold)
                            Text(text = game.createdBy.username)
                        }
                    }
                    Box(modifier = Modifier.padding(top = 5.dp)) {
                        Column() {
                            Text(
                                text = stringResource(R.string.game_card_categories),
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = game.categories.joinToString(", ") { it.displayName },
                            )
                        }
                    }
                }
            }
        }
    }
}