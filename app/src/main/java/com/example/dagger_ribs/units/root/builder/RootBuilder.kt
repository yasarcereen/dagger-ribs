package com.example.dagger_ribs.units.root.builder

import com.example.dagger_ribs.units.root.RootInteractor
import com.example.dagger_ribs.units.root.RootRouter
import com.example.dagger_ribs.units.root.RootView
import com.example.dagger_ribs.units.root.di.RootComponent
import com.uber.rib.core.Builder

class RootBuilder(dependency: RootDependencies)
    : Builder<RootRouter, RootDependencies>(dependency){

    fun build() : RootRouter {
        val view = RootView()
        val interactor = RootInteractor()
        val component : RootComponent = DaggerRootComponent.builder()
            .dependencies(dependency)
            .view(view)
            .interactor(interactor)
            .build()
        return component.router()
    }
}