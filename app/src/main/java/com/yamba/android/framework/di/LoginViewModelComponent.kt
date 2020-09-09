package com.yamba.android.framework.di

import com.yamba.android.framework.viewmodel.LoginViewModel
import dagger.Component

@Component(modules = [AppModule::class,RepositoryModule::class,UseCaseUserModule::class])
interface  LoginViewModelComponent {

    fun inject(loginViewModel: LoginViewModel)

}

