package com.example.listapeliculas

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listapeliculas.data.NavState
import com.example.listapeliculas.data.ResultMovie
import com.example.listapeliculas.internet.moviesApi
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {

    val listmovies=MutableLiveData(listOf<ResultMovie>())
    val mainmovie=MutableLiveData(ResultMovie())
    val navState=MutableLiveData(NavState(change = false, actual = 0))

    init {
        getMovies()
    }



    fun getMovies(){
        viewModelScope.launch {
            try {
                val messageResponse=moviesApi.retrofitService.movies("b454a2de0c24250d92c36c12c64fe743","es")
                listmovies.postValue(messageResponse.results)
                mainmovie.postValue(messageResponse.results[0])
            }catch (e: Exception){
                Log.e("ocurrio un error", "getMovies: "+e.toString(), )

            }

        }
    }

    fun goTodetail(position:Int){
        viewModelScope.launch {
            if (listmovies.value!!.isNotEmpty()){
                mainmovie.postValue(listmovies.value!![position])
                navState.postValue(NavState(true,1))
            }

        }

    }
}