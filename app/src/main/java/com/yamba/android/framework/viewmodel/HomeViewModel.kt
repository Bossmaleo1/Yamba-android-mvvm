package com.yamba.android.framework.viewmodel

import android.app.Application
import androidx.databinding.Observable
import androidx.lifecycle.AndroidViewModel

class HomeViewModel (app: Application) : AndroidViewModel(app), Observable {


    init {

    }





    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}