package com.example.dagger_ribs.units.root.units.login

import com.uber.rib.core.Interactor
import kotlinx.coroutines.flow.Flow

class LoginInteractor : Interactor<LoginInteractor.Presenter, LoginRouter>() {
    interface Presenter {
        fun continueButtonClick() : Flow<Unit>
        fun checkCredentials() : Boolean

        fun loggedIn() : Boolean
    }
}