package com.example.gamebox

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.view.View


fun View.animatePosition(x: Float, y: Float) {
    ObjectAnimator.ofPropertyValuesHolder(
        this,
        PropertyValuesHolder.ofFloat(
            "translationY", y
        ),
        PropertyValuesHolder.ofFloat(
            "translationX", x
        )
    ).start()
}