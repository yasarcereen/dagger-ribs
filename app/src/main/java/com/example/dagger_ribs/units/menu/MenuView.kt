package com.example.dagger_ribs.units.dashboard

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
import androidx.compose.ui.unit.dp
import com.example.dagger_ribs.utils.compose.rib.Compose
import kotlinx.coroutines.launch

class MenuView : Compose{
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

            }
        }) {
            Text("Log out")
        }
    }

}