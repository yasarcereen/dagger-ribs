package com.example.dagger_ribs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import com.example.dagger_ribs.ui.theme.DaggerribsTheme
import com.example.dagger_ribs.units.root.RootRouter
import com.example.dagger_ribs.units.root.builder.RootBuilder
import com.example.dagger_ribs.units.root.builder.RootDependencies
import com.example.dagger_ribs.units.root.units.menu.MenuView
import com.example.dagger_ribs.units.root.units.login.LoginView
import com.example.dagger_ribs.utils.compose.rib.ComposeRouter
import com.example.dagger_ribs.utils.compose.rib.RibComposeActivity
import javax.inject.Inject

class MainActivity : RibComposeActivity() {
    override fun createRouter(): ComposeRouter<*, *> {
        return RootBuilder(applicationContext as RootDependencies).build()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}

