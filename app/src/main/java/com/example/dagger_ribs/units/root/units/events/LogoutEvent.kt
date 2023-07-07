package com.example.dagger_ribs.units.root.units.events

sealed interface LogoutEvent {
    object Success : LogoutEvent
}