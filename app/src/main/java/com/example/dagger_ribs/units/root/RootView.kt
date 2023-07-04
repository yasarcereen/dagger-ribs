package com.example.dagger_ribs.units.root

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import com.example.dagger_ribs.utils.compose.rib.Compose

class RootView : Compose, RootInteractor.Presenter {
    private val mutableChildView = mutableStateOf<ComposableHolder?>(null)
    private val mutableUpdateView = mutableStateOf<Compose?>(null)
    @Composable
    override fun Content(modifier: Modifier) {

        mutableUpdateView.value?.Content(Modifier)

    }

    fun removeContainerView() {
        mutableChildView.value?.let {
            mutableChildView.value = it.copy(remove = true)
        }
    }

    fun setUpdateView(compose: Compose) {
        mutableUpdateView.value = compose
    }

    data class ComposableHolder(
        val animated: Boolean,
        val composableView: @Composable (Modifier) -> Unit,
        var remove: Boolean = false
    )
}