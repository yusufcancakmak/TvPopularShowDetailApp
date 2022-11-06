package com.yusufcancakmak.seriestodogameapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.yusufcancakmak.seriestodogameapp.adapter.TvShowadapter
import com.yusufcancakmak.seriestodogameapp.databinding.ActivityMainBinding
import com.yusufcancakmak.seriestodogameapp.viewmodel.TvShowViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var tvshowAdapter:TvShowadapter
    private val viewModel:TvShowViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setupRv()
    }
    private fun setupRv(){
        tvshowAdapter= TvShowadapter()
       binding.rv.apply {
           adapter=tvshowAdapter
           layoutManager=LinearLayoutManager(this@MainActivity)
            layoutManager=GridLayoutManager(this@MainActivity,2)

       }
        viewModel.responseTvShow.observe(this,{listTvShow ->
            tvshowAdapter.tvShows=listTvShow

        })
    }
}