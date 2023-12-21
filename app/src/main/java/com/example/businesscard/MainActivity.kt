package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun Top() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        Image(painter = painterResource(id = R.drawable.android_logo), contentDescription = stringResource(
            id = R.string.logo_description),
            modifier = Modifier
                .size(150.dp)
                .background(color = Color.Black))
        Text(text = "Héuller", fontSize = 44.sp, fontWeight = FontWeight.Medium)
        Text(text = "Android Kotlin Developer", fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }

}

@Composable
fun Contact(icon:ImageVector, text:String, iconDescription: Int){
    Row(Modifier
        .padding(0.dp, 0.dp, 0.dp, 6.dp)){
        Icon(icon, contentDescription = stringResource(id = iconDescription), Modifier.size(26.dp))
        Text(text = text, Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp))
    }
}

//Icon as image
@Composable
fun Contact(icon:Painter, text:String, iconDescription: Int){
    Row(Modifier
            .padding(0.dp, 0.dp, 0.dp, 6.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, contentDescription = stringResource(id = iconDescription), Modifier.size(26.dp))
            Text(text = text, Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp))
        }

    }
}

@Composable
fun Bottom(){
    val githubIcon:Painter =  painterResource(id = R.drawable.github);
    Row(horizontalArrangement = Arrangement.Center, modifier =  Modifier.fillMaxWidth()) {
        Column {
            Contact(icon = githubIcon, text = "hllrdev", iconDescription = R.string.github_icon)
            Contact(icon = Icons.Rounded.Email, text = "hllrdev@gmail.com", iconDescription = R.string.phone_icon)
            Contact(icon = Icons.Rounded.Call, text = "+55 (35) 99735-4331", iconDescription = R.string.phone_icon)
        }
    }
}

@Composable
fun App(){
    Column(Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
        Top();
        Spacer(Modifier.height(120.dp));
        Bottom();
    }

}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    BusinessCardTheme {
        App()
    }
}