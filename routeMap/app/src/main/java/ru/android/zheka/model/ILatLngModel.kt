package ru.android.zheka.model

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import ru.android.zheka.db.Point

interface ILatLngModel {
    fun titleText(): ObservableField<String>
    var hideTitle: ObservableInt
    var custom: Boolean
    val points: MutableList<Point>
    var chekedVisibility: Int
    var checked: ArrayList<Boolean>
    var spinnerOption:String
    val _customPoints: MutableList<Point>
}