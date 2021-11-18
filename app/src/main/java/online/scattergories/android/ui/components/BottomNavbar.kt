package online.scattergories.android.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import online.scattergories.android.navigation.Screen

@Composable
fun BottomNavbar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    NavigationBar(
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = ""
                )
            },
            label = { Text(stringResource(id = Screen.Home.resourceId)) },
            onClick = { navController.navigate(Screen.Home.route) },
            selected = currentDestination?.hierarchy?.any { it.route == Screen.Home.route } == true)
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = ""
                )
            },
            label = { Text(stringResource(id = Screen.Discover.resourceId)) },
            onClick = { navController.navigate(Screen.Discover.route) },
            selected = currentDestination?.hierarchy?.any { it.route == Screen.Discover.route } == true)
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.Person,
                    contentDescription = ""
                )
            },
            label = { Text(stringResource(id = Screen.Profile.resourceId)) },
            onClick = { navController.navigate(Screen.Profile.route) },
            selected = currentDestination?.hierarchy?.any { it.route == Screen.Profile.route } == true)
    }
}
