package br.com.insightlabs.pokedex.presentation.list

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.insightlabs.pokedex.presentation.list.compose.ListScreen

@Composable
fun ListRoute(
    navigateToDetail: (Int, String) -> Unit,
    viewModel: ListScreenViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    ListScreen(
        pokemon = state.pokemons,
        isLoading = state.isLoading,
        onDetailClick = navigateToDetail
    )
}