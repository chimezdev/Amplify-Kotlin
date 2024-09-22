package com.example.shirtersdroid.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shirtersdroid.R
import com.example.shirtersdroid.ui.theme.epilogueFontFamily

@Composable
fun TextField1(
    modifier: Modifier = Modifier,
    label: String,
    maxLine: Int = 1,
    minLine: Int = 1,
    maxLength: Int = Int.MAX_VALUE,
    placeHolder: String,
    enable: Boolean = true,
    value: String,
    errorText: String? = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onValueChange: (String) -> Unit,
    onDone: () -> Unit,
    onNext: () -> Unit,
) {
    val isDarkMode = isSystemInDarkTheme()

    Column(
        modifier = Modifier
    ) {
        Text(
            text = label, style = TextStyle(
                fontFamily = epilogueFontFamily,
                fontSize = 18.sp,
                lineHeight = 18.45.sp,
                fontWeight = FontWeight.W800
            ), color = if (isDarkMode) Color.White else Color.Black
        )
        Spacer(modifier = Modifier.height(8.84.dp))

        OutlinedTextField(modifier = modifier.fillMaxWidth(),
            value = value,
            onValueChange = {
                if (it.length <= maxLength) {
                    onValueChange(it)
                }
            },
            enabled = enable,
            placeholder = {
                Text(
                    text = placeHolder, style = TextStyle(
                        fontFamily = epilogueFontFamily,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W400,
                        lineHeight = 18.45.sp
                    ), color = if (isDarkMode) Color(0xFFC2C2C2) else Color(0xFF666666)
                )
            },
            maxLines = maxLine,
            minLines = minLine,
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = if (isDarkMode) Color.White else Color.Black,
                disabledTextColor = Color.DarkGray,
                focusedBorderColor = Color(0xFFB8C0CC),
                unfocusedBorderColor = Color(0xFFB8C0CC),
                errorBorderColor = Color.Red,
                errorContainerColor = if (isDarkMode) Color(0xFFA0ABBB) else Color(0xFFB8C0CC),
                focusedContainerColor = if (isDarkMode) Color(0xFF666666) else Color.White,
                unfocusedContainerColor = if (isDarkMode) Color(0xFF666666) else Color.White,
//                focusedContainerColor = if (isDarkMode) Color(0xFFA0ABBB) else Color(0xFFB8C0CC),
//                unfocusedContainerColor = if (isDarkMode) Color(0xFFA0ABBB) else Color(0xFFB8C0CC),
            ),
            isError = !errorText.isNullOrBlank(),
            shape = RectangleShape,
            keyboardOptions = keyboardOptions,
            keyboardActions = KeyboardActions(onDone = {
                onDone()
            }, onNext = {
                onNext()
            })
        )
        if (!errorText.isNullOrBlank()) {
            Text(
                text = errorText, color = Color.Red, style = TextStyle(
                    fontFamily = epilogueFontFamily, fontWeight = FontWeight.W200, fontSize = 12.sp
                )
            )
        }
    }


}

@Composable
fun PasswordField1(
    modifier: Modifier = Modifier,
    label: String,
    maxLine: Int = 1,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    maxLength: Int = Int.MAX_VALUE,
    placeHolder: String,
    enable: Boolean = true,
    value: String,
    errorText: String? = "",
    onValueChange: (String) -> Unit,
    onNext: () -> Unit,
    onDone: () -> Unit,
) {
    val isDarkMode = isSystemInDarkTheme()
    var isPasswordHidden by remember {
        mutableStateOf(true)
    }

    Column(modifier = Modifier) {
        Text(
            text = label, style = TextStyle(
                fontFamily = epilogueFontFamily,
                fontSize = 18.sp,
                lineHeight = 18.45.sp,
                fontWeight = FontWeight.W800
            ), color = if (isDarkMode) Color.White else Color.Black
        )
        Spacer(modifier = Modifier.height(8.84.dp))

        OutlinedTextField(modifier = modifier,
            value = value,
            onValueChange = {
                if (it.length <= maxLength) {
                    onValueChange(it)
                }
            },
            enabled = enable,
            placeholder = {
                Text(
                    text = placeHolder, style = TextStyle(
                        fontFamily = epilogueFontFamily,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W400,
                        lineHeight = 18.45.sp
                    ), color = if (isDarkMode) Color(0xFFC2C2C2) else Color(0xFF666666)
                )
            },
            maxLines = maxLine,
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = if (isDarkMode) Color.White else Color.Black,
                disabledTextColor = Color.DarkGray,
                focusedBorderColor = Color(0xFFB8C0CC),
                unfocusedBorderColor = Color(0xFFB8C0CC),
                errorBorderColor = Color.Red,
                errorContainerColor = if (isDarkMode) Color(0xFFA0ABBB) else Color(0xFFB8C0CC),
                focusedContainerColor = if (isDarkMode) Color(0xFF666666) else Color.White,
                unfocusedContainerColor = if (isDarkMode) Color(0xFF666666) else Color.White,
//                focusedTrailingIconColor = Color.Black,
//                unfocusedTrailingIconColor = Color.Black
            ),
            isError = !errorText.isNullOrBlank(),
            shape = RectangleShape,
            keyboardOptions = keyboardOptions,
            keyboardActions = KeyboardActions(onDone = {
                onDone()
            }, onNext = {
                onNext()
            }),
            trailingIcon = {
                Icon(
                    modifier = Modifier.clickable {
                        isPasswordHidden = !isPasswordHidden
                    },
                    imageVector = if (isPasswordHidden) {
                        ImageVector.vectorResource(id = if (isDarkMode) R.drawable.password_dark else R.drawable.password)
                    } else ImageVector.vectorResource(id = R.drawable.hide_password),
                    contentDescription = null,
                    tint = Color.Unspecified
                )


            },
            visualTransformation = if (isPasswordHidden) {
                PasswordVisualTransformation()
            } else VisualTransformation.None
        )
        if (!errorText.isNullOrBlank()) {
            Text(
                text = errorText, color = Color.Red, style = TextStyle(
                    fontFamily = epilogueFontFamily, fontWeight = FontWeight.W200, fontSize = 12.sp
                )
            )
        }
    }


}

