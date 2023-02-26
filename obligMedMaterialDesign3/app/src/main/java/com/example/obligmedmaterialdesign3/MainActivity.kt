package com.example.obligmedmaterialdesign3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.obligmedmaterialdesign3.ui.theme.ObligMedMaterialDesign3Theme
import androidx.navigation.compose.rememberNavController
import com.example.obligmedmaterialdesign3.ui.theme.palindrom.PalindromeScreen
import com.example.obligmedmaterialdesign3.ui.theme.quiz.QuizScreen
import com.example.obligmedmaterialdesign3.ui.theme.unitconverter.UnitConverterScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            ObligMedMaterialDesign3Theme {
                // A surface container using the 'background' color from the theme
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
    ObligMedMaterialDesign3Theme {
        Greeting("Android")
    }
}

enum class Screens {
    PalindromeScreen,
    UnitConverterScreen,
    QuizScreen,
}