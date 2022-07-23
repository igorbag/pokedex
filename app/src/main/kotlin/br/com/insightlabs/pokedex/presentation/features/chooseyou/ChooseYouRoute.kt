package br.com.insightlabs.pokedex.presentation.features.chooseyou

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.insightlabs.pokedex.presentation.features.chooseyou.compose.ChooseYouScreen

@Composable
fun ChooseYouRoute(
    onBackClick: () -> Unit,
    viewModel: ChooseYouViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    ChooseYouScreen(
        pokemon = state.pokemon,
        isLoading = state.isLoading,
        onBackClick = onBackClick
    )
}