@Composable
fun CustomSearchBar(
    modifier: Modifier = Modifier,
    maxLine: Int = 1,
    maxLength: Int = Int.MAX_VALUE,
    placeHolder: String,
    enable: Boolean = true,
    value: String,
    errorText: String? = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onValueChange: (String) -> Unit,
    onSearchClicked: () -> Unit,
    onFilterClicked: () -> Unit,
) {
    val isDarkMode = isSystemInDarkTheme()
    val keyboard = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
    ) {

        OutlinedTextField(modifier = modifier.background(Color.Transparent),
            value = value,
            onValueChange = {
                if (it.length <= maxLength) {
                    onValueChange(it)
                }
            },
            enabled = enable,
            placeholder = {
                Text(
                    text = placeHolder, style = TextStyle(
                        fontFamily = epilogueFontFamily,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W400,
                        lineHeight = 18.45.sp
                    ), color = if (isDarkMode) Color(0xFFC2C2C2) else Color(0xFF666666)
                )
            },
            maxLines = maxLine,
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = if (isDarkMode) Color.White else Color.Black,
                disabledTextColor = Color.DarkGray,
                focusedBorderColor = Color(0xFFB8C0CC),
                unfocusedBorderColor = Color(0xFFB8C0CC),
                errorBorderColor = Color.Red,
                errorContainerColor = if (isDarkMode) Color(0xFFA0ABBB) else Color(0xFFB8C0CC),
                focusedContainerColor = if (isDarkMode) Color(0xFF666666) else Color.White,
                unfocusedContainerColor = if (isDarkMode) Color(0xFF666666) else Color.White,
//                focusedContainerColor = if (isDarkMode) Color(0xFFA0ABBB) else Color(0xFFB8C0CC),
//                unfocusedContainerColor = if (isDarkMode) Color(0xFFA0ABBB) else Color(0xFFB8C0CC),
            ),
            isError = !errorText.isNullOrBlank(),
            shape = RectangleShape,
            keyboardOptions = keyboardOptions,
            keyboardActions = KeyboardActions(onDone = {
                keyboard?.hide()
                onSearchClicked()
            }),
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.search_icon),
                    contentDescription = "Search Icon",
                    tint = if (isDarkMode) Color(0xFFC2C2C2) else Color(0xFF666666),
                    modifier = Modifier.clickable {
                        onSearchClicked()
                    }
                )
            },
            trailingIcon = {
                Box(
                    modifier = Modifier
                        .background(color = if (isDarkMode) Color.White else Color.Black)
                        .size(56.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = if (isDarkMode) R.drawable.filter_dark else R.drawable.filter_light),
                        contentDescription = "Search Icon",
                        tint = if (isDarkMode) Color.Black else Color.White,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                onFilterClicked()
                            }
                    )
                }
            },
        )
            }
}

@Preview
@Composable
fun TextFieldPreview() {
    CustomSearchBar(
        placeHolder = "Search for collections and Clothes",
        value = "",
//        errorText = "error",
        onValueChange = {},
        onFilterClicked = {},
        onSearchClicked = {}
    )
//    PasswordField1(label = "Email Address",
//        placeHolder = "xxx@gmail.com",
//        value = "",
//        onValueChange = {},
//        onNext = {},
//        onDone = {})
}