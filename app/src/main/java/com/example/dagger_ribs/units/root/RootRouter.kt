package com.example.dagger_ribs.units.root

import android.util.Log
import com.example.dagger_ribs.units.root.units.login.LoginRouter
import com.example.dagger_ribs.units.root.units.login.builder.LoginBuilder
import com.example.dagger_ribs.units.root.units.menu.MenuRouter
import com.example.dagger_ribs.units.root.units.menu.builder.MenuBuilder
import com.example.dagger_ribs.utils.compose.rib.ComposeRouter
import com.uber.rib.core.InteractorBaseComponent

class RootRouter(
    component: InteractorBaseComponent<*>,
    view: RootView,
    interactor: RootInteractor,
    private val loginBuilder: LoginBuilder,
    private val menuBuilder: MenuBuilder
) : ComposeRouter<RootView, RootInteractor>(view, interactor, component) {

    var loginRouter: LoginRouter? = null
    var menuRouter: MenuRouter? = null

    fun attachLogin() {
        if (loginRouter == null) {
            loginRouter = loginBuilder.build().also {
                attachChild(it)
                view.removeContainerView()
                view.setUpdateView(it.view)
            }
        }
    }

    fun detachLogin() {
        loginRouter?.let {
            detachChild(it)
            view.removeContainerView()
        }
        loginRouter = null
    }

    fun attachMenu() {
        Log.d("ATTACH MENU", "CALLED")
        if (menuRouter == null) {
            menuRouter = menuBuilder.build().also {
                attachChild(it)
                view.removeContainerView()
                view.setUpdateView(it.view)
            }
            Log.d("ATTACH MENU","ATTACHED")
        }
    }

    fun detachMenu() {
        Log.d("DETACH MENU","CALLED")
        menuRouter?.let {
            Log.d("DETACH MENU","DETACHED")
            detachChild(it)
            view.removeContainerView()
        }
        menuRouter = null
    }
}