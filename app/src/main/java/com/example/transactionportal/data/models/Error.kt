package com.example.transactionportal.data.models

import com.google.gson.annotations.SerializedName
import okhttp3.internal.http2.ErrorCode

data class Error(

    @SerializedName("error")
    var error: ErrorCode
)
