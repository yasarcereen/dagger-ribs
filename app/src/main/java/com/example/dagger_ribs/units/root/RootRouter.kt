package com.example.dagger_ribs.units.root

import com.example.dagger_ribs.units.root.units.login.LoginRouter
import com.example.dagger_ribs.units.root.units.login.builder.LoginBuilder
import com.example.dagger_ribs.units.root.units.menu.MenuRouter
import com.example.dagger_ribs.units.root.units.menu.builder.MenuBuilder
import com.example.dagger_ribs.utils.compose.rib.ComposeRouter
import com.uber.rib.core.InteractorBaseComponent

class RootRouter(view: RootView,
                 interactor: RootInteractor,
                 component: InteractorBaseComponent<*>,
                 private val loginBuilder: LoginBuilder,
                 private val menuBuilder: MenuBuilder
) : ComposeRouter<RootView, RootInteractor>(view, interactor, component) {

    var loginRouter: LoginRouter? = null
    var menuRouter: MenuRouter? = null

    fun attachLogin() {
        if (loginRouter == null) {
            loginRouter = loginBuilder.build()
        }
    }

    fun detachLogin() {
        if (loginRouter != null) {
            loginRouter = null
        }
    }

    fun attachMenu() {
        if (menuRouter == null) {
            menuRouter = menuBuilder.build()
        }
    }

    fun detachMenu() {
        if (menuRouter != null) {
            menuRouter = null
        }
    }
}