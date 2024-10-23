package com.example.streamingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.streamingapp.ui.theme.StreamingAPPTheme

class CategoryAdapter : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StreamingAPPTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    CategoryList(
                        categories = listOf("Fútbol", "Natación", "Atletismo"),
                        onCategoryClick = { category -> println("Clicked on: $category") }
                    )
                }
            }
        }
    }
}

@Composable
fun CategoryList(categories: List<String>, onCategoryClick: (String) -> Unit) {
    Column {
        categories.forEach { category ->
            CategoryItem(category = category, onClick = { onCategoryClick(category) })
        }
    }
}

@Composable
fun CategoryItem(category: String, onClick: () -> Unit) {
    BasicText(
        text = category,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        style = MaterialTheme.typography.bodyLarge
    )
}

@Preview(showBackground = true)
@Composable
fun CategoryListPreview() {
    StreamingAPPTheme {
        CategoryList(
            categories = listOf("Fútbol", "Natación", "Atletismo"),
            onCategoryClick = { category -> println("Clicked on: $category") }
        )
    }
}

