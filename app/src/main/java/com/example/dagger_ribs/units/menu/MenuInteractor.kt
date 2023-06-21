package com.example.dagger_ribs.units.menu

import com.uber.rib.core.Interactor
import kotlinx.coroutines.flow.Flow

class MenuInteractor : Interactor<MenuInteractor.Presenter, MenuRouter>() {
    interface Presenter {
        fun logoutButtonClick() : Flow<Unit>
    }
}