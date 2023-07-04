package com.example.dagger_ribs.units.root.units.menu

import com.example.dagger_ribs.units.root.units.menu.di.MenuComponent
import com.example.dagger_ribs.utils.compose.rib.ComposeRouter
import com.uber.rib.core.InteractorBaseComponent

class MenuRouter(
    component: InteractorBaseComponent<*>,
    view: MenuView,
    interactor: MenuInteractor
) : ComposeRouter<MenuView, MenuInteractor>(view, interactor, component) {
}