package com.example.dagger_ribs.units.root.di

import com.example.dagger_ribs.units.root.RootInteractor
import com.example.dagger_ribs.units.root.RootRouter
import com.example.dagger_ribs.units.root.RootView
import com.example.dagger_ribs.units.root.units.login.builder.LoginBuilder
import com.example.dagger_ribs.units.root.units.menu.builder.MenuBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class RootModule {

    companion object {
        @Provides
        fun router(
            component: RootComponent,
            view: RootView,
            interactor: RootInteractor,
        ): RootRouter {
            return RootRouter(component,view, interactor, LoginBuilder(component), MenuBuilder(component))
        }
    }

    @Binds
    abstract fun presenter(view: RootView): RootInteractor.Presenter
}