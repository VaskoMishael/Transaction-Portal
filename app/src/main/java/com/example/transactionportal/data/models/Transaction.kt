package com.example.transactionportal.data.models

import com.google.gson.annotations.SerializedName
import java.time.temporal.TemporalAmount
import java.util.*

data class Transaction(
    @SerializedName("transactionId")
    var transactionId: String,

    @SerializedName("terminal_id")
    var tid: String,

    @SerializedName("merchant_id")
    var mid: String,

    @SerializedName("serial_number")
    var sn: String,

    @SerializedName("pan")
    var pan: String,

    @SerializedName("expiryDate")
    var expiryDate: String,

    @SerializedName("amount")
    var amount: Int,

    @SerializedName("variable_symbol")
    var variableSymbol: String,

    @SerializedName("branchName")
    var branchName: String,

    @SerializedName("hostTransactionId")
    var hostTransactionId: String,

    @SerializedName("transactionTerminalCreateTime")
    var transactionTerminalCreateTime: Date,

    @SerializedName("authorizationCode")
    var authorizationCode:String

)
