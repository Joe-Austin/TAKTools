package net.joeaustin.taktools.extensions

import net.joeaustin.taktools.graphics.color.Color

fun Int.toColor(): Color {
    return Color.fromInt(this)
}