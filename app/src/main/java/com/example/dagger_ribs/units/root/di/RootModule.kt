package com.example.dagger_ribs.units.root.di

import com.example.dagger_ribs.units.root.RootInteractor
import com.example.dagger_ribs.units.root.RootRouter
import com.example.dagger_ribs.units.root.RootView
import com.example.dagger_ribs.units.root.units.events.LoginEvent
import com.example.dagger_ribs.units.root.units.events.LogoutEvent
import com.example.dagger_ribs.units.root.units.login.builder.LoginBuilder
import com.example.dagger_ribs.units.root.units.menu.builder.MenuBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableSharedFlow

@Module
abstract class RootModule {

    companion object {
        @RootScope
        @Provides
        @JvmStatic
        fun router(
            component: RootComponent,
            view: RootView,
            interactor: RootInteractor,
        ): RootRouter {
            return RootRouter(component,view, interactor, LoginBuilder(component), MenuBuilder(component))
        }

        @RootScope
        @Provides
        @JvmStatic
        fun loginEvents(): MutableSharedFlow<LoginEvent> {
            return MutableSharedFlow()
        }

        @RootScope
        @Provides
        @JvmStatic
        fun logoutEvents(): MutableSharedFlow<LogoutEvent> {
            return MutableSharedFlow()
        }
    }

    @RootScope
    @Binds
    abstract fun presenter(view: RootView): RootInteractor.Presenter

    @RootScope
    @Binds
    abstract fun loginEventAsFlow(
        mutableFlow: MutableSharedFlow<LoginEvent>
    ): Flow<LoginEvent>

    @RootScope
    @Binds
    abstract fun loginEventAsFlowCollector(
        mutableFlow: MutableSharedFlow<LoginEvent>
    ): FlowCollector<LoginEvent>

    @RootScope
    @Binds
    abstract fun logoutEventAsFlow(
        mutableFlow: MutableSharedFlow<LogoutEvent>
    ): Flow<LogoutEvent>

    @RootScope
    @Binds
    abstract fun logoutEventAsFlowCollector(
        mutableFlow: MutableSharedFlow<LogoutEvent>
    ): FlowCollector<LogoutEvent>
}