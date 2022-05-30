package ikhwan.binar.myjetpackcompose.latihan

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ikhwan.binar.myjetpackcompose.MainActivity2
import ikhwan.binar.myjetpackcompose.latihan.ui.theme.MyJetpackComposeTheme

class MainLatihanActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting5()
                }
            }
        }
    }
}

@Composable
fun Greeting5() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(onClick = {
            context.startActivity(Intent(context, LoginActivity::class.java))
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Login")
        }

        Button(onClick = {
            context.startActivity(Intent(context, PaymentActivity::class.java))
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Payment")
        }

        Button(onClick = {
            context.startActivity(Intent(context, VolumeActivity::class.java))
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Volume")
        }
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview7() {
    MyJetpackComposeTheme {
        Greeting5()
    }
}