package com.yamba.android.framework.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dagger.core.data.User

@Entity(tableName = "user")
data class UserEntity(

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int?,

    @ColumnInfo(name = "firstname")
    val firstname: String?,

    @ColumnInfo(name = "lastname")
    val lastname: String?,

    @ColumnInfo(name = "birthday")
    val birthday: String?,//date de naissance c'est (date & timezone) en string

    @ColumnInfo(name = "sex")
    val sex: String?,

    @ColumnInfo(name = "email")
    val email: String?,

    @ColumnInfo(name = "password")
    val password: String?,

    @ColumnInfo(name = "lang")
    val lang: String?,

    @ColumnInfo(name = "state")
    val state: Int?,

    @ColumnInfo(name = "online")
    val online: Int?,

    @ColumnInfo(name = "active")
    val active: Int?,

    @ColumnInfo(name = "activationcode")
    val activationcode: String?,

    @ColumnInfo(name = "keypush")
    val keypush: String?,

    @ColumnInfo(name = "tokenUser")
    val tokenUser: String?
) {

    companion object {

        fun fromUser(user: User) = UserEntity(
            user.id,
            user.firstname,
            user.lastname,
            user.birthday,
            user.sex,
            user.email,
            user.password,
            user.lang,
            user.state,
            user.online,
            user.active,
            user.activationcode,
            user.keypush,
            user.tokenUser
        )
    }

    fun toUser() = User(
        id,
        firstname,
        lastname,
        birthday,
        sex,
        email,
        password,
        lang,
        state,
        online,
        active,
        activationcode,
        keypush,
        tokenUser
    )
}