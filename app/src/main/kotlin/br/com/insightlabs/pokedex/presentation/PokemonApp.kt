package br.com.insightlabs.pokedex.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import br.com.insightlabs.pokedex.presentation.features.chooseyou.navigation.ChooseYouNavigation
import br.com.insightlabs.pokedex.presentation.features.chooseyou.navigation.chooseYouGraph
import br.com.insightlabs.pokedex.presentation.features.detail.navigation.DetailNavigation
import br.com.insightlabs.pokedex.presentation.features.detail.navigation.detailGraph
import br.com.insightlabs.pokedex.presentation.features.list.navigation.ListNavigation
import br.com.insightlabs.pokedex.presentation.features.list.navigation.listGraph
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
                navigateToChooseYou = {
                    navController.navigate(ChooseYouNavigation.route)
                },
                nestedGraphs = {
                    detailGraph {
                        navController.popBackStack()
                    }
                    chooseYouGraph {
                        navController.popBackStack()
                    }
                })
        }
    }
}