package com.example.dagger_ribs.units.root.units.menu

import com.example.dagger_ribs.units.root.units.events.LogoutEvent
import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.launch
import javax.inject.Inject

class MenuInteractor : Interactor<MenuInteractor.Presenter, MenuRouter>() {

    @Inject
    lateinit var logoutEvents: FlowCollector<@JvmSuppressWildcards LogoutEvent>

    override fun didBecomeActive(savedInstanceState: Bundle?) {
        super.didBecomeActive(savedInstanceState)

        coroutineScope.launch {
            injectedPresenter.logoutButtonClick().collect {
                logoutEvents.emit(LogoutEvent.Success);
            }
        }
    }
    interface Presenter {
        fun logoutButtonClick() : Flow<Boolean>
    }
}