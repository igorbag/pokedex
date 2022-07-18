package br.com.insightlabs.pokedex.presentation.list.compose

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.palette.graphics.Palette
import br.com.insightlabs.pokedex.R
import br.com.insightlabs.pokedex.domain.model.Pokemon
import br.com.insightlabs.pokedex.presentation.components.Header
import br.com.insightlabs.pokedex.presentation.components.Pokemons
import br.com.insightlabs.pokedex.presentation.components.Subtitle
import br.com.insightlabs.pokedex.presentation.components.Title


@Composable
fun ListScreen(
    pokemon: Pokemon,
    onDetailClick: (Int, String) -> Unit
) {
    Scaffold(
        topBar = {},
        content = {
            Header()
            Column {
                Title()
                Subtitle()
                Pokemons(
                    pokemon = pokemon,
                    onDetailClick
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                backgroundColor = MaterialTheme.colors.primary,
                modifier = Modifier.padding(16.dp),
                onClick = { }
            ) {
                Image(
                    painterResource(R.drawable.ic_pokeball),
                    contentDescription = "Escolher pokemon"
                )
            }
        }
    )
}