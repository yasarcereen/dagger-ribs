package com.example.dagger_ribs.units.root

import android.util.Log
import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.coroutineScope
import kotlinx.coroutines.launch

class RootInteractor : Interactor<RootInteractor.Presenter, RootRouter>() {
    override fun didBecomeActive(savedInstanceState: Bundle?) {
        super.didBecomeActive(savedInstanceState)

        router.attachLogin()




    }
    interface Presenter

    /*private suspend fun userLoggedIn() {
        val loggedIn = router.loginRouter?.interactor?.injectedPresenter?.loggedIn() ?: false

        Log.d("LOGGED IN", loggedIn.toString())

        if (loggedIn) {
            router.detachLogin()
            router.attachMenu()
        }
    }*/

    fun userLoggedOut() {
        val loggedOut = router.menuRouter?.interactor?.injectedPresenter?.userLoggedOut() ?: false

        if (loggedOut) {
            router.detachMenu()
            router.attachLogin()
        }
    }
}