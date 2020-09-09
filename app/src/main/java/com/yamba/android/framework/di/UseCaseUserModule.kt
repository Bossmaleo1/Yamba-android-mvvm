package com.yamba.android.framework.di

import com.dagger.core.repository.UserRepository
import com.dagger.core.usecase.AddUser
import com.dagger.core.usecase.GetAllUser
import com.dagger.core.usecase.GetUser
import com.dagger.core.usecase.RemoveUser
import com.yamba.android.framework.model.usecase.UseCasesUser
import dagger.Module
import dagger.Provides

@Module
class UseCaseUserModule {

    @Provides
    fun getUseCases(repository:UserRepository) = UseCasesUser(
        AddUser(repository),
        GetAllUser(repository),
        GetUser(repository),
        RemoveUser(repository)
    )

}