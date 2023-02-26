package com.example.obligmedmaterialdesign3.ui.theme.quiz

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.obligmedmaterialdesign3.Screens

data class QuizUiState (var question1: Question, var question2: Question, var question3: Question){
    var counter = 0
    var emptyList: List<Question> = listOf(question1, question2, question3)

    fun incrementCounter () {
        counter++
    }

}

data class Question (val question: String, val correct: Boolean) {
}

@Composable
fun QuizScreen(navController: NavController) {
    val firstQuestion = Question("Hovedstaden i Australia er Canberra", true)
    val secondQuestion = Question("Hovestaden i Sveits er Zurich", false)
    val thirdQuestion = Question("Hovedstaden i Tanzania er Dodoma", true)

    var state1 = QuizUiState(firstQuestion, secondQuestion, thirdQuestion)
    //state1.emptyList[0]
    println(state1.emptyList[0].question)

    //var ranCounter = 0
    var ranCounter by remember { mutableStateOf(0) }
    var correctAnswers = 0

    //var correctAnswers by remember { mutableStateOf(0) }
    //var pressedFakta = false
    //var pressedFleip = false
    var pressedFakta by remember { mutableStateOf(false) }
    var pressedFleip by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(100.dp),
            color = MaterialTheme.colorScheme.secondary
        ) {
            if (ranCounter == 0) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 35.dp),
                    textAlign = TextAlign.Center,
                    text = state1.emptyList[0].question
                )
            } else if (ranCounter == 1) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 35.dp),
                    textAlign = TextAlign.Center,
                    text = state1.emptyList[1].question
                )
            } else if (ranCounter == 2) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 35.dp),
                    textAlign = TextAlign.Center,
                    text = state1.emptyList[2].question
                )
            }
        }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                   enabled = Deactivate(ranCounter),
                   onClick = { ranCounter++; pressedFakta = true},
                   modifier = Modifier
                       .height(50.dp)
                       .width(150.dp)
                       .padding(all = 5.dp),
                   colors = ButtonDefaults.buttonColors(Color.Green)
               ) {
                   Text(text = "Fakta")
                   if (ranCounter == 1 || ranCounter == 3) {
                       if (pressedFakta == true) {
                           println("RIKTIG FAKTA")
                           correctAnswers++
                       }
                   }
               }
                Button(
                    enabled = Deactivate(ranCounter),
                    onClick = { ranCounter++; pressedFleip = true},
                    modifier = Modifier
                        .height(50.dp)
                        .width(150.dp)
                        .padding(all = 5.dp),
                    colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "Fleip")
                    println("HVA SKJER")
                    println("HVA ER RANDOUNTER: $ranCounter")
                    println("HVA ER PRESSEDFLEIP $pressedFleip")
                    if (ranCounter == 2 && pressedFleip == true) {
                        println("RIKTIG FLEIP")
                        correctAnswers++
                    }
                }

            }
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .height(100.dp),
                color = MaterialTheme.colorScheme.secondary
            ) {
                println(correctAnswers)
                if (ranCounter > 2) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 35.dp),
                        textAlign = TextAlign.Center,
                        text = "Du fikk $correctAnswers av 3 riktige svar"
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {ranCounter = 0; correctAnswers = 0; println("Knappen blir trykket") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "RESET")
                }
            }
        }
}
/*
@Composable
fun NextButton(navController: NavController) {
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text(text = "TO PALINDROME")
    }
}
*/

fun Deactivate (teller: Int): Boolean {
    if (teller > 2) {
        return false
    }
    return true

}