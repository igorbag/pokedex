package br.com.insightlabs.pokedex.presentation.features.chooseyou.compose

import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.insightlabs.pokedex.domain.model.Result
import br.com.insightlabs.pokedex.presentation.components.ImageBackground
import coil.compose.SubcomposeAsyncImage


@Composable
fun ChooseYouScreen(
    pokemon: Result,
    isLoading: Boolean,
    onBackClick: () -> Unit = {},
) {
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


