package com.example.learningapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningapp.ui.theme.LearningAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningAppTheme {
//                Surface (modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//                    GreetingText(
//                        message = "Happy Birthday",
//                        from =  "Collins"
//                    )
                GreetingImage(
                    message = "Happy Birthday",
                    from = "From Collins"
                )
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally, // Center text horizontally in the column
        modifier = modifier.fillMaxSize() // Make column fill the screen
    ) {
        Text(
            text = message,
            fontSize = 80.sp,
            lineHeight = 116.sp,
            modifier = Modifier
                .fillMaxWidth() // Make text fill the width to allow centering
                .padding(8.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 32.sp,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(
        R.drawable.mybirthday // Ensure this resource exists in res/drawable
    )

    Box(
        modifier = modifier.fillMaxSize(), // Ensure Box fills the screen
        contentAlignment = Alignment.Center // Center GreetingText over Image
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxSize() // Ensure Image fills the container
        )

        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Center) // Align text at the center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearningAppTheme {
//        GreetingText(
//            message = "Happy Birthday John",
//            from = "From Collins"
//        )

        GreetingImage(
            message = "Happy Birthday",
            from = "From Collins"
        )
    }
}
