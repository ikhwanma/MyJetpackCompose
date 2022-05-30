package ikhwan.binar.myjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ikhwan.binar.myjetpackcompose.ui.theme.MyJetpackComposeTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    InputText2()
                }
            }
        }
    }
}

@Composable
fun InputText2() {

    var angka1 by remember { mutableStateOf("") }
    var angka2 by remember { mutableStateOf("") }
    var hasil by remember { mutableStateOf("") }
    
    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)){

        OutlinedTextField(
            value = angka1,
            onValueChange = { angka1 = it },
            label = { Text("Angka 1") },
            modifier = Modifier
                .fillMaxWidth()
        )

        OutlinedTextField(
            value = angka2,
            onValueChange = { angka2 = it },
            label = { Text("Angka 2") },
            modifier = Modifier
                .fillMaxWidth()
        )
        
        Button(onClick = {
            val hsl = angka1.toInt() + angka2.toInt()
            hasil = hsl.toString()
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Hitung")
        }
        
        Text(text = hasil, fontSize = 20.sp, )
    }
    
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview3() {
    MyJetpackComposeTheme {
        
    }
}