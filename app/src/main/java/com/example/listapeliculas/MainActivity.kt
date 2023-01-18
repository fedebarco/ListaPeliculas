package com.example.listapeliculas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.listapeliculas.data.NavState
import com.example.listapeliculas.ui.theme.ListaPeliculasTheme

class MainActivity : ComponentActivity() {
    val model:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListaPeliculasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainNavigation(model = model)
                    //Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun MainNavigation(model: MainViewModel){
    val navController = rememberNavController()
    val navState=model.navState.observeAsState(NavState(false)).value

    NavHost(navController = navController, startDestination = "movies_page") {
        composable("movies_page"){ MoviesScreen(model = model)}
        composable("info_page"){ InfoScreen(model = model)}
    }
    if (navState.change){
        if (navState.actual==0){
            navController.navigate("movies_page")
            model.navState.postValue(NavState(false,0))
        }else if(navState.actual==1){
            navController.navigate("info_page")
            model.navState.postValue(NavState(false,1))
        }
    }
}