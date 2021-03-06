package ru.android.zheka.vm

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.children
import io.reactivex.Observable
import ru.android.zheka.coreUI.IActivity
import ru.android.zheka.coreUI.RxTransformer
import ru.android.zheka.db.DbFunctions
import ru.android.zheka.db.Point
import ru.android.zheka.gmapexample1.GeoPositionActivity
import ru.android.zheka.gmapexample1.PositionInterceptor
import ru.android.zheka.gmapexample1.R
import ru.android.zheka.model.ILatLngModel
import ru.android.zheka.model.LatLngModel

open class LatLngVM(override val view: IActivity, val model: LatLngModel) : ILatLngVM {
    open val points: MutableList<Point>

    init {
        points = DbFunctions.getTablesByModel(Point::class.java) as MutableList<Point>
    }

    override val onClickListener: View.OnClickListener?
        get() = View.OnClickListener { view -> onClick(getPosition(view)) }

    private fun getPosition(view: View): Int {
        return (view as ViewGroup).children
                .filter { it is Button }
                .map { shownItems.indexOf((it as Button).text)}
                .filter { it != -1 }
                .first()
    }

    private fun onClick(adapterPosition: Int) {
        Observable.just(true).compose(RxTransformer.observableIoToMain())
                .subscribe({
                    val positionInterceptor = PositionInterceptor(view.activity)
                    positionInterceptor.centerPosition = points[adapterPosition].data
                    positionInterceptor.end = positionInterceptor.end?:positionInterceptor.centerPosition
                    val geoIntent = positionInterceptor.newIntent
                    geoIntent.setClass(view.context, GeoPositionActivity::class.java)

                    view.activity.startActivity(geoIntent)
                    view.activity.finish()
                },
                    view::showError)
    }

    override val shownItems: MutableList<String>
        get() = points.map { point -> point.name }.toMutableList()

    override val context: Context
        get() = view.context

    override fun onResume() {
        model.titleText().set(view.activity.resources.getString(R.string.title_activity_points))
    }

    override fun model(): ILatLngModel {
        return model
    }

    override fun onDestroy() {
        points.removeAll(points)
    }
}
