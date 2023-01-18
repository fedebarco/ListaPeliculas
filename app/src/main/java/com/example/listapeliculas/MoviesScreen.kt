package com.example.listapeliculas

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.listapeliculas.data.NavState
import com.example.listapeliculas.data.ResultMovie
import com.example.listapeliculas.ui.theme.ListaPeliculasTheme

@Composable
fun MoviesScreen(model: MainViewModel){
    val listmovie=model.listmovies.observeAsState(listOf()).value
    val (accion,setAccion)= remember{ mutableStateOf(NavState(false,1))}

    if (accion.change){
            model.goTodetail(accion.actual)
            setAccion(NavState(false,1))
    }

    MoviesScreenCo(listmovie = listmovie, onMovieChange = setAccion)
}

@Composable
fun MoviesScreenCo(listmovie:List<ResultMovie>,onMovieChange: (NavState) -> Unit){
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text(text = "Tendencias", style = MaterialTheme.typography.h5)
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 128.dp)

        ) {
            items(listmovie.size) { mo ->
                MovieDetail(movire = listmovie[mo], index = mo, onMovieChange = onMovieChange)
                //Text(text = mo.title)
            }
        }
    }

}

@Composable
fun MovieDetail(movire: ResultMovie, index:Int,onMovieChange: (NavState) -> Unit){
    Column(modifier = Modifier.clickable { onMovieChange(NavState(true,index)) },
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        AsyncImage(model = "https://image.tmdb.org/t/p/w300${movire.posterPath}"
                ,placeholder = painterResource(R.drawable.logomovie)
            ,contentDescription =null )
        Text(text =movire.title)
    }
}

@Preview(showBackground = true)
@Composable
fun MoviesPreview() {
    val resultm=ResultMovie(title = "Titulo", overview = "Contenido de la pelicula", posterPath = "/lyP4WNmUiiOgl4g2z7ywE0z6SGF.jpg")
    val (accion,setAccion)= remember{ mutableStateOf(NavState(false,1))}
    if (accion.change){
        Log.e("accion", "MoviesPreview: "+"se pulso en voton", )
    }
    ListaPeliculasTheme {
        MoviesScreenCo(listOf(resultm,resultm,resultm,resultm),setAccion)
    }
}