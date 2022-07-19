package br.com.insightlabs.pokedex.presentation.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.insightlabs.pokedex.presentation.detail.compose.DetailScreen

@Composable
fun DetailRoute(
    onBackClick: () -> Unit,
    viewModel: DetailScreenViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    DetailScreen(
        pokemonStats = state.pokemonStats,
        isLoading = state.isLoading,
        onBackClick = onBackClick
    )
}