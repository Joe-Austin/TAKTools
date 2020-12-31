package net.joeaustin.taktools.extensions

import io.reactivex.rxjava3.core.Observable
import net.joeaustin.taktools.event.Event
import net.joeaustin.taktools.observables.EventObservable
import java.util.*

fun <T : Any?> Event<T>.toObservable(): Observable<Optional<T>> = EventObservable(this)