package com.example.transactionportal.data.requests

import com.google.gson.annotations.SerializedName

data class LoginRequest(

    @SerializedName("name")
    var name: String,

    @SerializedName("password")
    var password: String

)