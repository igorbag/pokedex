package br.com.insightlabs.pokedex.presentation.features.list.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.insightlabs.pokedex.R
import br.com.insightlabs.pokedex.domain.model.Result
import br.com.insightlabs.pokedex.presentation.components.Header
import br.com.insightlabs.pokedex.presentation.components.Pokemons
import br.com.insightlabs.pokedex.presentation.components.Subtitle
import br.com.insightlabs.pokedex.presentation.components.Title

@Composable
fun ListScreen(
    pokemon: List<Result>,
    isLoading: Boolean,
    onDetailClick: (Int, String) -> Unit,
    onPokeballClick: () -> Unit
) {
    Scaffold(
        topBar = {},
        content = {
            Header()
            Column {
                Title()
                Subtitle()
                Pokemons(
                    pokemons = pokemon,
                    isLoading = isLoading,
                    onDetailClick
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                backgroundColor = MaterialTheme.colors.primary,
                modifier = Modifier.padding(16.dp),
                onClick = onPokeballClick
            ) {
                Image(
                    painterResource(R.drawable.ic_pokeball),
                    contentDescription = "Escolher pokemon"
                )
            }
        }
    )
}
