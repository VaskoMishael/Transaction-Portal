package com.example.transactionportal.data.responces

import com.example.transactionportal.data.models.Error
import com.example.transactionportal.data.models.Result
import com.google.gson.annotations.SerializedName

data class LoginResponse(

    @SerializedName("code")
    var code: Int,

    @SerializedName("message")
    var message: String,

    @SerializedName("result")
    var result: String,

    @SerializedName("error")
    var error: Error
)
