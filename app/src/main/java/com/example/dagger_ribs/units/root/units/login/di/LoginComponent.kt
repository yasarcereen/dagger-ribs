package com.example.dagger_ribs.units.root.units.login.di

import com.example.dagger_ribs.units.root.units.login.LoginInteractor
import com.example.dagger_ribs.units.root.units.login.LoginRouter
import com.example.dagger_ribs.units.root.units.login.LoginView
import com.uber.rib.core.InteractorBaseComponent
import dagger.BindsInstance
import dagger.Component

@Component(modules = [LoginModule::class])
interface LoginComponent {
    fun router() : LoginRouter

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun interactor(interactor: LoginInteractor): Builder

        @BindsInstance
        fun view(view: LoginView): Builder

        fun build(): LoginComponent
    }
}