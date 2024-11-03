package com.example.cat

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cat.ui.LoginScreen
import com.example.cat.ui.PrincipalScreen

enum class CatScreen{
    LOGIN,
    PRINCIPAL,
}


@Composable
fun CatScreenApp(
    navController : NavHostController = rememberNavController(),

    ){    //ViewModel, NavController
    //Scaffold?

    NavHost(
        navController = navController,
        startDestination = CatScreen.LOGIN.name,
    ){
        //Login Screen
        composable(route = CatScreen.LOGIN.name){
            Log.d("CatScreen", "Login")
            //when the user click -> swap the screen
            LoginScreen(
                onLoginButtonClicked = {
                    Log.d("CatApp", "Clicked")
                    navController.navigate(CatScreen.PRINCIPAL.name)
                                       },
            )
        }

        //Principal Screen
        composable(route = CatScreen.PRINCIPAL.name){
            Log.d("CatScreen", "Principal")
            PrincipalScreen()
        }

    }

}