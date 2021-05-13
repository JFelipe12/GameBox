package com.example.gamebox

import java.util.*

object Utils {

    val randomInstance = Random()

    val colorList = listOf(
        R.color.purple_200,
        R.color.purple_500,
        R.color.purple_700,
        R.color.teal_200,
        R.color.teal_700,
        R.color.brown,
        R.color.orange,
        R.color.orange_400,
        R.color.yellow
    )

    fun getRandomColor() = colorList[randomInstance.nextInt(colorList.size)]


}