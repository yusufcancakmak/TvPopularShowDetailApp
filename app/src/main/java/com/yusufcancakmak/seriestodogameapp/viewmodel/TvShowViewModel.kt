package com.yusufcancakmak.seriestodogameapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusufcancakmak.seriestodogameapp.modeltwo.ResultItem
import com.yusufcancakmak.seriestodogameapp.repository.TvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class TvShowViewModel @Inject constructor(private val repository: TvShowRepository):ViewModel() {

    private val _response=MutableLiveData<List<ResultItem>>()

    val responseTvShow:LiveData<List<ResultItem>>
    get() = _response

    init {
        getAllTvShow()
    }
    private fun getAllTvShow()=viewModelScope.launch{
        repository.getTvShows().let {response ->

        if (response.isSuccessful){
            _response.postValue(response.body()!!.results)
        }else{
            Log.d("tag","getallTvShow Error ${response.code()}")
        }
        }
    }
}