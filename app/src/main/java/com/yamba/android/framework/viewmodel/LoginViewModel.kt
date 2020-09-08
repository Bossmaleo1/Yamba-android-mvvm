package com.yamba.android.framework.viewmodel

import android.app.Application
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yamba.android.framework.util.Event
import com.yamba.android.R

class LoginViewModel (application: Application) : AndroidViewModel(application), Observable {

    @Bindable
    val labelemail = MutableLiveData<String>()
    @Bindable
    val labelpassword = MutableLiveData<String>()
    @Bindable
    val passwordforget = MutableLiveData<String>()
    @Bindable
    val inputTextEmail = MutableLiveData<String>()
    @Bindable
    val inputTextPassword = MutableLiveData<String>()

    private val statusMessage = MutableLiveData<Event<String>>()

    val message : LiveData<Event<String>>
        get() = statusMessage


    init {
        labelemail.value = application.resources.getString(R.string.youremail)
        labelpassword.value = application.resources.getString(R.string.yourpassword)
        passwordforget.value = application.resources.getString(R.string.passwordforget)
        inputTextEmail.value = ""
        inputTextPassword.value = ""
        statusMessage.value = Event("Test du Toast styler")
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }


}