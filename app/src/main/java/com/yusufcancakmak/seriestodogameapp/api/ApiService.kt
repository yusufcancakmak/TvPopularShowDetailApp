package com.yusufcancakmak.seriestodogameapp.api

import com.yusufcancakmak.seriestodogameapp.helper.Contants
import com.yusufcancakmak.seriestodogameapp.modeltwo.TvShowDetail
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Contants.ENTER_POINT)
    suspend fun getAllTvDetail():Response<TvShowDetail>
}