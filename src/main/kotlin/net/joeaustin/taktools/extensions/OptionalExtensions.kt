package net.joeaustin.taktools.extensions

import java.util.*

fun <T> T?.toOptional(): Optional<T> = Optional.ofNullable(this)