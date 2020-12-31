package net.joeaustin.taktools.graphics.color

data class Color(val a: Int, val r: Int, val g: Int, val b: Int) {
    fun toInt(): Int {
        var value = 0
        value = value or (a shl 24)
        value = value or (r shl 16)
        value = value or (g shl 8)
        value = value or (b shl 0)

        return value
    }


    companion object {
        fun fromInt(color: Int): Color {
            val a = 0xFF and (color shr 24)
            val r = 0xFF and (color shr 16)
            val g = 0xFF and (color shr 8)
            val b = 0xFF and (color shr 0)

            return Color(a, r, g, b)
        }
    }
}