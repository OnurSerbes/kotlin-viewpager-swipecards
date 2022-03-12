package com.example.kotlinswipecards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.fameidentitykotlin.View.info.screens.mainfragments.cardholder.MyAdapter
import com.example.kotlinswipecards.cardholder.PagerMarginItemDecoration
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

        viewPager?.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewPager?.adapter = myAdapter
        viewPager?.offscreenPageLimit = 1

        val nextItemVisibleWidth = resources.getDimension(R.dimen.next_item_visible_width)
        val currentItemMargin =
            resources.getDimension(R.dimen.viewpager_horizontal_margin)
        val pageTranslation = nextItemVisibleWidth + currentItemMargin
        viewPager?.setPageTransformer { page: View, position: Float ->
            page.translationX = -pageTranslation * position
            page.scaleY = 1 - (0.25f * abs(position))
            page.alpha = 0.25f + (1 - abs(position))
        }
        val itemDecoration = PagerMarginItemDecoration(
            this,
            R.dimen.viewpager_horizontal_margin
        )
        viewPager?.addItemDecoration(itemDecoration)
    }
}