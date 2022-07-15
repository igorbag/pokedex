/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.insightlabs.pokedex.presentation.detail.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import br.com.insightlabs.pokedex.core.Navigation
import br.com.insightlabs.pokedex.presentation.detail.DetailRoute

object DetailNavigation : Navigation {
    override val route = "detail_route"
    override val destination = "detail_destination"
    const val pokemonIdArg = "pokemonId"
    const val pokemonNameArg = "pokemonNameArg"
}

fun NavGraphBuilder.detailGraph(onBackClick: () -> Unit) {
    composable(
        route = "${DetailNavigation.route}/{${DetailNavigation.pokemonIdArg}}/{${DetailNavigation.pokemonNameArg}}",
        arguments = listOf(
            navArgument(DetailNavigation.pokemonIdArg) {
                type = NavType.IntType
            },
            navArgument(DetailNavigation.pokemonNameArg) {
                type = NavType.StringType
            }
        )
    ) {
        DetailRoute(onBackClick)
    }
}
