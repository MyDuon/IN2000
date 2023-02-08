package com.example.myhd_oblig1.ui.theme.unitconverter

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myhd_oblig1.Screens
import com.example.myhd_oblig1.ui.theme.palindrom.KnappTo

@Composable
fun UnitConverterScreen (navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "UnitScreen")
        
        MainComponent(navController = navController)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NextButton(navController)
        }
    }
}

@Composable
fun MainComponent (navController: NavController) {
    val focusManager = LocalFocusManager.current

    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(text = "Type in a word") },
        modifier = Modifier
            .padding(vertical = 20.dp)
            .height(100.dp),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
    )
/*
    val measurement = stringArrayResource(R.array.Imperil_Measurement)
    val norske_ord = stringArrayResource(R.array.norske_ord)
    val a = resources.getString

    val res: Resources = resources
    val appThemeList = res.getStringArray(R.array.themeList)*/

    Button(
        onClick = {
            focusManager.clearFocus(true)
        }

    ) {
        Text(text = "CONVERT")
    }
}

@Composable
fun NextButton(navController: NavController) {
    Button(
        onClick = {
            navController.popBackStack(Screens.QuizScreen.name, inclusive = false)
                  },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text(text = "TO QUIZ")
    }
}