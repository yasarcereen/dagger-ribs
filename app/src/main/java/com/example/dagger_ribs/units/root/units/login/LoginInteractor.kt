package com.example.dagger_ribs.units.root.units.login

import android.util.Log
import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class LoginInteractor : Interactor<LoginInteractor.Presenter, LoginRouter>() {

    override fun didBecomeActive(savedInstanceState: Bundle?) {
        super.didBecomeActive(savedInstanceState)

        coroutineScope.launch {
            injectedPresenter.continueButtonClick().collect {
                if (!injectedPresenter.checkCredentials()) {
                    Log.d("LOGIN", "UNSUCCESSFUL")
                    return@collect
                } else {
                    Log.d("LOGIN", "SUCCESSFUL")
                }
            }
        }
    }
    interface Presenter {
        fun continueButtonClick() : Flow<Unit>
        fun checkCredentials() : Boolean

        suspend fun loggedIn()
    }
}