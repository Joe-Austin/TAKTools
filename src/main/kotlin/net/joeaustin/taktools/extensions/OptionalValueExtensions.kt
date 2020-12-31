package net.joeaustin.taktools.extensions

import io.reactivex.rxjava3.core.Observable
import javafx.beans.value.ObservableValue
import net.joeaustin.taktools.observables.JFXPropertyObservable
import java.util.*

fun <T : Any?> ObservableValue<T>.toObservable(skipInitial: Boolean = false): Observable<Optional<T>> =
    JFXPropertyObservable(this, skipInitial)
