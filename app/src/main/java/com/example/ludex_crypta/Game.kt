package com.example.ludex_crypta

class Game(val name: String, val price: String, val imageLink: String, val tags: MutableList<String>, val trailerLink: String, val descr: String, val listBelong: MutableMap<String, Int>, val onSale: Boolean, val trending: Boolean) {
    /*
    name -> game name; i.e. "Doom"
    price -> game price; i.e. $19.99; if 0.00, assign value "Free"
    imageLink -> link to game poster
    tags -> game classification: TODO: finish these classifications
        {   Genre: action, adventure, strategy, puzzle, role-playing, simulation, etc;
            Mechanics: open-world, stealth, survival, combat, crafting, building, racing, etc;
            Theme: fantasy, sci-fi, horror, historical, superheroes, etc;
            Player Count: single-player, multiplayer, co-op, competitive, etc;
            Platform: PC, Playstation, Xbox, Nintendo Switch, Mobile, VR, etc;
            Launcher: Steam, EPIC, Ubisoft, Xbox, EA, etc
            ...
        }
    trailerLink -> link to trailer; i.e. https://youtu.be/QdBZY2fkU-0 (GTA 6 Trailer 1)
    descr -> game description; "A Game"
    listBelong -> list game belongs to; key is list name (GameVault, WishList, Favorites) and value is position on the list (1, 2, 3, ...)
    onSale -> is the game on sale? TRUE or FALSE
    trending -> is the game trending? TRUE or FALSE
     */
}