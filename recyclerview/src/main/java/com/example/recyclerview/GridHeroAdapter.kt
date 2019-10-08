package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_grid_hero.view.*

class GridHeroAdapter(private val arrayList: ArrayList<Hero>) : RecyclerView.Adapter<GridHeroAdapter.GridViewHolder>() {

    private var onItemClickCallback : OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : GridHeroAdapter.GridViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grid_hero, parent, false)
        return GridViewHolder(view)
    }

    override fun getItemCount(): Int = arrayList.size

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(hero: Hero){
            with(itemView){
                Glide.with(itemView.context).load(hero.photo)
                    .apply(RequestOptions.skipMemoryCacheOf(true))
                    .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                    .override(350, 550)
                    .into(img_item_photo)

                itemView.setOnClickListener {
                    onItemClickCallback?.onItemClick(hero)
                }
            }
        }
    }
}