package com.yusufcancakmak.seriestodogameapp.modeltwo


import com.google.gson.annotations.SerializedName

data class TvShowDetail(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<ResultItem>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)