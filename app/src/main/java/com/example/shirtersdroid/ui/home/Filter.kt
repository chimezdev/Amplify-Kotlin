package com.example.shirtersdroid.ui.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shirtersdroid.R
import com.example.shirtersdroid.ui.components.GenericButton
import com.example.shirtersdroid.ui.theme.epilogueFontFamily

@Composable
fun Filter(
    onCloseClicked:()->Unit,
    onBackClicked:()->Unit,
) {
    FilterContent(
        onBackClicked = onBackClicked,
        onCloseClicked = onCloseClicked
    )
}

@Composable
fun FilterContent(
    onCloseClicked:()->Unit,
    onBackClicked:()->Unit,
) {
    val isDark = isSystemInDarkTheme()
    val textColor = if (isDark) Color.White else Color.Black
    val bgColor = if (isDark) Color.Black else Color.White
    val checkBoxTextStyle = TextStyle(
        fontFamily = epilogueFontFamily,
        fontWeight = W400,
        fontSize = 18.sp,
        lineHeight = 18.45.sp,
        color = textColor
    )
    val scrollableState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = bgColor)
            .padding(vertical = 40.dp, horizontal = 27.dp)
            .verticalScroll(scrollableState),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.clickable {
                    onBackClicked()
                },
                painter = painterResource(id = if (isDark) R.drawable.back_icon_dark else R.drawable.back_icon),
                contentDescription = "Back arrow"
            )
            Text(
                text = "Filter", style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontWeight = W600,
                    fontSize = 24.sp,
                    lineHeight = 28.sp
                )
            )
            Image(
                modifier = Modifier.clickable {
                    onCloseClicked()
                },
                painter = painterResource(id = if(isDark)R.drawable.white_close else R.drawable.black_close),
                contentDescription = "Close icon"
            )
        }
        Spacer(modifier = Modifier.height(63.45.dp))
        Row(
            modifier = Modifier.fillMaxWidth(0.8f),
            horizontalArrangement = Arrangement.Start
        ) {
            Column(
                modifier = Modifier,
            ) {
                var isCheckedTshirt by remember { mutableStateOf(true) }
                var isCheckedPolo by remember { mutableStateOf(true) }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Checkbox(
                        checked = isCheckedTshirt,
                        onCheckedChange = { isCheckedTshirt = it },
                        colors = CheckboxDefaults.colors(checkedColor = if(isDark) Color.White else Color.Black),
                    )
                    Text(text = "T-Shirt", style = checkBoxTextStyle)
                }

                Spacer(modifier = Modifier.width(16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Checkbox(
                        checked = isCheckedPolo,
                        onCheckedChange = { isCheckedPolo = it },
                        colors = CheckboxDefaults.colors(checkedColor = if(isDark) Color.White else Color.Black)
                    )
                    Text(text = "Vest", style = checkBoxTextStyle)
                }
            }
            Spacer(modifier = Modifier.height(23.dp))
            Column(
                modifier = Modifier,
            ) {
                var isCheckedTshirt by remember { mutableStateOf(false) }
                var isCheckedPolo by remember { mutableStateOf(false) }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Checkbox(
                        checked = isCheckedTshirt,
                        onCheckedChange = { isCheckedTshirt = it },
                        colors = CheckboxDefaults.colors(checkedColor = if(isDark) Color.White else Color.Black),
                    )
                    Text(text = "Polo", style = checkBoxTextStyle)
                }

                Spacer(modifier = Modifier.width(16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Checkbox(
                        checked = isCheckedPolo,
                        onCheckedChange = { isCheckedPolo = it },
                        colors = CheckboxDefaults.colors(checkedColor = if(isDark) Color.White else Color.Black)
                    )
                    Text(text = "Hoodie", style = checkBoxTextStyle)
                }

            }
        }
        Spacer(modifier = Modifier.height(32.16.dp))
        Text(
            text = "Select Your Size", style = TextStyle(
                fontFamily = epilogueFontFamily,
                fontWeight = W600,
                fontSize = 18.sp,
                lineHeight = 18.45.sp,
                color = textColor
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            SizeSelector(
                sizes = listOf("XS", "S", "M", "L", "XL"),
                initialSelectedSize = "XS"
            )

        }
        Spacer(modifier = Modifier.height(35.84.dp))
        Text(
            text = "Colour", style = TextStyle(
                fontFamily = epilogueFontFamily,
                fontWeight = W600,
                fontSize = 18.sp,
                lineHeight = 18.45.sp,
                color = textColor
            )
        )
        Spacer(modifier = Modifier.height(13.99.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent),
        ) {
            ColorSelector(
                colors = listOf(Color.Black, Color(0xFFB8C0CC), Color(0xFFEF4444), Color(0xFFF59E0B),Color(0xFF34D399)),
                initialSelectedColor = Color.Black
            )

        }
        Spacer(modifier = Modifier.height(35.84.dp))
        Text(
            text = "Price", style = TextStyle(
                fontFamily = epilogueFontFamily,
                fontWeight = W600,
                fontSize = 18.sp,
                lineHeight = 18.45.sp,
                color = textColor
            )
        )
        Spacer(modifier = Modifier.height(16.dp))

        Spacer(modifier = Modifier.height(16.13.dp))
        PriceSlider(textColor = textColor)
        Spacer(modifier = Modifier.height(48.79.dp))
        GenericButton(
            modifier = Modifier.fillMaxWidth(),
            label = "Apply Filter"
        ) {
            
        }
    }
}

