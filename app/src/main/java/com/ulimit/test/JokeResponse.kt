package com.ulimit.test

import com.google.gson.annotations.SerializedName

data class JokeResponse(

	@field:SerializedName("joke")
	val joke: String? = null
)
