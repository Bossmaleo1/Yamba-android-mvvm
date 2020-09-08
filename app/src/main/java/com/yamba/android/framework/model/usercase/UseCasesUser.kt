package com.yamba.android.framework.model.usercase

import com.dagger.core.usecase.AddUser
import com.dagger.core.usecase.GetAllUser
import com.dagger.core.usecase.GetUser
import com.dagger.core.usecase.RemoveUser

data class UseCasesUser(
    val addUser: AddUser,
    val getAllUser: GetAllUser,
    val getUser: GetUser,
    val removeUser: RemoveUser
)