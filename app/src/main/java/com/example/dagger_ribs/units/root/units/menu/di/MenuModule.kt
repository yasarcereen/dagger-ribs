package com.example.dagger_ribs.units.root.units.menu.di

import com.example.dagger_ribs.units.root.units.menu.MenuInteractor
import com.example.dagger_ribs.units.root.units.menu.MenuRouter
import com.example.dagger_ribs.units.root.units.menu.MenuView
import com.uber.rib.core.InteractorBaseComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MenuModule {

    @Provides
    @Singleton
    fun router(view: MenuView,
               interactor: MenuInteractor,
               component: InteractorBaseComponent<*>
    ) : MenuRouter {
        return MenuRouter(view, interactor, component)
    }
}