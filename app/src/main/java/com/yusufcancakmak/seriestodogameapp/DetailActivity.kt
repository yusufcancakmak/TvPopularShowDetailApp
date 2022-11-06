package com.yusufcancakmak.seriestodogameapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.yusufcancakmak.seriestodogameapp.databinding.ActivityDetailBinding
import com.yusufcancakmak.seriestodogameapp.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
         val IMAGE_BASE="https://image.tmdb.org/t/p/w500/"

        val intent=getIntent()
       val name= intent.getStringExtra("name")
        val language= intent.getStringExtra("langaue")
        val popularity= intent.getDoubleExtra("popularity",0.0)
        val overview= intent.getStringExtra("overview")
        val vote= intent.getDoubleExtra("vote",0.0)
        val airdate= intent.getStringExtra("air_date")
        val poster= intent.getStringExtra("poster")
        val poster_pat= intent.getStringExtra("poster_path")


        Glide.with(this@DetailActivity).load(IMAGE_BASE+poster).into(binding.imageView2)
        Glide.with(this@DetailActivity).load(IMAGE_BASE+poster_pat).into(binding.imageView3)



        binding.nameDetail.text=name.toString()
        binding.language.text="Language :"+language.toString()
        binding.ppularity.text="Popularity :"+popularity.toString()
        binding.overview.text=overview.toString()
        binding.vote.text=vote.toString()
        binding.textView7.text=airdate.toString()

    }
}