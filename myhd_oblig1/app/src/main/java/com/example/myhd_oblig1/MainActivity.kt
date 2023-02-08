package com.example.myhd_oblig1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.NavController
import com.example.myhd_oblig1.ui.theme.Myhd_oblig1Theme
import com.example.myhd_oblig1.ui.theme.palindrom.PalindromeScreen
import com.example.myhd_oblig1.ui.theme.quiz.QuizScreen
import com.example.myhd_oblig1.ui.theme.unitconverter.UnitConverterScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Myhd_oblig1Theme {
                NavHost(
                    navController = navController,
                    startDestination = Screens.PalindromeScreen.name
                ) {
                    composable(Screens.PalindromeScreen.name) {
                        PalindromeScreen(navController = navController)
                    }
                    composable(Screens.UnitConverterScreen.name) {
                        UnitConverterScreen(navController = navController)
                    }
                    composable(Screens.QuizScreen.name) {
                        QuizScreen(navController = navController)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Myhd_oblig1Theme {
        Greeting("Android")
    }
}

enum class Screens {
    PalindromeScreen,
    UnitConverterScreen,
    QuizScreen,
}