package net.joeaustin.taktools.event

class RaisableEvent<T : Any?> : Event<T>() {
    fun raiseEvent(sender: Any, value: T) {
        listeners.forEach { handler ->
            handler.onEvent(sender, value)
        }
    }
}