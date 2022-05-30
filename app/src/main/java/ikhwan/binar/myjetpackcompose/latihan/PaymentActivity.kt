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

class PaymentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting4()
                }
            }
        }
    }
}

@Composable
fun Greeting4() {
    var total by remember { mutableStateOf("") }
    var bayar by remember { mutableStateOf("") }
    var sisa by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Payment", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        OutlinedTextField(
            value = total,
            onValueChange = { total = it },
            label = { Text("Total") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
        )

        OutlinedTextField(
            value = bayar,
            onValueChange = { bayar = it },
            label = { Text("Bayar") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
        )

        Button(onClick = {
            val s = bayar.toInt() - total.toInt()
            sisa = s.toString()
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Hitung Volume")
        }

        Text(text = "Sisa : $sisa", fontSize = 20.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {
    MyJetpackComposeTheme {
        Greeting4()
    }
}