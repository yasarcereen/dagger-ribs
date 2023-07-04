package com.example.dagger_ribs.units.root.units.menu

import android.util.Log
import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MenuInteractor : Interactor<MenuInteractor.Presenter, MenuRouter>() {

    override fun didBecomeActive(savedInstanceState: Bundle?) {
        super.didBecomeActive(savedInstanceState)

        coroutineScope.launch {
            Log.d("MENU", "ACTIVE")
        }
    }
    interface Presenter {
        fun logoutButtonClick() : Flow<Unit>

        fun userLoggedOut() : Boolean
    }
}