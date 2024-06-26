package com.example.demo2.step2.db

import java.util.*

object GetMonth {
    var dayStar1 = 1
    var dayEnd1 = 31
    var dayStar2 = 32
    var dayEnd2 = 59
    var dayStar3 = 60
    var dayEnd3 = 89
    var dayStar4 = 90
    var dayEnd4 = 119
    var dayStar5 = 120
    var dayEnd5 = 149
    var dayStar6 = 150
    var dayEnd6 = 179
    var dayStar7 = 180
    var dayEnd7 = 209
    var dayStar8 = 210
    var dayEnd8 = 239
    var dayStar9 = 240
    var dayEnd9 = 269
    var dayStar10 = 270
    var dayEnd10 = 299
    var dayStar11 = 300
    var dayEnd11 = 329
    var dayStar12 = 330
    var dayEnd12 = 365

    fun getList(year: Int) {
        //StepDataSource.getListStepDay(dayStart, dayEnd, year)
        //StepDataSource.getListTimeStepDay(dayStart, dayEnd, year)
        //StepDataSource.getListCaloDay(10F, dayStart, dayEnd, year)
        //StepDataSource.getListDistanceDay(20F, dayStart, dayEnd, year)


        if (year % 4 == 0) {
            var stepMonth1 = StepDataSource.getListStepDay(1, 31, year)
            var stepMonth2 = StepDataSource.getListStepDay(32, 59, year)
            var stepMonth3 = StepDataSource.getListStepDay(60, 89, year)
            var stepMonth4 = StepDataSource.getListStepDay(90, 119, year)
            var stepMonth5 = StepDataSource.getListStepDay(120, 149, year)
            var stepMonth6 = StepDataSource.getListStepDay(150, 179, year)
            var stepMonth7 = StepDataSource.getListStepDay(180, 209, year)
            var stepMonth8 = StepDataSource.getListStepDay(210, 239, year)
            var stepMonth9 = StepDataSource.getListStepDay(240, 269, year)
            var stepMonth10 = StepDataSource.getListStepDay(270, 299, year)
            var stepMonth11 = StepDataSource.getListStepDay(300, 329, year)
            var stepMonth12 = StepDataSource.getListStepDay(330, 365, year)

            var timeMonth1 = StepDataSource.getListStepDay(1, 31, year)
            var timeMonth2 = StepDataSource.getListStepDay(32, 59, year)
            var timeMonth3 = StepDataSource.getListStepDay(60, 89, year)
            var timeMonth4 = StepDataSource.getListStepDay(90, 119, year)
            var timeMonth5 = StepDataSource.getListStepDay(120, 149, year)
            var timeMonth6 = StepDataSource.getListStepDay(150, 179, year)
            var timeMonth7 = StepDataSource.getListStepDay(180, 209, year)
            var timeMonth8 = StepDataSource.getListStepDay(210, 239, year)
            var timeMonth9 = StepDataSource.getListStepDay(240, 269, year)
            var timeMonth10 = StepDataSource.getListStepDay(270, 299, year)
            var timeMonth11 = StepDataSource.getListStepDay(300, 329, year)
            var timeMonth12 = StepDataSource.getListStepDay(330, 365, year)
        } else {
            var stepMonth1 = StepDataSource.getListStepDay(1, 31, year)
            var stepMonth2 = StepDataSource.getListStepDay(32, 60, year)
            var stepMonth3 = StepDataSource.getListStepDay(61, 90, year)
            var stepMonth4 = StepDataSource.getListStepDay(91, 120, year)
            var stepMonth5 = StepDataSource.getListStepDay(121, 150, year)
            var stepMonth6 = StepDataSource.getListStepDay(151, 180, year)
            var stepMonth7 = StepDataSource.getListStepDay(181, 210, year)
            var stepMonth8 = StepDataSource.getListStepDay(211, 240, year)
            var stepMonth9 = StepDataSource.getListStepDay(241, 270, year)
            var stepMonth10 = StepDataSource.getListStepDay(271, 300, year)
            var stepMonth11 = StepDataSource.getListStepDay(301, 330, year)
            var stepMonth12 = StepDataSource.getListStepDay(331, 366, year)
        }
    }

    fun getMonth() {
        val c = Calendar.getInstance()
        val month = c.get(Calendar.MONTH)
        val year = c.get(Calendar.YEAR)
        GetMonth.getList(year)
        if(month == 1){

        }
    }
}