package com.example.dagger_ribs.units.root.units.login

import com.example.dagger_ribs.units.root.units.login.di.LoginComponent
import com.example.dagger_ribs.utils.compose.rib.ComposeRouter
import com.uber.rib.core.InteractorBaseComponent

class LoginRouter(
    component: InteractorBaseComponent<*>,
    view: LoginView,
    interactor: LoginInteractor
) : ComposeRouter<LoginView, LoginInteractor>(view, interactor, component){
}