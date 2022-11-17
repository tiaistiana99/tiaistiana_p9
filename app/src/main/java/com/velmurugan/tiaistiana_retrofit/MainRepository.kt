package com.velmurugan.tiaistiana_retrofit

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllMovies() = retrofitService.getAllMovies()
}
// get all movie digunakan untuk mengambil semua data movie yang ada