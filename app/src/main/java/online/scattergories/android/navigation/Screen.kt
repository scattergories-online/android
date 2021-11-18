package online.scattergories.android.navigation

import androidx.annotation.StringRes
import online.scattergories.android.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Home : Screen("home", R.string.screen_home)
    object Discover : Screen("discover", R.string.screen_discover)
    object Profile : Screen("profile", R.string.screen_profile)
    object Login : Screen("login", R.string.screen_login)
}