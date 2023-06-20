package com.example.dagger_ribs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import com.example.dagger_ribs.ui.theme.DaggerribsTheme
import com.example.dagger_ribs.units.menu.MenuView
import com.example.dagger_ribs.units.login.LoginView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val loginView = LoginView()

        val menuView = MenuView()

        setContent {
            DaggerribsTheme {
                loginView.Content(modifier = Modifier)
                // menuView.Content(modifier = Modifier)
            }
        }
    }
}

