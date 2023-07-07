package com.example.dagger_ribs.units.root

import android.util.Log
import com.example.dagger_ribs.units.root.units.events.LoginEvent
import com.example.dagger_ribs.units.root.units.events.LogoutEvent
import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class RootInteractor : Interactor<RootInteractor.Presenter, RootRouter>() {

    @Inject
    lateinit var loginEvents: Flow<@JvmSuppressWildcards LoginEvent>

    @Inject
    lateinit var logoutEvents: Flow<@JvmSuppressWildcards LogoutEvent>

    override fun didBecomeActive(savedInstanceState: Bundle?) {
        super.didBecomeActive(savedInstanceState)

        router.attachLogin()

        coroutineScope.launch {
            loginEvents.collectLatest {
                Log.d("RootInteractor", "LoginEvents collecting")
                when (it) {
                    is LoginEvent.Success -> {
                        Log.d("RootInteractor", "LoginEvents Success")
                        router.detachLogin()
                        router.attachMenu()
                    }
                }
            }
        }

        coroutineScope.launch {
            logoutEvents.collectLatest {
                Log.d("RootInteractor", "LogoutEvents collecting")
                when (it) {
                    is LogoutEvent.Success -> {
                        Log.d("RootInteractor", "LogoutEvents Success")
                        router.detachMenu()
                        router.attachLogin()
                    }
                }
            }
        }
    }
    interface Presenter
}