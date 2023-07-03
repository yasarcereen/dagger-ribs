package com.example.dagger_ribs.units.root.units.login.di

import com.example.dagger_ribs.units.root.units.login.LoginInteractor
import com.example.dagger_ribs.units.root.units.login.LoginRouter
import com.example.dagger_ribs.units.root.units.login.LoginView
import com.uber.rib.core.InteractorBaseComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LoginModule {

    @Provides
    @Singleton
    fun router(view: LoginView,
               interactor: LoginInteractor,
               component: InteractorBaseComponent<*>
    ): LoginRouter {
        return LoginRouter(view, interactor,component)
    }
}