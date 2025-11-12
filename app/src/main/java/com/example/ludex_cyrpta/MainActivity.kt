package com.example.ludex_cyrpta

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.newFixedThreadPoolContext

class MainActivity : AppCompatActivity() {
    private var actvFrag: Fragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /* PROCESS FOR ADDING NEW SCREEN FRAGMENTS:
            // 1. Initialize your Fragment instances (in first TODO, like so...)
            val fragName: FragType = FragType()

            // 2. Initialize your Buttons <SINCE OTHER SCREENS WILL BE TRIGGERED BY BUTTON> (in second TODO, like so...)
            val btnVar: Button = findViewById(R.id.btnNAMEinFRAGxml)

            // 3. Set the Click Listeners (as needed, like so...)
            homeButton.setOnClickListener {
                switchFrag(fragToSwitchTo)
            }
         */

        // Bottom Nav & Fragment Manager
        val bottomNav: BottomNavigationView = findViewById(R.id.bottomNav)
        val fragMngr: FragmentManager = supportFragmentManager

        //Fragments that are accessible by Bottom Nav
        val homeFragment: HomePageFragment = HomePageFragment()
        val gvFragment: GameVaultFragment = GameVaultFragment()
        val searchFragment: SearchPageFragment = SearchPageFragment()
        val trendFragment: TrendingFragment = TrendingFragment()
        val psFragment: ProfSettingsFragment = ProfSettingsFragment()

        //Other Screen Fragments (accessible by other means)
        //TODO: add the other screen fragments here  (login, registration pages 1 & 2, game info (and if each tab-divided page [Game Vault & Profile/Settings] needs a frag for their second tab))
        val salesFragment: OnSaleFragment = OnSaleFragment()


        //TODO: button creation here

        // set at beginning (should be login screen but might stay Home screen)
        if (savedInstanceState == null) {
            //TODO: add (and hide) the other screen frags on top and hide them
            fragMngr.beginTransaction()
                .add(R.id.mainScreen, psFragment, "PROFILE_SETTINGS")
                .hide(psFragment)
                .add(R.id.mainScreen, salesFragment, "SALES")
                .hide(salesFragment)
                .add(R.id.mainScreen, trendFragment, "TRENDS")
                .hide(trendFragment)
                .add(R.id.mainScreen, searchFragment, "SEARCH")
                .hide(searchFragment)
                .add(R.id.mainScreen, gvFragment, "GAME_VAULT")
                .hide(gvFragment)
                .add(R.id.mainScreen, homeFragment, "HOME")
                .commit()

            actvFrag = homeFragment
        }

        bottomNav.setOnItemSelectedListener { item ->
            lateinit var newFrag : Fragment
            when (item.itemId) {
                R.id.homePage -> newFrag = homeFragment
                R.id.searchPage -> newFrag = searchFragment
                R.id.trendingPage -> newFrag = trendFragment
                R.id.gameVaultPage -> newFrag = gvFragment
                R.id.profile_settingsPage -> newFrag = psFragment
            }
            swapFrag(newFrag)
            true
        }

        bottomNav.selectedItemId = R.id.homePage //default screen is the home page
    }

    private fun swapFrag(newFrag: Fragment) {
        val fragMngr = supportFragmentManager
        val fragTrnsctn = fragMngr.beginTransaction()

        actvFrag?.let {
            fragTrnsctn.hide(it)
        }
        fragTrnsctn.show(newFrag)
        fragTrnsctn.commit()
        actvFrag = newFrag
    }
}