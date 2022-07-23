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

package br.com.insightlabs.pokedex.presentation.features.list.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import br.com.insightlabs.pokedex.core.Navigation
import br.com.insightlabs.pokedex.presentation.features.list.ListRoute

object ListNavigation : Navigation {
    override val route = "list_route"
    override val destination = "list_destination"
}

fun NavGraphBuilder.listGraph(
    navigateToDetail: (Int, String) -> Unit,
    navigateToChooseYou: () -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit
) {
    navigation(
        route = ListNavigation.route,
        startDestination = ListNavigation.destination
    ) {
        composable(route = ListNavigation.destination) {
            ListRoute(
                navigateToDetail = navigateToDetail,
                navigateToChooseYou = navigateToChooseYou
            )
        }
        nestedGraphs()
    }
}