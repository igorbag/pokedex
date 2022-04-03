package br.com.insightlabs.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.insightlabs.pokedex.ui.theme.PokedexTheme
import coil.compose.SubcomposeAsyncImage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Content()
                }
            }
        }
    }
}

@Composable
fun Content() {
    Row(modifier = Modifier.padding(all = 16.dp)) {
        Column {
            Title()
            Subtitle()
            Row(verticalAlignment = Alignment.CenterVertically) {
                SubcomposeAsyncImage(
                    model = "https://source.unsplash.com/user/c_v_r/300x300",
                    loading = {
                        CircularProgressIndicator()
                    },
                    contentDescription = stringResource(R.string.app_name),
                )
                Column {
                    Text("Poke")
                    Text("Arram")
                }

            }

            Pokemons(arrayListOf("asd", "Picaxu", "Nelson"))
        }
    }
}

@Composable
fun Title() {
    Text(
        stringResource(R.string.app_name),
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    )
}

@Composable
fun Subtitle() {
    Text(
        stringResource(R.string.label_subtitle)
    )
}


@Composable
fun Pokemons(pokemons: List<String>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(pokemons) { pokemon ->
            Row(
                modifier = Modifier.fillMaxWidth()
                    .wrapContentHeight().clickable {},
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    pokemon,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PokedexTheme {
    }
}