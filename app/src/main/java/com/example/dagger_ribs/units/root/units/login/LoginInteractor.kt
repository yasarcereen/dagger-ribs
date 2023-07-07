package com.example.dagger_ribs.units.root.units.login

import android.util.Log
import com.example.dagger_ribs.units.root.units.events.LoginEvent
import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginInteractor : Interactor<LoginInteractor.Presenter, LoginRouter>() {

    @Inject
    lateinit var loginEvents: FlowCollector<@JvmSuppressWildcards LoginEvent>

    override fun didBecomeActive(savedInstanceState: Bundle?) {
        super.didBecomeActive(savedInstanceState)

        coroutineScope.launch {
            injectedPresenter.continueButtonClick().collect {
                if (injectedPresenter.checkCredentials()) {
                    loginEvents.emit(LoginEvent.Success("logged in"));
                    Log.d("LoginInteractor", "LoginEvent emitted")
                }
            }
        }
    }
    interface Presenter {
        fun continueButtonClick() : Flow<Unit>
        fun checkCredentials() : Boolean
    }
}