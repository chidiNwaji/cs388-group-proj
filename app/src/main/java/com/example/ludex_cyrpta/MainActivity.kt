package com.example.ludex_cyrpta

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var games: List<Game>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val gamesRV = findViewById<RecyclerView>(R.id.gameVaultList)
        games = GameFetcher.getGames()
        val adapter = GameAdapter(games)
        // Attach the adapter to the RecyclerView to populate items
        gamesRV.adapter = adapter
        // Set layout manager to position the items
        gamesRV.layoutManager = LinearLayoutManager(this)

    }
}