package com.example.dagger_ribs.units.root.units.login

import android.util.Log
import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import kotlinx.coroutines.flow.Flow

class LoginInteractor : Interactor<LoginInteractor.Presenter, LoginRouter>() {

    override fun didBecomeActive(savedInstanceState: Bundle?) {
        super.didBecomeActive(savedInstanceState)
    }
    interface Presenter {
        fun continueButtonClick() : Flow<Unit>
        fun checkCredentials() : Boolean

        fun loggedIn() : Boolean
    }
}