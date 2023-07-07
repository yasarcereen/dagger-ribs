package com.example.dagger_ribs.units.root.units.events

sealed interface LoginEvent {
    class Success(val response: String) : LoginEvent
}