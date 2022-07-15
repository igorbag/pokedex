package br.com.insightlabs.pokedex.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.insightlabs.pokedex.ui.theme.PokedexTheme

@Composable
fun Subtitle() {
    Text(
        "Escolha seu pokemon",
        style = MaterialTheme.typography.subtitle1,
        modifier = Modifier.padding(start = 16.dp),
        color = MaterialTheme.colors.onBackground
    )
}

@Preview(showBackground = true)
@Composable
fun SubtitlePreview() {
    PokedexTheme {
        Subtitle()
    }
}