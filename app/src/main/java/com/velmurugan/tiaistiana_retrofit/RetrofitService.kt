package com.velmurugan.tiaistiana_retrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
// TODO 1 : Bagian untuk request ke webservice --> Library yang digunakan
interface RetrofitService {
    // Pada format json data list movie diambil

    @GET("movielist.json")
    fun getAllMovies() : Call<List<Movie>>
//Retrofit adalah sebuah library yang digunakan untuk mempermudah proses pertukaran data antara aplikasi
    // android dengan server melalui REST API.Berikut ini referensi yang dapat digunakan untuk mempelajari
    // retrofit silahkan dipelajari sendiri
    companion object {
        //digunakan untuk menginisialisasi retofiteservice

        var retrofitService: RetrofitService? = null

        fun getInstance() : RetrofitService {

            //digunakan untuk mengambil data dari internet
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()

                    .baseUrl("https://howtodoandroid.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                // digunakan untuk membangun API mengguankan retrofitservice
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
            // return atau menegembalikan retrofitservice
        }
    }
}