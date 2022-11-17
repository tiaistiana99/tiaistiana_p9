package com.velmurugan.tiaistiana_retrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
// TODO 7 :Class ViewModel
// Terjadi pemrosesan data dari user interface
// TODO 3 : Bagian untuk parsing data json hasil response --> Library yang digunakan
class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    // digunakan untuk inisialisasi movielist

    val movieList = MutableLiveData<List<Movie>>()
    val errorMessage = MutableLiveData<String>()
// TODO 4 : Bagian untuk menampilkan gambar
    fun getAllMovies() {

        // mengambil semua dafatar movie

        val response = repository.getAllMovies()
        response.enqueue(object : Callback<List<Movie>> {
            // callbcak digunakan untuk mengembalikan respon yang didapaat ketika list berhasil diambil
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                movieList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}