package com.example.shirtersdroid.ui.profile.faqs

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shirtersdroid.R
import com.example.shirtersdroid.ui.profile.TopBar
import com.example.shirtersdroid.ui.theme.epilogueFontFamily

@Composable
fun Faqs(
    navHostController: NavHostController
) {
    val isDarkMode = isSystemInDarkTheme()
    val faqs: List<Pair<String,String>> = listOf( Pair(
        "What is shirters","Lorem ipsum dolor sit amet, consectetur adipiscing elit. \" +\n" +
                "                    \"Adipiscing lacus, venenatis amet etiam nibh diam. Adipiscing \" +\n" +
                "                    \"sem velit augue tellus magna."
    ), Pair(
        "What is shirters","Lorem ipsum dolor sit amet, consectetur adipiscing elit. \" +\n" +
                "                    \"Adipiscing lacus, venenatis amet etiam nibh diam. Adipiscing \" +\n" +
                "                    \"sem velit augue tellus magna."
    ))
    var expandedIndex by remember { mutableIntStateOf(-1) }
    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = if (isDarkMode) Color.Black else Color(0xFFF2F2F2))
            .padding(horizontal = 24.dp, vertical = 26.5.dp),
    ) {
        TopBar(
            title = "FAQs",
            onBackPressed = { navHostController.navigateUp() }
        )
        Spacer(Modifier.height(43.5.dp))
        SearchableTextField(
            hintText = "Search for Question",
            onSearch = {}
        )
        Spacer(Modifier.height(32.dp))
        faqs.forEachIndexed { index, (question, answer) ->
            FAQItem(
                question = question,
                answer = answer,
                isExpanded = expandedIndex == index,
                onClick = {
                    expandedIndex = if (expandedIndex == index) -1 else index
                }
            )
            Spacer(Modifier.height(16.dp))
        }



    }
}


@Composable
fun FAQItem(
    question: String,
    answer: String,
    isExpanded: Boolean = false,
    onClick:() -> Unit,
    ) {
    val isDarkMode = isSystemInDarkTheme()
    val image = when{
        !isExpanded && isDarkMode -> R.drawable.dark_expand
        isExpanded && isDarkMode -> R.drawable.dark_collapse
        !isExpanded && !isDarkMode -> R.drawable.expand
        isExpanded && !isDarkMode -> R.drawable.collapse
        else -> R.drawable.expand
    }

    Column(modifier = Modifier.fillMaxWidth().background(if (isDarkMode) Color(0xFF333333) else Color.White).padding(top = 4.dp, start = 18.5.dp, end = 18.5.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth()

                .clickable { onClick() },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = question,
                modifier = Modifier.weight(1f).padding(16.dp),
                style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontSize = 14.sp,
                    fontWeight = W400,
                    lineHeight = 18.sp
                )
            )

            Image(
                painter = painterResource(image),
                contentDescription = "Expand/Collapse Button"
            )
        }

        AnimatedVisibility(visible = isExpanded) {
            Text(
                text = answer,
                modifier = Modifier.fillMaxWidth()
                    .background(if (isSystemInDarkTheme()) Color(0xFF333333) else Color.White)
                    .padding(horizontal = 11.dp, vertical = 18.5.dp),
                style = TextStyle(
                    fontFamily = epilogueFontFamily,
                    fontSize = 14.sp,
                    fontWeight = W400,
                    lineHeight = 18.sp
                )
            )
        }
    }
}


@Composable
fun SearchableTextField(
    hintText: String,
    onSearch: (String) -> Unit
) {
    var searchText by remember { mutableStateOf(TextFieldValue("")) }
    val isDarkMode = isSystemInDarkTheme()
    val textColor = if (isDarkMode) Color(0xFFF2F2F2) else Color(0xFF666666)
    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = searchText,
            onValueChange = { newText ->
                searchText = newText
                onSearch(newText.text)
            },
            placeholder = { Text(text = hintText) },
            leadingIcon = {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = "Search Icon",
                    tint = textColor
                )
            },
            modifier = Modifier.fillMaxWidth()
                .background(if (isDarkMode) Color(0xFF999999) else Color.White)
        )
    }
}


@Preview
@Composable
fun FaqsPreview() {
    Faqs(rememberNavController())
}