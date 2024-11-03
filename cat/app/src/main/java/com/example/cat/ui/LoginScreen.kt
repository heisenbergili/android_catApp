package com.example.cat.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cat.R
import com.example.cat.ui.theme.TestTheme

@Composable
fun LoginScreen(
    onLoginButtonClicked: () -> Unit = {},
    loginViewModel : LoginViewModel = viewModel(),
){
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Form(
            modifier = Modifier.align(Alignment.Center),
            //The current string in the TextField
            onUserEmailChanged = { loginViewModel.updateEmailGuess(it) },
            //The string that user enter until now
            emailGuess = loginViewModel.emailGuess,
            //The action to validate the email
            checkEmail = { loginViewModel.checkEmail { onLoginButtonClicked() } },
            //Check the format of the current email
            wrongEmail = loginViewModel.wrongEmail
        )
    }
}


/**
 * Form that contains
 * Field: where the user will enter his email
 * Button: The submit button
 */
@Composable
private fun Form(
    onUserEmailChanged: (String) -> Unit,
    emailGuess: String,
    checkEmail: ( ()-> Unit )-> Unit,
    wrongEmail : Boolean,
    modifier: Modifier =  Modifier
){

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Row (
            modifier = Modifier.padding(bottom = 5.dp)
        ){
            TextField(
                value = emailGuess,
                onValueChange = onUserEmailChanged,
                label = { Text(stringResource(R.string.email_address))},
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Email,
                ),


                keyboardActions = KeyboardActions(
                    onDone = {
                        //validate the email and navigate to the next screen if it ok
                        checkEmail{}
                    }
                ),
            )
            Button(onClick =
                {
                    //validate the email and navigate to the next screen if it ok
                    checkEmail{}
                },
                modifier = Modifier
                    .padding(start = 5.dp)
                    .size(width = 100.dp, height = 55.dp),

            ) {
                Text(stringResource(R.string.login))
            }
        }
        if (wrongEmail){
            Text(
                text = stringResource(R.string.email_is_not_valid),
                color = Color.Red,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingBackGround() {
    TestTheme {
        LoginScreen()
    }
}