package com.example.dagger_ribs.units.root

import com.uber.rib.core.Interactor

class RootInteractor : Interactor<RootInteractor.Presenter, RootRouter>() {
    interface Presenter

    fun userLoggedIn() {
        val loggedIn = router.loginRouter?.interactor?.injectedPresenter?.loggedIn() ?: false

        if (loggedIn) {
            router.detachLogin()
            router.attachMenu()
        }
    }

    fun userLoggedOut() {
        val loggedOut = router.menuRouter?.interactor?.injectedPresenter?.userLoggedOut() ?: false

        if (loggedOut) {
            router.detachMenu()
            router.attachLogin()
        }
    }
}