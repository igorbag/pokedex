package br.com.insightlabs.pokedex.presentation.features.chooseyou.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
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
        IconButton(
            modifier = Modifier.padding(16.dp),
            onClick = { onBackClick() }
        ) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "Exit",
                tint = Color.White
            )
        }
        Column(
            modifier = Modifier
                .padding(top = 150.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = pokemon.name.replaceFirstChar {
                    it.uppercase()
                },
                style = MaterialTheme.typography.h3.copy(
                    color = Color.White,
                    fontSize = 45.sp
                ),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "eu escolho você",
                style = MaterialTheme.typography.h5.copy(
                    color = Color.White,
                    fontSize = 24.sp
                )
            )
            SubcomposeAsyncImage(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .width(400.dp),
                model = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${pokemon.id}.png",
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

@Preview
@Composable
fun ChooseYouScreenPreview() {
    ChooseYouScreen(
        pokemon = Result(
            name = "Fake",
            url = "https://pokeapi.co/api/v2/pokemon/1/"
        ),
        isLoading = false,
        onBackClick = {},
    )
}


