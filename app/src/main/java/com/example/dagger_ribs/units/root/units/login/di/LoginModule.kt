package com.example.dagger_ribs.units.root.units.login.di

import com.example.dagger_ribs.units.root.units.login.LoginInteractor
import com.example.dagger_ribs.units.root.units.login.LoginRouter
import com.example.dagger_ribs.units.root.units.login.LoginView
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class LoginModule {
    @LoginScope
    companion object {
        @Provides
        fun router(
            component: LoginComponent,
            view: LoginView,
            interactor: LoginInteractor
        ): LoginRouter {
            return LoginRouter(component, view, interactor)
        }
    }

    @LoginScope
    @Binds
    abstract fun presenter(view: LoginView): LoginInteractor.Presenter
}