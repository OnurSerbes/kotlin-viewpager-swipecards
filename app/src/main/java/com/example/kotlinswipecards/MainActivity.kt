package com.example.kotlinswipecards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.fameidentitykotlin.View.info.screens.mainfragments.cardholder.MyAdapter
import kotlin.math.abs
import kotlin.math.max

private lateinit var myAdapter: MyAdapter

var viewPager: ViewPager2 ?= null


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewpager)
        myAdapter = MyAdapter()
        createCardHolder()

    }

    private fun createCardHolder() {
        viewPager?.orientation = ViewPager2.ORIENTATION_HORIZONTAL;
        viewPager?.adapter = myAdapter;
        viewPager?.offscreenPageLimit = 3;

        val pageMargin = resources.getDimensionPixelOffset(R.dimen.pageMargin).toFloat()
        val pageOffset = resources.getDimensionPixelOffset(R.dimen.offset).toFloat()

        viewPager?.setPageTransformer(ViewPager2.PageTransformer { page: View, position: Float ->
            val myOffset = position * -(2 * pageOffset + pageMargin)
            when {
                position < -1 -> {
                    page.translationX = -myOffset
                }
                position <= 1 -> {
                    val scaleFactor =
                        max(0.7f, 1 - abs(position - 0.14285715f))
                    page.translationX = myOffset
                    page.scaleY = scaleFactor
                    page.alpha = scaleFactor
                }
                else -> {
                    page.alpha = 0f
                    page.translationX = myOffset
                }
            }
        })
    }
}