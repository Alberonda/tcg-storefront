package com.alberonda.tcgstorefront.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.alberonda.tcgstorefront.R
import com.alberonda.tcgstorefront.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        // Asociamos nav controller (usado para navigation drawer y para options menu)
        val navController = this.findNavController(R.id.myNavHostFragment)

        //Asignamos layout de menu lateral
        drawerLayout = binding.drawerLayout
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

        //Damos soporte al navigation drawer
        NavigationUI.setupWithNavController(binding.navView, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)

        //Añadimos aqui el drawer para verlo en la esquina superior izquierda
        return NavigationUI.navigateUp(navController, drawerLayout)
    }

}