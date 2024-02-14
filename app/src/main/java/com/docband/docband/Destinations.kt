package com.docband.docband

sealed class Destinations (val route : String){

    object LoginScreen: Destinations ("login")
    object NewUserR: Destinations ("registro")
    object HomeView: Destinations("HomeView")
    object InfoView: Destinations("InfoView")

}