package com.yamba.android.framework.di

import android.app.Application
import com.dagger.core.repository.UserRepository
import com.yamba.android.framework.model.db.RoomUserEntityDataSource
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideRepository(app: Application)  = UserRepository(RoomUserEntityDataSource(app))

}