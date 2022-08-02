package br.com.insightlabs.pokedex.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
                .padding(top = 60.dp)
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
                modifier = Modifier.width(250.dp),
                model = stringResource(id = R.string.url_image_pokemon, "1"),
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
