package com.example.ludex_crypta

class GameFetcher {
    companion object {
        val gameNames = listOf("The Sims", "World of Warcraft", "GTA: San Andreas", "GTA V", "Halo 3", "Portal", "League of Legends", "Minecraft", "Read Dead Redemption", "Skyrim", "Legend of Zelda: Breath of the Wild", "PUBG", "Fortnite", "Fallout New Vegas", "Elden Ring")
        val gameTags = mutableListOf<String>("PC")
        val saleORtrend = listOf<Boolean>(true, false)

        fun getGames(): MutableList<Game> {
            var games : MutableList<Game> = ArrayList()
            for (i in 0..14) {
                val outputS = if (i % 2 == 0) saleORtrend[0] else saleORtrend[1]
                val outputT = if ((i+1) % 2 == 0) saleORtrend[1] else saleORtrend[0]
                val game = Game(gameNames[i], "$0.00", "@drawable/ic_launcher_foreground.xml", gameTags, "https://youtu.be/QdBZY2fkU-0", "A game", mutableMapOf<String, Int>("GameVault" to i%5), outputS, outputT)
                games.add(game)
            }
            return games
        }
    }

}