package com.ulimit.test

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object KohinModule {
    val networkModule = module {
        single {
            Retrofit.Builder()
                .baseUrl("https://geek-jokes.sameerkumar.website")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(JokeService::class.java)
        }
    }

}