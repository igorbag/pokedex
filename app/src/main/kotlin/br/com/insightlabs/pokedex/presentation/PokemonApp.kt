package br.com.insightlabs.pokedex.presentation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import br.com.insightlabs.pokedex.presentation.detail.navigation.DetailNavigation
import br.com.insightlabs.pokedex.presentation.detail.navigation.detailGraph
import br.com.insightlabs.pokedex.presentation.list.navigation.ListNavigation
import br.com.insightlabs.pokedex.presentation.list.navigation.listGraph
import br.com.insightlabs.pokedex.ui.theme.PokedexTheme

@Composable
fun PokemonApp() {
    PokedexTheme {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = ListNavigation.route
        ) {
            listGraph(
                navigateToDetail = { id, pokemonName ->
                    navController.navigate("${DetailNavigation.route}/$id/$pokemonName")
                },
                nestedGraphs = {
                    detailGraph {
                        navController.popBackStack()
                    }
                })
        }
    }
}