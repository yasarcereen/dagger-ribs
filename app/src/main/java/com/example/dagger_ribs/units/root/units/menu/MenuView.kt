package com.example.dagger_ribs.units.root.units.menu

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dagger_ribs.utils.compose.rib.Compose
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MenuView : Compose, MenuInteractor.Presenter {
    val logoutButtonClick = MutableSharedFlow<Boolean>()

    val logOut = MutableSharedFlow<Boolean>()

    @Composable
    override fun Content(modifier: Modifier) {
        Column(modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()) {
            Text(text = "Logged in")
            
            Spacer(modifier = Modifier.height(10.dp))
            
            LogoutButton()
        }
    }

    @Composable
    private fun LogoutButton() {
        val coroutineScope = rememberCoroutineScope()

        Button(onClick = {
            coroutineScope.launch {
                logoutButtonClick.emit(true)
            }
        }) {
            Text("Log out")
        }
    }

    override fun logoutButtonClick() : Flow<Boolean>{
        return logoutButtonClick
    }
}