package com.example.dagger_ribs.units.root

import android.util.Log
import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.coroutineScope
import kotlinx.coroutines.launch

class RootInteractor : Interactor<RootInteractor.Presenter, RootRouter>() {
    override fun didBecomeActive(savedInstanceState: Bundle?) {
        super.didBecomeActive(savedInstanceState)

        coroutineScope.launch {
            router.attachLogin()
            router.loginRouter?.view?.loginSuccess?.collect {
                if (it) {
                    router.detachLogin()
                    router.attachMenu()
                } else {
                    Log.d("MENU", "NOT ATTACHED")
                }
            }
        }
    }
    interface Presenter

    fun userLoggedOut() {
        val loggedOut = router.menuRouter?.interactor?.injectedPresenter?.userLoggedOut() ?: false

        if (loggedOut) {
            router.detachMenu()
            router.attachLogin()
        }
    }
}