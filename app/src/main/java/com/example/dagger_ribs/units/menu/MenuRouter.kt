package com.example.dagger_ribs.units.dashboard

import com.example.dagger_ribs.utils.compose.rib.ComposeRouter
import com.uber.rib.core.InteractorBaseComponent

class MenuRouter(
    view: MenuView,
    interactor: MenuInteractor,
    component: InteractorBaseComponent<*>
) : ComposeRouter<MenuView, MenuInteractor>(view,interactor,component) {
}