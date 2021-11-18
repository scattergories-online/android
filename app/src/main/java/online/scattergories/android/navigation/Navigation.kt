package online.scattergories.android.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import online.scattergories.android.ui.screens.DiscoverScreen
import online.scattergories.android.ui.screens.HomeScreen
import online.scattergories.android.ui.screens.LoginScreen
import online.scattergories.android.ui.screens.ProfileScreen

@ExperimentalCoroutinesApi
@ExperimentalAnimationApi
@ExperimentalMaterial3Api
@Composable
fun Navigation() {
    val navController = rememberNavController()
    val user = FirebaseAuth.getInstance().currentUser
    val startDestination = if (user == null) Screen.Login.route else Screen.Home.route
    FirebaseAuth.getInstance().addAuthStateListener {
        if (it.currentUser == null) {
            navController.navigate(Screen.Login.route)
        } else {
            navController.navigate(Screen.Home.route)
        }
    }

    NavHost(navController = navController, startDestination = startDestination) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Discover.route) { DiscoverScreen(navController) }
        composable(Screen.Profile.route) { ProfileScreen(navController) }
        composable(Screen.Login.route) { LoginScreen(navController) }
    }
}