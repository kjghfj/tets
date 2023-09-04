package com.ulimit.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val jokeService: JokeService by inject()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: JokeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclicview)
        adapter = JokeAdapter(emptyList())

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val jokeResponse = jokeService.getRandomJoke()
                val joke = jokeResponse.joke
                // save value in prefences
                MyApplication.mPreferences.save("joke", joke)
                val randomeJoke = MyApplication.mPreferences.getString(joke!!)
                
                runOnUiThread {
                    adapter = JokeAdapter(listOf(randomeJoke) as List<String>)
                    recyclerView.adapter = adapter
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
