package com.example.listapeliculas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.example.listapeliculas.data.ResultMovie
import com.example.listapeliculas.ui.theme.ListaPeliculasTheme

@Composable
fun InfoScreen(model: MainViewModel){
    val firstMovie=model.mainmovie.observeAsState(ResultMovie()).value
    InfoScreenCom(resultMovie = firstMovie)
}

@Composable
fun InfoScreenCom(resultMovie: ResultMovie){
    Column(modifier = Modifier.fillMaxSize(),
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,) {
        Text(text = resultMovie.title, style = MaterialTheme.typography.h5)
        AsyncImage(
            model = "https://image.tmdb.org/t/p/w300${resultMovie.posterPath}",
            placeholder = painterResource(R.drawable.logomovie),
            contentDescription = resultMovie.title
        )
        Text(text = resultMovie.overview)
    }
}

@Preview(showBackground = true)
@Composable
fun InfoPreview() {
    ListaPeliculasTheme {
        InfoScreenCom(resultMovie = ResultMovie(title = "Titulo", overview = "Contenido de la pelicula", posterPath = "/lyP4WNmUiiOgl4g2z7ywE0z6SGF.jpg"))
    }
}