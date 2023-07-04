package com.example.dagger_ribs.units.root.units.menu.di

import com.example.dagger_ribs.units.root.units.menu.MenuInteractor
import com.example.dagger_ribs.units.root.units.menu.MenuRouter
import com.example.dagger_ribs.units.root.units.menu.MenuView
import com.example.dagger_ribs.units.root.units.menu.builder.MenuDependencies
import com.uber.rib.core.InteractorBaseComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [MenuModule::class])
interface MenuComponent: InteractorBaseComponent<MenuInteractor> {
    fun router() : MenuRouter

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun interactor(interactor: MenuInteractor): Builder

        @BindsInstance
        fun view(view: MenuView): Builder

        @BindsInstance
        fun dependencies(dependencies: MenuDependencies): Builder

        fun build(): MenuComponent
    }
}