package com.example.obligmedmaterialdesign3.ui.theme.palindrom

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.obligmedmaterialdesign3.Screens
import com.example.obligmedmaterialdesign3.ui.theme.ObligMedMaterialDesign3Theme

@Composable
fun PalindromeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        InputField()
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    KnappTo(navController)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField() {
    // main variables
    var text by remember { mutableStateOf("") }
    var hvisTekst by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    var tmp = ""

    Text(
        modifier = Modifier.padding(20.dp),
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        text = "Palindrome Screen"
    )

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(text = "Type in a word")},
        modifier = Modifier
            .padding(vertical = 20.dp)
            .height(100.dp)
    )
    // sjekker hvordan ordet blir baklengs
    for (i in text.length-1 downTo 0) {
        tmp += text[i]
    }

    var palindrome1 by remember { mutableStateOf(false)}
    val lagretText = text
    val lagretTmp = tmp
    println("Dette er lagret text: $lagretText")
    println("Dette er lagret text: $lagretTmp")

    Button(
        onClick = {
            hvisTekst = true
            println("============================")
            text = ""
            focusManager.clearFocus(true)
            if (lagretText == lagretTmp) {
                palindrome1 = true
                println("RIKTIG")
            } else {
                palindrome1 = false
            }
        },
        modifier = Modifier
            .height(50.dp)
            .width(150.dp)
    ) {
        Text(text = "CHECK")
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .height(100.dp),
        color = MaterialTheme.colorScheme.secondary
    ) {
        if (hvisTekst && palindrome1 == true) {
            TextField(palindromeCheck = true)
            println("teksten er vist")
            println("kom igjen da $lagretText")
            println("kom igjen da $lagretTmp")
        }
        else if (hvisTekst && palindrome1 == false) {
            TextField(palindromeCheck = false)
            println("ikke palindrome")
        }
    }
}

@Composable
fun KnappTo(navController: NavController) {
    Button(
        onClick = { navController.navigate(Screens.UnitConverterScreen.name) },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text(text = "TO UNIT")
    }
}

@Composable
fun TextField (palindromeCheck: Boolean) {
    if (palindromeCheck) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 35.dp),
            textAlign = TextAlign.Center,
            text = "This is a Palindrome"
        )
    } else {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 35.dp),
            textAlign = TextAlign.Center,
            text = "This is not a Palindrome"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview () {
    ObligMedMaterialDesign3Theme() {
    }
}