package net.joeaustin.taktools.observables

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import net.joeaustin.taktools.event.Event
import net.joeaustin.taktools.event.EventHandler
import net.joeaustin.taktools.extensions.toOptional
import java.util.*
import java.util.concurrent.atomic.AtomicBoolean

class EventObservable<T : Any?>(private val event: Event<T>) : Observable<Optional<T>>() {
    override fun subscribeActual(observer: Observer<in Optional<T>>) {
        val listener = Listener(event, observer)
        observer.onSubscribe(listener)
        event.addListener(listener)
    }

    private inner class Listener(
        private val event: Event<T>,
        private val observer: Observer<in Optional<T>>
    ) : EventHandler<T>, Disposable {
        private val isDisposed = AtomicBoolean(false)

        override fun onEvent(sender: Any, value: T) {
            if (!isDisposed()) {
                observer.onNext(value.toOptional())
            }
        }

        override fun dispose() {
            if (!isDisposed.getAndSet(true)) {
                event.removeListener(this)
            }
        }

        override fun isDisposed(): Boolean = isDisposed.get()
    }
}