package com.example.dagger_ribs.units.root.units.login

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.dagger_ribs.R
import com.example.dagger_ribs.units.root.units.user.UserData
import com.example.dagger_ribs.utils.compose.rib.Compose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking

class LoginView : Compose, LoginInteractor.Presenter {
    private val emailText = MutableStateFlow("")
    private val passwordText = MutableStateFlow("")

    private val continueButtonClick = MutableSharedFlow<Unit>()

    var loginSuccess = MutableSharedFlow<Boolean>()

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content(modifier: Modifier) {
        val coroutineScope = rememberCoroutineScope()

        val email by emailText.collectAsState()
        val password by passwordText.collectAsState()

        Column(modifier = Modifier
            .padding(start = 24.dp, end = 24.dp, top = 10.dp, bottom = 10.dp)
            .fillMaxWidth()) {
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = stringResource(id = R.string.login_dialog_title)
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(value = email,
                onValueChange = {
                    coroutineScope.launch {
                        emailText.emit(it)
                    }
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(value = password,
                onValueChange = {
                    coroutineScope.launch {
                        passwordText.emit(it)
                    }
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            ContinueButton()
        }
    }

    @Composable
    private fun ContinueButton() {
        val coroutineScope = rememberCoroutineScope()

        Button(
            onClick = {
                coroutineScope.launch {
                    continueButtonClick.emit(Unit)
                }
            }) {
            Text(text = "Continue")
        }
    }

    override fun continueButtonClick() : Flow<Unit> {
        return continueButtonClick
    }

    override fun checkCredentials(): Boolean {
        return emailText.value == UserData.email && passwordText.value == UserData.password
    }

    override suspend fun loggedIn() {
        coroutineScope {
            continueButtonClick.collect {
                Log.d("BUTTON", "clicked")
                if (checkCredentials()) {
                    loginSuccess.emit(true)
                } else {
                    Log.d("LOGIN ATTEMPT", "incorrect credentials")
                }
            }
        }
    }
}