package net.joeaustin.taktools.event

import java.util.concurrent.CopyOnWriteArrayList

open class Event<T : Any?> {
    protected val listeners = CopyOnWriteArrayList<EventHandler<T>>()

    fun addListener(handler: EventHandler<T>) {
        listeners.addIfAbsent(handler)
    }

    fun removeListener(handler: EventHandler<T>) {
        listeners.remove(handler)
    }

    operator fun plusAssign(handler: EventHandler<T>) = addListener(handler)
    operator fun minusAssign(handler: EventHandler<T>) = removeListener(handler)


}