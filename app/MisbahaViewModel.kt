package com.hudazamov.myquran.activity

import androidx.lifecycle.ViewModel
import com.hudazamov.myquran.MisbahaRepository


class MisbahaViewModel  constructor(private val misbahaRepository: MisbahaRepository) : ViewModel() {

    fun getMisbahaCount(): Int = misbahaRepository.getMisbahaCount()
    fun setMisbahaCount(count: Int) = misbahaRepository.setMisbahaCount(count)

    fun setVibrateOn(boolean: Boolean) = misbahaRepository.setVibrateOn(boolean)
    fun isVibrateOn(): Boolean = misbahaRepository.isVibrateOn()
}