package com.hudazamov.myquran

interface MisbahaRepository {
    fun getMisbahaCount(): Int
    fun setMisbahaCount(count: Int)
    fun isVibrateOn(): Boolean
    fun setVibrateOn(boolean: Boolean)
}