package com.football.assets.injection

import android.app.Application
import android.content.Context
import android.content.pm.PackageInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class AndroidModule {
    @Provides
    fun provideApplicationContext(application: Application): Context = application.applicationContext

    @Provides
    fun providePackageInfo(context: Context): PackageInfo {
        return context.packageManager.getPackageInfo(context.packageName, 0)
    }
}