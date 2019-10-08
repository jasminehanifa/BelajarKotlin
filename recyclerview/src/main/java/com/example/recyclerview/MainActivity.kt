package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<Hero>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_heroes.setHasFixedSize(true)
        list.addAll(getListHero())
        showRecylerList()

    }

    fun getListHero(): ArrayList<Hero>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDesc = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)

        val listHero = ArrayList<Hero>()
        for(position in dataName.indices){
            val hero = Hero(
                dataName[position],
                dataDesc[position],
                dataPhoto[position]
            )
            listHero.add(hero)

        }
        return listHero
    }

    fun gridHero(){
        rv_heroes.layoutManager = GridLayoutManager(this, 2)
        val gridHeroAdapter = GridHeroAdapter(list)
        rv_heroes.adapter = gridHeroAdapter

        gridHeroAdapter.setOnItemClickCallback(object : OnItemClickCallback{
            override fun onItemClick(data: Hero) {
                selectedHero(data)
            }

        })
    }

    fun cardviewHero(){
        rv_heroes.layoutManager =LinearLayoutManager(this)
        val cardViewHeroAdapter = CardViewHeroAdapter(list)
        rv_heroes.adapter = cardViewHeroAdapter

       cardViewHeroAdapter.setOnItemClickCallback(object : OnItemClickCallback{
           override fun onItemClick(data: Hero) {
               selectedHero(data)
           }
       })
    }

    private fun showRecylerList(){
        rv_heroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rv_heroes.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : OnItemClickCallback{
            override fun onItemClick(data: Hero) {
                selectedHero(data)
            }

        })
    }

    private fun selectedHero(hero: Hero){
        Toast.makeText(this, "Kamu Memilih ${hero.name}", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int){
        when(selectedMode){
            R.id.action_list->{
                showRecylerList()
            }

            R.id.action_grid->{
                gridHero()
            }

            R.id.action_cardview->{
                cardviewHero()
            }
        }
    }
}
