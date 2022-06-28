package com.example.transactionportal.data.responces

import com.google.gson.annotations.SerializedName
import okhttp3.Response

data class TransactionResponse(

    @SerializedName("transactionID")
    var transactionID: String,

    )
