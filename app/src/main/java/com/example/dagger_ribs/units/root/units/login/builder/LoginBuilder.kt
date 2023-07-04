package com.example.dagger_ribs.units.root.units.login.builder

import com.example.dagger_ribs.units.root.units.login.LoginInteractor
import com.example.dagger_ribs.units.root.units.login.LoginRouter
import com.example.dagger_ribs.units.root.units.login.LoginView
import com.example.dagger_ribs.units.root.units.login.di.DaggerLoginComponent
import com.example.dagger_ribs.units.root.units.login.di.LoginComponent
import com.uber.rib.core.Builder

class LoginBuilder(dependency: LoginDependencies)
    : Builder<LoginRouter, LoginDependencies>(dependency){
    fun build(): LoginRouter {
        val presenter = LoginView()
        val interactor = LoginInteractor()
        val component: LoginComponent = DaggerLoginComponent.builder()
            .view(presenter)
            .dependencies(dependency)
            .interactor(interactor)
            .build()
        return component.router()
    }
}