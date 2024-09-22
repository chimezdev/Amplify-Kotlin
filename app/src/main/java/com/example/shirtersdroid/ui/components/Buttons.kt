package com.example.shirtersdroid.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shirtersdroid.R
import com.example.shirtersdroid.ui.theme.buttonStyle
import com.example.shirtersdroid.ui.theme.disabledButtonColor


@Composable
fun GenericButton(
    modifier: Modifier = Modifier,
    label: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    val isDarkTheme = isSystemInDarkTheme()
    Button(
        modifier = Modifier,
        enabled = enabled,
        onClick = onClick,
        shape = RectangleShape,
        colors = ButtonColors(
            contentColor = if (isDarkTheme) Color.Black else Color.White,
            containerColor = if (isDarkTheme) Color.White else Color.Black,
            disabledContentColor = if (isDarkTheme) Color.White else Color.Black,
            disabledContainerColor = disabledButtonColor
        )
    ) {
        Row(
            modifier = modifier
                .padding(horizontal = 10.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Text(
                text = label,
                textAlign = TextAlign.Center,
                style = buttonStyle,
                )
        }

    }
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ButtonPreview() {
//    GenericButton(label = "Log In", onClick = {})
    ButtonWithImage(label = "Log In", image = R.drawable.google_icon, onClick = {})
}

@Composable
fun ButtonWithImage(
    modifier: Modifier = Modifier,
    label: String,
    image: Int? = null,
    imageSize: Int = 32,
    spaceBetween:Int = 60,
    enabled: Boolean = false,
    borderColor: Color = Color(0xFFB8C0CC),
    onClick: () -> Unit
) {
    val isDarkTheme = isSystemInDarkTheme()
    OutlinedButton(
        modifier = modifier.border(width = 1.dp, color = borderColor, shape = RectangleShape),
        enabled = enabled,
        onClick = onClick,
        shape = RectangleShape,
        colors = ButtonColors(
            contentColor = if (isDarkTheme) Color.White else Color.Black,
            containerColor = if (isDarkTheme) Color.Black else Color.White,
            disabledContentColor = Color.White,
            disabledContainerColor = disabledButtonColor
        )
    ) {
        Row(
            modifier = modifier
//                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            if (image != null) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "$label logo",
                    modifier = Modifier.size(imageSize.dp)
                )
                Spacer(modifier = Modifier.width(spaceBetween.dp))
            }
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = label,
//                textAlign = TextAlign.Center,
                style = buttonStyle,
                )
        }

    }
}

@Composable
fun SOutlinedButton(
    modifier: Modifier = Modifier,
    label: String,
    enabled: Boolean = false,
    borderColor: Color = Color(0xFFB8C0CC),
    onClick: () -> Unit
) {
    val isDarkTheme = isSystemInDarkTheme()
    OutlinedButton(
        modifier = modifier.border(width = 1.dp, color = borderColor, shape = RectangleShape),
        enabled = enabled,
        onClick = onClick,
        shape = RectangleShape,
        colors = ButtonColors(
            contentColor = if (isDarkTheme) Color.White else Color.Black,
            containerColor = if (isDarkTheme) Color.Black else Color.White,
            disabledContentColor = Color.White,
            disabledContainerColor = disabledButtonColor
        )
    ) {
            Text(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 12.dp),
                text = label,
                textAlign = TextAlign.Center,
                style = buttonStyle,
            )
    }
}