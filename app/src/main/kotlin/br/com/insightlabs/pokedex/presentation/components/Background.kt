package br.com.insightlabs.pokedex.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.insightlabs.pokedex.R
import coil.compose.SubcomposeAsyncImage

@Composable
fun Background(
    content: @Composable () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {
        content()
    }
}

@Composable
fun ImageBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.ic_pokemon_grass_field),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.8f)
        )

        Background(content)
    }
}

@Preview
@Composable
private fun ImageBackgroundPreview() {
    ImageBackground {
        Column(
            modifier = Modifier
                .padding(top = 63.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Pikachu",
                style = MaterialTheme.typography.h3.copy(
                    color = Color.White,
                    fontSize = 45.sp
                )
            )
            Text(
                text = "eu escolho você",
                style = MaterialTheme.typography.h5.copy(
                    color = Color.White,
                    fontSize = 24.sp
                )
            )
            SubcomposeAsyncImage(
                modifier = Modifier.width(100.dp),
                model = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
                loading = {
                    CircularProgressIndicator(
                        modifier = Modifier.scale(0.5f)
                    )
                },
                contentDescription = "Teste",
                contentScale = ContentScale.Fit,
            )
        }
    }
}
