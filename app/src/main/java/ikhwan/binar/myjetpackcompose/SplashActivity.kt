package ikhwan.binar.myjetpackcompose

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ikhwan.binar.myjetpackcompose.ui.theme.MyJetpackComposeTheme

class SplashActivity : ComponentActivity() {
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
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        ImageSplash()
                        TextSplash("Android")
                    }
                }
            }
        }

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }, 3000)
    }
}

@Composable
fun TextSplash(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun ImageSplash() {
    Image(
        painter = painterResource(id = R.drawable.ic_android_black_24dp,),
        contentDescription = "Image",
        modifier = Modifier
            .height(150.dp)
            .width(150.dp)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview2() {
    MyJetpackComposeTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ImageSplash( )
            TextSplash("Android")
        }

    }
}