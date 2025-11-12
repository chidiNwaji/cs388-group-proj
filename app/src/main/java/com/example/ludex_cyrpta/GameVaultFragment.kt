package com.example.ludex_cyrpta

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private lateinit var games: List<Game>
class GameVaultFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInflater: Bundle?): View? {
        val view = inflater.inflate(R.layout.game_vault_screen_frag, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gamesRV = view.findViewById<RecyclerView>(R.id.gameList)
        games = GameFetcher.getGames()
        val adapter = GameAdapter(games)
        // Attach the adapter to the RecyclerView to populate items
        gamesRV.adapter = adapter
        // Set layout manager to position the items
        gamesRV.layoutManager = LinearLayoutManager(view.context)
    }

    companion object {
        fun newInstance(): GameVaultFragment {
            return GameVaultFragment()
        }
    }
}