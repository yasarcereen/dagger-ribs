package com.example.dagger_ribs.units.root

import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor

class RootInteractor : Interactor<RootInteractor.Presenter, RootRouter>() {
    override fun didBecomeActive(savedInstanceState: Bundle?) {
        super.didBecomeActive(savedInstanceState)
        router.attachLogin()
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