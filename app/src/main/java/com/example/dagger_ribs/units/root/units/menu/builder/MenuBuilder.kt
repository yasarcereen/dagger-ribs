package com.example.dagger_ribs.units.root.units.menu.builder

import com.example.dagger_ribs.units.root.units.menu.MenuInteractor
import com.example.dagger_ribs.units.root.units.menu.MenuRouter
import com.example.dagger_ribs.units.root.units.menu.MenuView
import com.example.dagger_ribs.units.root.units.menu.di.DaggerMenuComponent
import com.example.dagger_ribs.units.root.units.menu.di.MenuComponent
import com.uber.rib.core.Builder

class MenuBuilder(dependency: MenuDependencies)
    : Builder<MenuRouter, MenuDependencies>(dependency){
    fun build() : MenuRouter {
        val view = MenuView()
        val interactor = MenuInteractor()
        val component: MenuComponent = DaggerMenuComponent.builder()
            .view(view)
            .interactor(interactor)
            .dependencies(dependency)
            .build()

        return component.router()
    }
}