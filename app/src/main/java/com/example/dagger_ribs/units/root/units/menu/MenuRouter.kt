package com.example.dagger_ribs.units.root.units.menu

import com.example.dagger_ribs.utils.compose.rib.ComposeRouter
import com.uber.rib.core.InteractorBaseComponent
import javax.inject.Inject

class MenuRouter @Inject constructor(
    view: MenuView,
    interactor: MenuInteractor
) : ComposeRouter<MenuView, MenuInteractor>(view,interactor) {
}