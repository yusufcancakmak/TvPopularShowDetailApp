package com.yusufcancakmak.seriestodogameapp.repository

import com.yusufcancakmak.seriestodogameapp.api.ApiService
import javax.inject.Inject

class TvShowRepository @Inject constructor(private val api:ApiService) {
    suspend fun getTvShows()=api.getAllTvDetail()
}