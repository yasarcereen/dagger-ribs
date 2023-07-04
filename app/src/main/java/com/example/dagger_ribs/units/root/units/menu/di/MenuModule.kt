package com.example.dagger_ribs.units.root.units.menu.di

import com.example.dagger_ribs.units.root.units.menu.MenuInteractor
import com.example.dagger_ribs.units.root.units.menu.MenuRouter
import com.example.dagger_ribs.units.root.units.menu.MenuView
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class MenuModule {

    companion object {
        @Provides
        fun router(
            component: MenuComponent,
            view: MenuView,
            interactor: MenuInteractor
        ): MenuRouter {
            return MenuRouter(component, view, interactor)
        }
    }

    @Binds
    abstract fun presenter(view: MenuView): MenuInteractor.Presenter
}