package com.example.myhd_oblig1.ui.theme.quiz

import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.myhd_oblig1.Screens

@Composable
fun QuizScreen (navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "QuizScreen")
        Button(onClick = {navController.popBackStack(Screens.PalindromeScreen.name, inclusive = false)}) {
            Text(text = "til Palindrome")
        }
    }
}