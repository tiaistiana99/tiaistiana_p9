package com.velmurugan.tiaistiana_retrofit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MyViewModelFactory constructor(private val repository: MainRepository): ViewModelProvider.Factory {
// Nah Mvvm merupakan Model-View-ViewModel. MVVM menghubungan antar komponen.
//mvvm juga bekerja dengan konsep observable. Dari satu komponen ke komponen
// lain tidak terhubung secara langsung melainkan lewat reference yang terdapat di observable
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}