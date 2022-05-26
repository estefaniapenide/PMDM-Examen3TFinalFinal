package com.example.penide_estefania_examen3t

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.navigateUp
import com.example.penide_estefania_examen3t.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
        navController = navHostFragment.navController

        /*appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)*/

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_simple ->
                when(navController.currentDestination?.id){
                    R.id.MainFragment-> navController.navigate(MainFragmentDirections.actionMainFragmentToSimpleFragment())
                    R.id.compuestoFragment -> navController.navigate(CompuestoFragmentDirections.actionCompuestoFragmentToSimpleFragment())
                }
            R.id.action_compuesto -> when(navController.currentDestination?.id){
                R.id.MainFragment-> navController.navigate(MainFragmentDirections.actionMainFragmentToCompuestoFragment())
                R.id.SimpleFragment -> navController.navigate(SimpleFragmentDirections.actionSimpleFragmentToCompuestoFragment())
            }
            else -> super.onOptionsItemSelected(item)
        }
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}


