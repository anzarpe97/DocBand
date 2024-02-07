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

    var navController = rememberNavController()

    NavHost(navController = navController, startDestination = LoginScreen.route){

        composable(LoginScreen.route){

            LoginScreen(navRegistro = {

                navController.navigate(NewUserR.route)

            })
        }

        composable(NewUserR.route){

            NewUserR(navLogin ={

                navController.navigate(LoginScreen.route)

            })



        }

    }

}

