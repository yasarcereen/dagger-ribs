package com.example.dagger_ribs.units.root.units.login.di

import com.example.dagger_ribs.units.root.units.login.LoginInteractor
import com.example.dagger_ribs.units.root.units.login.LoginRouter
import com.example.dagger_ribs.units.root.units.login.LoginView
import com.example.dagger_ribs.units.root.units.login.builder.LoginDependencies
import com.uber.rib.core.InteractorBaseComponent
import dagger.BindsInstance
import dagger.Component

@LoginScope
@Component(modules = [LoginModule::class], dependencies = [LoginDependencies::class])
interface LoginComponent: InteractorBaseComponent<LoginInteractor> {
    fun router() : LoginRouter

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun interactor(interactor: LoginInteractor): Builder

        @BindsInstance
        fun view(view: LoginView): Builder

        //@BindsInstance
        fun dependencies(dependencies: LoginDependencies): LoginComponent.Builder

        fun build(): LoginComponent
    }
}