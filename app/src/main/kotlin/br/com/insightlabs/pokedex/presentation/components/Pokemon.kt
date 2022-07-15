package br.com.insightlabs.pokedex.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import br.com.insightlabs.pokedex.domain.model.Pokemon
import coil.compose.SubcomposeAsyncImage


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Pokemons(
    pokemon: Pokemon,
    onDetailClick: (Int, String) -> Unit
) {

    Card(
        modifier = Modifier
            .padding(start = 2.dp, end = 2.dp, top = 12.dp)
            .fillMaxHeight(),
        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
    ) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(2)
        ) {
            items(pokemon.results) { pokemonItem ->

                Card(
                    shape = MaterialTheme.shapes.large,
                    modifier = Modifier.padding(16.dp),
                    onClick = {
                        onDetailClick(pokemonItem.id, pokemonItem.name)
                    },
                ) {
                    Column(
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        SubcomposeAsyncImage(
                            model = pokemonItem.imageUrl(),
                            loading = {
                                CircularProgressIndicator(
                                    modifier = Modifier.scale(0.5f)
                                )
                            },
                            contentDescription = pokemonItem.name,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.width(100.dp)
                        )
                        Text(
                            text = pokemonItem.name,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
        }
    }
}
