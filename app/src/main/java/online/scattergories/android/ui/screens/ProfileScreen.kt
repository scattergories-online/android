package online.scattergories.android.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import online.scattergories.android.ui.components.BottomNavbar
import online.scattergories.android.navigation.Screen

@ExperimentalMaterial3Api
@Composable
fun ProfileScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier.background(MaterialTheme.colorScheme.background),
        topBar = {
            SmallTopAppBar(modifier = Modifier.background(Color.Black), title = {
                Text(
                    text = stringResource(id = Screen.Profile.resourceId)
                )
            }, actions = {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Filled.Settings, contentDescription = "Settings (L)")
                }
            })
        },
        bottomBar = {
            BottomNavbar(navController = navController)
        }
    ) {
        Column {
            Button(onClick = { navController.navigate(Screen.Home.route) }) {
                Text(text = "Go To Home")
            }
        }
    }
}