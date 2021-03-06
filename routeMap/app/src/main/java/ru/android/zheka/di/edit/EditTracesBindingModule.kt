package ru.android.zheka.di.edit

import dagger.Module
import dagger.Provides
import ru.android.zheka.di.FragmentChildScope
import ru.android.zheka.fragment.Edit
import ru.android.zheka.fragment.IEditTraces
import ru.android.zheka.model.LatLngModel
import ru.android.zheka.vm.EditTracesVM
import ru.android.zheka.vm.IEditTracesVM

@Module(includes = [EditModule::class])
class EditTracesBindingModule {
    @Provides
    fun bindEditTracesVM(model: LatLngModel?, view: IEditTraces?): IEditTracesVM {
        return EditTracesVM(view!!, model!!)
    }

    @FragmentChildScope
    @Provides
    fun provideEdit(): Edit {
        return Edit()
    }
}