@Composable
fun PriceSlider(
    textColor: Color
) {
    // State for the slider values
    var range by remember { mutableStateOf(200f to 1500f) }

    // Displaying the current range values
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            PriceBox(
                text = range.first.toInt().toString(),
                textColor = textColor
            )
            PriceBox(
                text = range.second.toInt().toString(),
                textColor = textColor
            )
        }
        RangeSlider(
            value = range.first .. range.second,
            onValueChange = { newRange ->
                range = newRange.start to newRange.endInclusive
                            },
            valueRange = 200f..1500f,
            steps = 10,
            modifier = Modifier.fillMaxWidth(),
            colors = SliderDefaults.colors(
                thumbColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                activeTrackColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                activeTickColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                inactiveTickColor = Color.Gray,

            ),
        )
    }
}

@Composable
fun PriceBox(
    text: String,
    textColor: Color,
){
    Box(
        modifier = Modifier
            .size(width = 84.dp, height = 45.74.dp)
            .border(1.dp, Color(0xFFB8C0CC)),
        contentAlignment = Alignment.Center
    ){
        Text(text = text, style = TextStyle(
            fontWeight = W400,
            fontFamily = epilogueFontFamily,
            lineHeight = 20.sp,
            fontSize = 16.sp,
            color = textColor
        )
        )
    }
}

@Composable
fun ColorSelector(
    colors: List<Color>,
    initialSelectedColor: Color
) {
    var selectedColor by remember { mutableStateOf(initialSelectedColor) }

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        colors.forEach { color ->
            ClickableRectangleColor(
                color = color,
                borderColor = Color.Black,
                isSelected = color == selectedColor,
                borderBgColor = if (color == selectedColor) Color.LightGray else Color.Transparent,
                onClick = {
                    selectedColor = color
                }
            )
        }
    }
}

@Composable
fun ClickableRectangleColor(
    color: Color,
    isSelected:Boolean,
    borderColor: Color,
    borderBgColor: Color = Color.Transparent,
    onClick: () -> Unit
){
//    var isToggled by remember { mutableStateOf(false) }
    Box(modifier = Modifier
        .size(60.dp)
        .border(2.dp,borderColor)
        .background(borderBgColor)
        .clickable {
            onClick()
        }
    ){
        Canvas(
            modifier = Modifier
                .size(50.dp)

        ) {
            drawRect(
                color = color,
                size = Size(52.dp.toPx(), 52.dp.toPx()),
                topLeft = Offset(4.dp.toPx(), 4.dp.toPx())
            )
        }
    }
}

@Composable
fun SizeSelector(
    sizes: List<String>,
    initialSelectedSize: String
) {
    var selectedSize by remember { mutableStateOf(initialSelectedSize) }
    val isDarkMode = isSystemInDarkTheme()
    val scrollState = rememberScrollState()

    Row(
        modifier = Modifier.fillMaxWidth().horizontalScroll(scrollState),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        sizes.forEach { size ->
            ClickableRectangleText(
                text = size,
                isToggled = size == selectedSize,
                initialTextColor = if (isDarkMode) Color.White else Color.Black,
                initialBackgroundColor = if (isDarkMode) Color.Black else Color.White,
                toggledTextColor = if (isDarkMode) Color.Black else Color.White,
                toggledBackgroundColor = if (isDarkMode) Color.White else Color.Black,
                onClick = {
                    selectedSize = size
                }
            )
        }
    }
}

@Composable
fun ClickableRectangleText(
    text:String,
    width:Float = 56f,
    height:Float = 56f,
    isToggled:Boolean,
    initialTextColor: Color,
    initialBackgroundColor: Color,
    toggledTextColor: Color,
    toggledBackgroundColor: Color,
    onClick: () -> Unit
) {

    val currentTextColor = if (isToggled) toggledTextColor else initialTextColor
    val currentBackgroundColor = if (isToggled) toggledBackgroundColor else initialBackgroundColor
    Box(
        modifier = Modifier
            .height(height.dp)
            .width(width.dp)
            .background(currentBackgroundColor)
            .border(
                1.dp,
                color = Color(0xFFB8C0CC),//if (currentBackgroundColor == Color.White) Color(0xFFB8C0CC) else Color.Transparent
            )
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = currentTextColor,
            style = TextStyle(
                fontFamily = epilogueFontFamily,
                fontWeight = W600,
                fontSize = 18.sp,
                lineHeight = 18.45.sp,
                color = currentTextColor
            )
        )
    }
}

@Preview(device = Devices.DEFAULT)
@Composable
fun FilterPreview() {
    Filter(
        onBackClicked = {},
        onCloseClicked = {}
    )
}
