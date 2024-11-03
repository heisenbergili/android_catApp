package com.example.cat.ui

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    var emailGuess by mutableStateOf("")
        private set

    var wrongEmail by mutableStateOf(false)
        private set

    /**
     * Get the string which is in the text field of the string
     * and update the emailGuess
     */
    fun updateEmailGuess(emailField: String){
        emailGuess = emailField
    }

    /**
     * Turn wrong email to true if the format of email is not valid
     *      si c'est bon on execute un action???
     */
    fun checkEmail( onLoginButtonClicked: () -> Unit ){
        //recoit la méthode et la executer

        if (Patterns.EMAIL_ADDRESS.matcher(emailGuess).matches()){
            //Navige vers la nouvelle page
            wrongEmail = false
            Log.d("Btn", wrongEmail.toString())
            onLoginButtonClicked()
            Log.d("Btn", "Clicked")
        }else{
            wrongEmail = true
            Log.d("Btn", wrongEmail.toString())
        }
    }


}