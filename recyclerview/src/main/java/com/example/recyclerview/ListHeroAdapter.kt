package com.example.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_row_hero.view.*

class ListHeroAdapter(private val arraylistHero: ArrayList<Hero>): RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = arraylistHero.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(arraylistHero[position])
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(hero: Hero){
            with(itemView){
                Glide.with(itemView.context).load(hero.photo)
                    .apply(RequestOptions.skipMemoryCacheOf(true))
                    .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                    .override(55, 55)
                    .into(img_item_photo)

//                Picasso.with(itemView.context).load(hero.photo).into(img_item_photo)
                Log.d("wasd", hero.photo)

                tv_item_name.text = hero.name
                tv_item_from.text = hero.desc
            }
        }

    }
}