package com.example.dagger_ribs.units.root.units.menu.builder

import com.example.dagger_ribs.units.root.units.events.LogoutEvent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

interface MenuDependencies {
    fun logoutEvent(): FlowCollector<@JvmSuppressWildcards LogoutEvent>
}