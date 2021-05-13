package com.example.gamebox

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import com.example.gamebox.Utils.colorList
import com.example.gamebox.Utils.getRandomColor
import com.example.gamebox.Utils.randomInstance
import com.example.gamebox.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    private val parentLayout by lazy { binding.container }

    private val constraintParams = ConstraintLayout.LayoutParams(SQUARE_WIDTH, SQUARE_HEIGHT)

    private val constraintSet = ConstraintSet()

    companion object {
        const val SQUARE_WIDTH = 150
        const val SQUARE_HEIGHT = 150
        const val SQUARE_MARGIN = 12
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setClickListeners()
    }


    private fun setClickListeners() {

        binding.btnAddSquare.setOnClickListener {

            val squareView = ImageView(this).apply {
                id = View.generateViewId()
                x = (randomInstance.nextInt(parentLayout.measuredWidth).toFloat())
                y = (randomInstance.nextInt(parentLayout.measuredHeight).toFloat())
                layoutParams = constraintParams
                setBackgroundColor(ContextCompat.getColor(this@MainActivity, getRandomColor()))
                setOnClickListener(this@MainActivity)
            }

            parentLayout.addView(squareView, 0)

            constraintSet.apply {
                clone(parentLayout)
                connect(squareView.id, ConstraintSet.TOP, parentLayout.id, ConstraintSet.TOP, SQUARE_MARGIN)
                applyTo(binding.container)
            }
        }

    }

    private fun setTransition(squareView: View) {
        squareView.setBackgroundColor(ContextCompat.getColor(this, getRandomColor()))

        randomInstance.apply {
            squareView.animatePosition(
                nextInt(parentLayout.measuredWidth).toFloat(),
                nextInt(parentLayout.measuredHeight).toFloat()
            )
        }
    }

    override fun onClick(v: View?) {
        v?.let { setTransition(it) }
    }
}