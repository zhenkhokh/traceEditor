package ru.android.zheka.vm

import ru.android.zheka.coreUI.IVM
import ru.android.zheka.model.IMapModel

interface IMapVM : IVM<IMapModel?> { //TODO
    fun geo()
    fun toMap()
    fun fakeStart()
    fun home()
    fun hide()
    fun mapType()
}