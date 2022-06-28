package com.example.transactionportal.data.requests

import com.google.gson.annotations.SerializedName
import okhttp3.Response

data class TransactionRequest(

    @SerializedName("token")
    var token: String,

    )
