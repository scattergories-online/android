package online.scattergories.android.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import online.scattergories.android.R

@ExperimentalMaterial3Api
@Composable
fun LoginScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier.background(MaterialTheme.colorScheme.background),
        topBar = { SmallTopAppBar(modifier = Modifier.background(Color.Black), title = { Text(text = "Login") }, ) },
    ) {
        val defaultWebClientID = stringResource(id = R.string.default_web_client_id)
        Column {
            Button(onClick = {
                FirebaseAuth.getInstance().signInAnonymously()
            }) {
                Text(text = "Sign In")
            }
        }
    }
}