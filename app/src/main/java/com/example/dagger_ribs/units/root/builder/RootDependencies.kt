package com.example.dagger_ribs.units.root.builder

import com.example.dagger_ribs.units.root.units.login.LoginView
import com.example.dagger_ribs.units.root.units.menu.MenuView

interface RootDependencies {
    fun login() : LoginView
    fun menu() : MenuView
}