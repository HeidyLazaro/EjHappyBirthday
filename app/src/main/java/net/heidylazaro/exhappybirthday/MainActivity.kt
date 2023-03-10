package net.heidylazaro.exhappybirthday

import android.os.Bundle
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.heidylazaro.exhappybirthday.ui.theme.EjHappyBirthdayTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EjHappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //BirthdayGreetingWithText(message = "Feliz cumpleaños", from = "- Edd")
                    //Greeting(name = "android")
                    BirthdayGreetingWithImage(message = getString(R.string.happy_birthday_text), from = getString(
                                            R.string.signature_text))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}


@Composable
fun BirthdayGreetingWithText(message: String, from: String){
   Column{
       Text(
           text = message,
           fontSize = 36.sp,
           modifier = Modifier.fillMaxWidth().
           wrapContentWidth(Alignment.CenterHorizontally)
               .padding(start = 16.dp, top = 16.dp )
       )
       Text(
           text = from,
           fontSize = 24.sp,
           modifier = Modifier
               .fillMaxWidth()
               .wrapContentWidth(Alignment.End)
               .padding(start = 16.dp, end = 16.dp)
       )
   }
}

@Composable
fun BirthdayGreetingWithImage(message: String, from: String) {
    val image = painterResource(R.drawable.androidparty)
   Box() {
       Image(
           painter = image,
           contentDescription = null,
           modifier = Modifier.fillMaxHeight().fillMaxWidth(),
           contentScale = ContentScale.Crop
       )
       BirthdayGreetingWithText(message = message, from = from)
   }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    EjHappyBirthdayTheme {
        //Greeting("Jammes")
        //BirthdayGreetingWithText(message = "Happy Birthday Sam!", "-from Emma")
        BirthdayGreetingWithImage(message = "Happy Birthday Sam!", from = "- from Emma")
    }
}
/*fun DefaultPreview() {
    EjHappyBirthdayTheme {
        BirthdayGreetingWithText(message = "Happy Birthday Sam!", from = "- From Emma")
    }
}*/