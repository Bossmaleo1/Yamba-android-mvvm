package com.yamba.android.framework.model.db

import androidx.room.*
import com.yamba.android.framework.model.entity.UserEntity

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUserEntity(userEntity: UserEntity)

    @Query("SELECT * FROM user WHERE id = :id")
    suspend fun getUserEntity(id : Long): UserEntity?

    @Query("SELECT * FROM user")
    suspend fun getAllUserEntities() : List<UserEntity>

    @Delete
    suspend fun deleteUserEntity(userEntity: UserEntity)

}