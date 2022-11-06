package com.yusufcancakmak.seriestodogameapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yusufcancakmak.seriestodogameapp.DetailActivity
import com.yusufcancakmak.seriestodogameapp.databinding.TvShowAdapterItemBinding
import com.yusufcancakmak.seriestodogameapp.modeltwo.ResultItem

class TvShowadapter:RecyclerView.Adapter<TvShowadapter.MyViewHolder> (){

    inner class MyViewHolder(val binding: TvShowAdapterItemBinding):RecyclerView.ViewHolder(binding.root)
    private val IMAGE_BASE="https://image.tmdb.org/t/p/w500/"
    private lateinit var mcontext:Context


    private val diffcallback =object : DiffUtil.ItemCallback<ResultItem>(){
        override fun areItemsTheSame(oldItem: ResultItem, newItem: ResultItem): Boolean {
            return oldItem.id ==newItem.id
        }
        override fun areContentsTheSame(oldItem: ResultItem, newItem: ResultItem): Boolean {
            return  newItem ==oldItem
        }
    }
    private val differ= AsyncListDiffer(this,diffcallback)
    var tvShows:List<ResultItem>
        get() = differ.currentList
        set(value){
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(TvShowAdapterItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentshow=tvShows[position]
        holder.binding.apply {
            nametxt.text=currentshow.name.toString()
            poopularitytxt.text=currentshow.firstAirDate.toString()
            languagetxt.text="Languae: " +currentshow.originalLanguage.toString()
           // overviewtxt.text=currentshow.overview.toString()
            Glide.with(holder.itemView).load(IMAGE_BASE+currentshow.posterPath).into(holder.binding.imageView)

            carditem.setOnClickListener {
                val intent=Intent(holder.itemView.context,DetailActivity::class.java)
                intent.putExtra("name",currentshow.name)
                intent.putExtra("popularity",currentshow.popularity)
                intent.putExtra("langaue",currentshow.originalLanguage)
                intent.putExtra("overview",currentshow.overview)
                intent.putExtra("poster",currentshow.backdropPath)
                intent.putExtra("poster_path",currentshow.posterPath)
                intent.putExtra("vote",currentshow.voteAverage)
                intent.putExtra("air_date",currentshow.firstAirDate)





                holder.itemView.context.startActivity(intent)

            }
        }
    }

    override fun getItemCount()=tvShows.size
}