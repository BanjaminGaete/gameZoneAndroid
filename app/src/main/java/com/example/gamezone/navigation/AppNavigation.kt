package com.example.gamezone.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.example.gamezone.viewModel.ProductoViewModel
import com.example.gamezone.views.InicioScreen
import com.example.gamezone.views.LoginScreen
import com.example.gamezone.views.ProductoScreen


@Composable
fun AppNavigation(viewModel: ProductoViewModel){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "inicio"
    )
    {
        composable("login"){
            LoginScreen(navController).login()
        }

        composable ("inicio"){
            InicioScreen(navController).inicio()
        }

        composable("productos") {
            ProductoScreen(navController, viewModel).pantallaProducto()
        }


    }
}