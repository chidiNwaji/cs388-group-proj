package com.example.ludex_crypta

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

/* UPDATED VERSION
class GameAdapter(
    private val games: List<Game>,
    private val gListener: OnListFragmentInteractionListener?
): RecyclerView.Adapter<GameAdapter.GameViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.game_vault_screen_frag, parent, false)
        return GameViewHolder(view)
    }

    inner class GameViewHolder(val gView: View) : RecyclerView.ViewHolder(gView) {
        var gItem: Game? = null
        val gameName: TextView = gView.findViewById(R.id.name)
        val gameDescr: TextView = gView.findViewById(R.id.descr)
        val gamePrice: TextView = gView.findViewById(R.id.price)
        val gameImage: ImageView = gView.findViewById(R.id.image)

        override fun toString(): String {
            return gameName.toString() + " '" + gameDescr.text + "'"
        }
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = games[position]

        holder.gItem = game
        holder.gameName.text = game.name
        holder.gamePrice.text = game.price
        holder.gameDescr.text = game.descr

        val imageURL = game.imageLink
        Glide.with(holder.gView)
            .load(imageURL)
            .centerInside()
            .into(holder.gameImage)

        holder.gView.setOnClickListener {
            holder.gItem?.let { game ->
                gListener?.onItemClick(game)
            }
        }
    }

    override fun getItemCount(): Int {
        return games.size
    }
}
 */

class GameAdapter(private val games: List<Game>) : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.game_rv_item, parent, false)
        return GameViewHolder(contactView)
    }

    inner class GameViewHolder(val gView: View) : RecyclerView.ViewHolder(gView) {
        val gameName: TextView = gView.findViewById(R.id.name)
        val gameDescr: TextView = gView.findViewById(R.id.descr)
        val gamePrice: TextView = gView.findViewById(R.id.price)
        val gameImage: ImageView = gView.findViewById(R.id.image)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = games.get(position)
        holder.gameName.text = game.name
        holder.gamePrice.text = game.price
        holder.gameDescr.text = game.descr

        val imageURL = game.imageLink
        Glide.with(holder.gView)
            .load(imageURL)
            .centerInside()
            .into(holder.gameImage)
    }

    override fun getItemCount(): Int {
        return games.size
    }
}