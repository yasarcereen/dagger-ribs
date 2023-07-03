package com.example.dagger_ribs.units.root.di

import com.example.dagger_ribs.units.root.RootInteractor
import com.example.dagger_ribs.units.root.RootRouter
import com.example.dagger_ribs.units.root.RootView
import com.uber.rib.core.InteractorBaseComponent
import dagger.Module
import dagger.Provides

@Module
class RootModule {
    @Provides
    fun router(view: RootView,
               interactor: RootInteractor,
               component: InteractorBaseComponent<*>
    ) : RootRouter {
        return RootRouter(view, interactor, component)
    }
}