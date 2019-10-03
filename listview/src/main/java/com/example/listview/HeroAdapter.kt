package com.example.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.list_hero.view.*

class HeroAdapter

internal constructor(private val context: Context): BaseAdapter(){

    internal var heroes = arrayListOf<Hero>()

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup?): View? {
        var itemView = view
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.list_hero, viewGroup, false)
        }
        val viewHolder = ViewHolder(itemView as View)
        val hero = getItem(i) as Hero
        viewHolder.bind(hero)

        return itemView
    }

    override fun getItem(i: Int): Any {
        return heroes[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
        return heroes.size
    }

    private inner class ViewHolder internal constructor(private val view: View) {

        internal fun bind(hero: Hero){
            with(view) {
                txt_name.text = hero.name
                txt_description.text = hero.description
                img_photo.setImageResource(hero.photo)
            }
        }

    }

}