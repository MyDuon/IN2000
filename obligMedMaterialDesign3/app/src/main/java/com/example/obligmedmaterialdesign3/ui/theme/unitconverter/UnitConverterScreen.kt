package com.example.obligmedmaterialdesign3.ui.theme.unitconverter

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.obligmedmaterialdesign3.R
import com.example.obligmedmaterialdesign3.Screens
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Composable
fun UnitConverterScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxWidth(),
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
            NextButton(navController = navController)
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainComponent (navController: NavController) {

    // TEXT FIELD
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it},
        label = { Text(text = "Type in a number to convert to Litres")},
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 20.dp)
            .height(100.dp),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
    )
    println("DETTE ER TEKSTEN NAA $text")
    //val nummer = text.toInt()

    var tmp = text
    // EXPOSED DROPDOWN MENU
    val measurement = stringArrayResource(R.array.Imperial_Measurement)
    val ounce = measurement[0]
    val cup = measurement[1]
    val gallon = measurement[2]
    val hoghead = measurement[3]
    val hei = listOf(measurement)
    val options = listOf(ounce, cup, gallon, hoghead )

    var knappTrykket by remember { mutableStateOf(false)}
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf("CHOOSE MEASUREMENT") }

    ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = {expanded = !expanded}) {
        TextField(
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
                .padding(all = 20.dp),
            readOnly = true,
            value = selectedOptionText,
            onValueChange = {},
            label = { Text("Label")},
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    text = { Text(selectionOption) },
                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                        println("KNAPP TRYKKET $selectedOptionText")
                        knappTrykket = true
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                )
            }
        }
    }

    var he by remember { mutableStateOf("") }
    //var he2 = ""

    // CONVERTING BUTTON
    var convertKnappTrykket by remember { mutableStateOf(false)}
    val focusManager = LocalFocusManager.current
    //var gjortBeregning by remember { mutableStateOf(false) }
    var tomStreng = ""

    tomStreng += he
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        content = {
            println("HVA ER TOM STRENG NAA $tomStreng")

            println("HVA ER HE: $he")

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .height(100.dp),
                color = MaterialTheme.colorScheme.secondary
            ) {
                if (convertKnappTrykket && selectedOptionText == options[0] && tomStreng != "") {
                    println("inne her")
                    var a = tomStreng.toInt()
                    var resultat = a*0.02957
                    var roundOff = (resultat*100.0).roundToInt()/100.0
                    var nyttResultat = roundOff.toString()
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 35.dp),
                        textAlign = TextAlign.Center,
                        text = "litres $nyttResultat "
                    )
                    println("kommer ikke ned her")
                } else if (convertKnappTrykket && selectedOptionText == options[1] && tomStreng != "") {
                    var a = tomStreng.toInt()
                    var resultat = a*0.23659
                    var roundOff = (resultat*100.0).roundToInt()/100.0
                    var nyttResultat = roundOff.toString()
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 35.dp),
                        textAlign = TextAlign.Center,
                        text = "litres $nyttResultat ")
                } else if (convertKnappTrykket && selectedOptionText == options[2] && tomStreng != "") {
                    var a = tomStreng.toInt()
                    var resultat = a*3.78541
                    var roundOff = (resultat*100.0).roundToInt()/100.0
                    var nyttResultat = roundOff.toString()
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 35.dp),
                        textAlign = TextAlign.Center,
                        text = "litres $nyttResultat ")
                } else if (convertKnappTrykket && selectedOptionText == options[3] && tomStreng != "") {
                    var a = tomStreng.toInt()
                    var resultat = a*238.481
                    var roundOff = (resultat*100.0).roundToInt()/100.0
                    var nyttResultat = roundOff.toString()
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 35.dp),
                        textAlign = TextAlign.Center,
                        text = "litres $nyttResultat ")
                }
            }

            Button(
                onClick = {
                    if (text == "") {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                "Snackbar # "
                            )
                        }
                    }
                    he += tmp
                    text = ""
                    focusManager.clearFocus(true)
                    convertKnappTrykket = true
                    knappTrykket = false
                    //gjortBeregning = true
                    tomStreng = ""
                }
            ) {
                Text(text = "CONVERT")
            }
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .height(100.dp),
                color = MaterialTheme.colorScheme.secondary
            ) {
                NextButton(navController)

            }
        }
    )



    /*
    Button(
        onClick = {
            he += tmp
            text = ""
            focusManager.clearFocus(true)
            convertKnappTrykket = true
            knappTrykket = false
            //gjortBeregning = true
            tomStreng = ""
        }
    ) {
        Text(text = "CONVERT")
    }

     */



}

@Composable
fun NextButton(navController: NavController) {
    Button(
        onClick = {navController.navigate(Screens.QuizScreen.name)},
        modifier = Modifier
            .height(50.dp)
    ) {
        Text(text = "TO QUIZ")
    }
}

