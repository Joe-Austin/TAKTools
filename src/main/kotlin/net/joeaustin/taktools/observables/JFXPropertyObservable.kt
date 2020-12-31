package net.joeaustin.taktools.observables

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableValue
import net.joeaustin.taktools.extensions.toOptional
import java.util.*
import java.util.concurrent.atomic.AtomicBoolean

class JFXPropertyObservable<T : Any?>(
    private val observableValue: ObservableValue<T>,
    private val skipInitial: Boolean = false
) : Observable<Optional<T>>() {
    override fun subscribeActual(observer: Observer<in Optional<T>>) {
        val listener = Listener(observableValue, observer)
        observer.onSubscribe(listener)
        if (!skipInitial) observer.onNext(observableValue.value.toOptional())
        observableValue.addListener(listener)
    }

    private inner class Listener(
        private val observableValue: ObservableValue<T>,
        private val observer: Observer<in Optional<T>>
    ) : ChangeListener<T>, Disposable {
        private val isDisposed = AtomicBoolean(false)

        override fun changed(observable: ObservableValue<out T>?, oldValue: T, newValue: T) {
            if (!isDisposed()) {
                observer.onNext(newValue.toOptional())
            }
        }

        override fun dispose() {
            if (!isDisposed.getAndSet(true)) {
                observableValue.removeListener(this)
            }
        }

        override fun isDisposed(): Boolean = isDisposed.get()
    }
}