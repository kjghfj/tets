package com.ulimit.test

import retrofit2.http.GET

interface JokeService {
    @GET("/api?format=json")
    suspend fun getRandomJoke(): JokeResponse
}