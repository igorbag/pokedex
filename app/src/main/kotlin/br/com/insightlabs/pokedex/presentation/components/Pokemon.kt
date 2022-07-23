package br.com.insightlabs.pokedex.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.insightlabs.pokedex.domain.model.Result
import br.com.insightlabs.pokedex.presentation.features.list.ListScreenViewModel
import coil.compose.SubcomposeAsyncImage


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Pokemons(
    pokemons: List<Result>,
    isLoading: Boolean,
    onDetailClick: (Int, String) -> Unit,
    viewModel: ListScreenViewModel = hiltViewModel()
) {
    val listState = rememberLazyListState()

    Card(
        modifier = Modifier
            .padding(start = 2.dp, end = 2.dp, top = 12.dp)
            .fillMaxHeight(),
        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
    ) {
        if (isLoading) {
            ProgressLoading()
        }

        LazyVerticalGrid(
            state = listState,
            cells = GridCells.Fixed(2)
        ) {
            items(pokemons) { pokemonItem ->

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

        listState.OnBottomReached {
            viewModel.getAllPokemons()
        }

    }
}

@Composable
fun LazyListState.OnBottomReached(
    loadMore: () -> Unit
) {
    val shouldLoadMore = remember {
        derivedStateOf {
            val lastVisibleItem = layoutInfo.visibleItemsInfo.lastOrNull()
                ?: return@derivedStateOf true

            lastVisibleItem.index == layoutInfo.totalItemsCount - 1
        }
    }

    // Convert the state into a cold flow and collect
    LaunchedEffect(shouldLoadMore) {
        snapshotFlow { shouldLoadMore.value }
            .collect {
                // if should load more, then invoke loadMore
                if (it) loadMore()
            }
    }
}
