package com.docband.docband

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.docband.docband.Destinations.*
import com.docband.docband.login.ui.LoginScreen
import com.docband.docband.login.ui.NewUserR

@Composable
fun NavigationHost(){

    var NavControler = rememberNavController()

    NavHost(navController = NavControler, startDestination = LoginScreen.route){

        composable(LoginScreen.route){

            LoginScreen(navRegistro = { NavControler.navigate(NewUserR.route) }, navHome = { NavControler.navigate(HomeView.route) })
        }

        composable(NewUserR.route){

            NewUserR(NavControler)

        }

    }

}

    