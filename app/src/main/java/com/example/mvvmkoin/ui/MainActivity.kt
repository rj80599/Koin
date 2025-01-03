package com.example.mvvmkoin.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mvvmkoin.ui.theme.MVVMKoinTheme


class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MVVMKoinTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Tweets", modifier = Modifier.background(Color.White)) }
                        )
                    }
                ) {
                    Box(modifier = Modifier.padding(it)) {
                        App()
                    }
                }
            }
        }
    }
}


@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "category") {
        composable(route = "category") {
            CategoryScreen()
            {
                navController.navigate("tweet/$it")
            }
        }
        composable(route = "tweet/{cat}", arguments = listOf(
            navArgument("cat") {
                type = NavType.StringType
            }
        )) {
            DetailScreen()
        }
    }

}
