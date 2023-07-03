package com.example.dagger_ribs.units.root.units.login

import com.example.dagger_ribs.utils.compose.rib.ComposeRouter
import com.uber.rib.core.InteractorBaseComponent
import javax.inject.Inject

class LoginRouter @Inject constructor(
    view: LoginView,
    interactor: LoginInteractor,
    component: InteractorBaseComponent<*>
) : ComposeRouter<LoginView, LoginInteractor>(view, interactor, component){
}