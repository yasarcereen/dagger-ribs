package com.example.dagger_ribs.units.root.di

import com.example.dagger_ribs.units.root.RootInteractor
import com.example.dagger_ribs.units.root.RootRouter
import com.example.dagger_ribs.units.root.RootView
import com.example.dagger_ribs.units.root.units.login.di.LoginModule
import com.example.dagger_ribs.units.root.units.menu.di.MenuModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RootModule::class])
interface RootComponent {

    fun router(): RootRouter

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun interactor(interactor: RootInteractor): Builder

        @BindsInstance
        fun view(rootView: RootView): Builder

        fun build(): RootComponent
    }
}
