package com.example.dagger_ribs.units.dashboard

import com.example.dagger_ribs.utils.compose.rib.ComposeRouter
import com.uber.rib.core.InteractorBaseComponent

class DashboardRouter(
    view: DashboardView,
    interactor: DashboardInteractor,
    component: InteractorBaseComponent<*>
) : ComposeRouter<DashboardView, DashboardInteractor>(view,interactor,component) {
}