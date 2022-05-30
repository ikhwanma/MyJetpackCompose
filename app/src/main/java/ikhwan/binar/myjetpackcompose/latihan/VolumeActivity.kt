package ikhwan.binar.myjetpackcompose.latihan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ikhwan.binar.myjetpackcompose.latihan.ui.theme.MyJetpackComposeTheme

class VolumeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting3()
                }
            }
        }
    }
}

@Composable
fun Greeting3() {
    var panjang by remember { mutableStateOf("") }
    var lebar by remember { mutableStateOf("") }
    var tinggi by remember { mutableStateOf("") }
    var volume by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Volume", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        OutlinedTextField(
            value = panjang,
            onValueChange = { panjang = it },
            label = { Text("Panjang") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
        )

        OutlinedTextField(
            value = lebar,
            onValueChange = { lebar = it },
            label = { Text("Lebar") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
        )

        OutlinedTextField(
            value = tinggi,
            onValueChange = { tinggi = it },
            label = { Text("Tinggi") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
        )

        Button(onClick = {
            val vol = panjang.toInt() * lebar.toInt() * tinggi.toInt()
            volume = vol.toString()
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Hitung Volume")
        }

        Text(text = "Volume : $volume", fontSize = 20.sp)
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    MyJetpackComposeTheme {
        Greeting3()
    }
}