package br.com.insightlabs.pokedex.presentation.features.detail.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.insightlabs.pokedex.R
import br.com.insightlabs.pokedex.domain.model.PokemonStats
import br.com.insightlabs.pokedex.presentation.components.Header
import br.com.insightlabs.pokedex.presentation.components.ProgressLoading
import br.com.insightlabs.pokedex.ui.theme.TextWhite
import coil.compose.SubcomposeAsyncImage

@Composable
fun DetailScreen(
    pokemonStats: PokemonStats,
    isLoading: Boolean,
    onBackClick: () -> Unit = {},
) {
    Header()
    Column {
        if (isLoading) {
            ProgressLoading()
        }

        TopAppBar(
            title = { Text(pokemonStats.name) },
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = TextWhite,
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = null)
                }
            },
            actions = {
                Text(
                    text = "#${pokemonStats.id}",
                    modifier = Modifier.padding(end = 16.dp),
                    color = TextWhite
                )
            }
        )
        SubcomposeAsyncImage(
            model = stringResource(id = R.string.url_image_pokemon, pokemonStats.id),
            loading = {
                CircularProgressIndicator(
                    modifier = Modifier.scale(0.5f)
                )
            },
            contentDescription = "Teste",
            contentScale = ContentScale.Fit,
            modifier = Modifier.aspectRatio(16f / 9f),
        )
        LazyColumn(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        ) {
            items(pokemonStats.stats) { item ->
                Column(modifier = Modifier.padding(top = 16.dp)) {
                    Text(
                        text = item.stat.name,
                        fontWeight = FontWeight.Bold,
                    )
                    LinearProgressIndicator(
                        progress = item.baseStat.toFloat() / 100,
                        modifier = Modifier
                            .height(16.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}
