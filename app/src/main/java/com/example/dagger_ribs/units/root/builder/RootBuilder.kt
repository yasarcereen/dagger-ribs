package com.example.dagger_ribs.units.root.builder

import com.example.dagger_ribs.units.root.RootInteractor
import com.example.dagger_ribs.units.root.RootRouter
import com.example.dagger_ribs.units.root.RootView
import com.uber.rib.core.Builder

class RootBuilder(dependency: RootDependencies)
    : Builder<RootRouter, RootDependencies>(dependency){

    fun build() : RootRouter {
        val view = RootView()
        val interactor = RootInteractor()
        val component = TODO()
        return RootRouter(view, interactor, component)
    }
}