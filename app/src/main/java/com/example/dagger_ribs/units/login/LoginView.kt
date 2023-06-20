package com.example.dagger_ribs.units.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.dagger_ribs.R
import com.example.dagger_ribs.utils.compose.rib.Compose
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class LoginView : Compose {
    private val emailText = MutableStateFlow("")
    private val passwordText = MutableStateFlow("")

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content(modifier: Modifier) {
        val coroutineScope = rememberCoroutineScope()

        Column {
            Spacer(modifier = Modifier.height(10.dp))

            Text(modifier = Modifier
                .padding(end = 56.dp, start = 24.dp)
                .fillMaxWidth(),
                text = stringResource(id = R.string.login_dialog_title)
            )

            Spacer(modifier = Modifier.height(10.dp))

            TextField(value = "email",
                onValueChange = {
                    coroutineScope.launch {
                        emailText.emit(it)
                    }
                }
            )

            TextField(value = "password",
                onValueChange = {
                    coroutineScope.launch {
                        passwordText.emit(it)
                    }
                }
            )
        }
    }

    interface Presenter {

    }
}