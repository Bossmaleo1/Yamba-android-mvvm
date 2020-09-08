package com.dagger.core.data

data class User (
    val id : Int?,
    val firstname : String?,
    val lastname : String?,
    val birthday : String?,//date de naissance c'est (date & timezone) en string
    val sex : String?,
    val email : String?,
    val password : String?,
    val lang : String?,
    val state : Int?,
    val online : Int?,
    val active : Int?,
    val activationcode : String?,
    val keypush : String?,
    val tokenUser : String?
)