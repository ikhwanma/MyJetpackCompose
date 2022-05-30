package ikhwan.binar.myjetpackcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ikhwan.binar.myjetpackcompose.ui.theme.MyJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Greeting("Ikhwan")
                        Spacer(modifier = Modifier.padding(10.dp))
                        SimpleFilledTextFieldSample("Name")
                        Spacer(modifier = Modifier.padding(10.dp))
                        SimpleFilledTextFieldSample("Password")
                        Spacer(modifier = Modifier.padding(10.dp))
                        OutlinedTextFieldSample(hint = "Pass")
                        Spacer(modifier = Modifier.padding(10.dp))
                        ButtonCustom(title = "Ini Button", color = Color.Gray)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", color = Color.Blue)
}

@Composable
fun TextCustom() {
    Text(text = "Hello World!", fontSize = 20.sp, color = Color.Blue, fontWeight = FontWeight.Bold)
}

@Composable
fun ButtonTest() {
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = Color.Black)
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(Color.Green),
    ) {
        TextCustom()
    }
}

@Composable
fun ButtonCustom(title: String, color : Color) {

    val context = LocalContext.current

    Button(
        onClick = {
                  context.startActivity(Intent(context, MainActivity2::class.java))
        },
        modifier = Modifier
            .border(width = 1.dp, color = Color.Black)
            .height(50.dp)
            .fillMaxWidth(0.8f),
        colors = ButtonDefaults.buttonColors(color),
    ) {
        TextCust(title)
    }
}

@Composable
fun TextCust(name: String) {
    Text(text = name, color = Color.Black)
}


@Composable
fun SimpleFilledTextFieldSample(hint : String) {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(hint) },
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 0.1.dp, color = Color.Black),
        colors = TextFieldDefaults.textFieldColors(Color.White),
    )
}

@Composable
fun OutlinedTextFieldSample(hint : String) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(value = hint, onValueChange = {text = it}, modifier = Modifier.fillMaxWidth())
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    MyJetpackComposeTheme {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            Greeting("Android")
            Greeting("Ikhwan")
            Spacer(modifier = Modifier.padding(10.dp))
//            TextCustom()
            SimpleFilledTextFieldSample("Name")
//            Spacer(modifier = Modifier.padding(30.dp))
//            ButtonTest()
//            Row() {
//                Greeting("Android")
//                Greeting("Ikhwan")
//                Column() {
//                    Greeting("Android")
//                    Greeting("Ikhwan")
//                }
//            }
            Spacer(modifier = Modifier.padding(10.dp))
            SimpleFilledTextFieldSample("Password")
            Spacer(modifier = Modifier.padding(10.dp))
            OutlinedTextFieldSample(hint = "Pass")
            Spacer(modifier = Modifier.padding(10.dp))
            ButtonCustom(title = "Ini Button", color = Color.Gray)
//            ButtonCustom(title = "Ini Button 2", color = Color.Cyan )
        }
    }
}