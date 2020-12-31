package net.joeaustin.taktools.event

fun interface EventHandler<T : Any?> {
    fun onEvent(sender: Any, value: T)
}