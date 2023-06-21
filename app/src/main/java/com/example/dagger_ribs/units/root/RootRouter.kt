package com.example.dagger_ribs.units.root

import com.example.dagger_ribs.utils.compose.rib.ComposeRouter
import com.uber.rib.core.InteractorBaseComponent

class RootRouter(view: RootView,
                 interactor: RootInteractor,
                 component: InteractorBaseComponent<*>
) : ComposeRouter<RootView, RootInteractor>(view, interactor, component) {


}