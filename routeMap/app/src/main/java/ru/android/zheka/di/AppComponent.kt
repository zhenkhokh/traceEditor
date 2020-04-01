package ru.android.zheka.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.android.zheka.gmapexample1.Application
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, HomeBinding::class, MainBinding::class])
interface AppComponent : AndroidInjector<Application?> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application?): Builder?
        fun appModule(appModule: AppModule?): Builder?

        //        Builder homeModule(HomeModule appModule);
        fun build(): AppComponent?
    }
}