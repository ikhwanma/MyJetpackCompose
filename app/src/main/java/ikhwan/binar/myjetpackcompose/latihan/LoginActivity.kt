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

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting2()
                }
            }
        }
    }
}

@Composable
fun Greeting2() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var uname by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier
                .fillMaxWidth()
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        )

        Button(onClick = {
            uname = "username : $username"
            pass = "password : $password"
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Login")
        }

        Text(text = uname, fontSize = 20.sp)
        Text(text = pass, fontSize = 20.sp)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview4() {
    MyJetpackComposeTheme {
        Greeting2()
    }
}