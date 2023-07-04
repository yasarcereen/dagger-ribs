package com.example.dagger_ribs.units.root.di

import com.example.dagger_ribs.units.root.RootInteractor
import com.example.dagger_ribs.units.root.RootRouter
import com.example.dagger_ribs.units.root.RootView
import com.example.dagger_ribs.units.root.builder.RootDependencies
import com.example.dagger_ribs.units.root.units.login.builder.LoginDependencies
import com.example.dagger_ribs.units.root.units.login.di.LoginModule
import com.example.dagger_ribs.units.root.units.menu.builder.MenuDependencies
import com.example.dagger_ribs.units.root.units.menu.di.MenuModule
import com.uber.rib.core.InteractorBaseComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RootModule::class])
interface RootComponent: InteractorBaseComponent<RootInteractor>, LoginDependencies,MenuDependencies {

    fun router(): RootRouter

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun interactor(interactor: RootInteractor): Builder

        @BindsInstance
        fun view(rootView: RootView): Builder
        @BindsInstance
        fun dependencies(dependencies: RootDependencies): Builder

        fun build(): RootComponent
    }
}
