package com.example.dagger_ribs.units.root.units.login.builder

import com.example.dagger_ribs.units.root.units.events.LoginEvent
import kotlinx.coroutines.flow.FlowCollector

interface LoginDependencies {
    fun loginEvent() : FlowCollector<@JvmSuppressWildcards LoginEvent>
}