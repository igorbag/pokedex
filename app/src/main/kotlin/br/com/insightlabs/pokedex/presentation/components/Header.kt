package br.com.insightlabs.pokedex.presentation.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.insightlabs.pokedex.ui.theme.PokedexTheme

@Composable
fun Header() {
    TopAppBar(
        title = { Text("My Application") },
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.aspectRatio(16f / 9f),
    )
}

@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    PokedexTheme {
        Header()
    }
}