package com.example.dagger_ribs.units.root.units.login.di

import com.example.dagger_ribs.units.root.units.login.LoginInteractor
import com.example.dagger_ribs.units.root.units.login.LoginRouter
import com.example.dagger_ribs.units.root.units.login.LoginView
import dagger.Module
import dagger.Provides

@Module
class LoginModule {

    @Provides
    fun router(view: LoginView,
               interactor: LoginInteractor
    ): LoginRouter {
        return LoginRouter(view, interactor)
    }
}