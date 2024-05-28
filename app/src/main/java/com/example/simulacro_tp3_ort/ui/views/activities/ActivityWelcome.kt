package com.example.simulacro_tp3_ort.ui.views.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.simulacro_tp3_ort.R
import com.example.simulacro_tp3_ort.ui.views.adapters.AdapterWelcome

class ActivityWelcome : AppCompatActivity() {

    private lateinit var indicators: List<ImageView>
    private lateinit var viewPager2: ViewPager2

    private val activeColor by lazy { ContextCompat.getColor(this, R.color.grey) }
    private val inactiveColor by lazy { ContextCompat.getColor(this, R.color.white) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.lay_activity_welcome)
        viewPager2 = findViewById(R.id.view_pager2)
        val buttonWelcome = findViewById<Button>(R.id.button_welcome)

        indicators = listOf(
            findViewById(R.id.indicatorWelcome1),
            findViewById(R.id.indicatorWelcome2),
            findViewById(R.id.indicatorWelcome3)
        )

        val images = listOf(R.drawable.dog1, R.drawable.dog2, R.drawable.dog3)
        val adapter = AdapterWelcome(images)

        viewPager2.adapter = adapter

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback()
        {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                changeColor()
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                changeColor()
            }
        })

        buttonWelcome.setOnClickListener {
            val intent = Intent(this, ActivityHome::class.java)
            startActivity(intent)
        }
    }

    fun changeColor()
    {
       when(viewPager2.currentItem)
       {
           0->
           {
               indicators[0].setBackgroundColor(activeColor)
               indicators[1].setBackgroundColor(inactiveColor)
               indicators[2].setBackgroundColor(inactiveColor)
           }
           1->
           {
               indicators[0].setBackgroundColor(inactiveColor)
               indicators[1].setBackgroundColor(activeColor)
               indicators[2].setBackgroundColor(inactiveColor)
           }
           2->
           {
               indicators[0].setBackgroundColor(inactiveColor)
               indicators[1].setBackgroundColor(inactiveColor)
               indicators[2].setBackgroundColor(activeColor)
           }
       }
    }
}