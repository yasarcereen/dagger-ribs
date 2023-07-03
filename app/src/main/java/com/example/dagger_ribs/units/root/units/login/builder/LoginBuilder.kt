package com.example.dagger_ribs.units.root.units.login.builder

import com.example.dagger_ribs.units.root.units.login.LoginInteractor
import com.example.dagger_ribs.units.root.units.login.LoginRouter
import com.example.dagger_ribs.units.root.units.login.LoginView
import com.example.dagger_ribs.units.root.units.login.di.DaggerLoginComponent
import com.example.dagger_ribs.units.root.units.login.di.LoginComponent
import javax.inject.Inject

class LoginBuilder @Inject constructor(){
    fun build(): LoginRouter {
        val presenter = LoginView()
        val interactor = LoginInteractor()
        val component: LoginComponent = DaggerLoginComponent.builder()
            .view(presenter)
            .interactor(interactor)
            .build()
        return component.router()
    }
}