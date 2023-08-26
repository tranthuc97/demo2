package com.example.demo2.step2

import android.graphics.Color
import com.example.demo2.BaseAct
import com.example.demo2.databinding.ActivityBarChartBinding
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry


class BarChartActivity : BaseAct<ActivityBarChartBinding>() {
    override fun initViewBinding(): ActivityBarChartBinding {
        return ActivityBarChartBinding.inflate(layoutInflater)
    }

    override fun initViews() {

        // Get the bar chart view.
        // Get the bar chart view.
        val barChart = findViewById<BarChart>(com.example.demo2.R.id.baBarChart)


        // Set the data for the bar chart.

        // Set the data for the bar chart.
        val entries: MutableList<BarEntry> = ArrayList()
        entries.add(BarEntry(1f, 2000f))
        entries.add(BarEntry(2f, 6000f))
        entries.add(BarEntry(3f, 3000f))
        entries.add(BarEntry(4f, 2500f))
        entries.add(BarEntry(5f, 3200f))
        entries.add(BarEntry(6f, 1155f))
        entries.add(BarEntry(7f, 4560f))

        val barDataSet = BarDataSet(entries, null)
        barDataSet.setColors(Color.RED, Color.GREEN, Color.BLUE)
        barDataSet.setDrawIcons(true)

        val barData = BarData(barDataSet)
        barChart.data = barData
        barChart.setBackgroundColor(Color.WHITE)        //màu nền
        barChart.setGridBackgroundColor(Color.RED);     // màu lưới
        barChart.setDrawGridBackground(false)       //hiện màu lưới

        barChart.getXAxis().setEnabled(false)
        barChart.getAxisLeft().setDrawAxisLine(false)
        barChart.getAxisLeft().setDrawGridLines(false)
        barChart.getAxisRight().setEnabled(false)
        val barChartRender =
            CustomBarChartConner(barChart, barChart.animator, barChart.viewPortHandler)
        barChartRender.mRadius = 20
        barChart.renderer = barChartRender
        // Set the properties of the bar chart.


    }
}