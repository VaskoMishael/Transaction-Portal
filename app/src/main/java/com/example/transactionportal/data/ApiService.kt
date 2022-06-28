package com.example.transactionportal.data

import com.example.transactionportal.data.requests.LoginRequest
import com.example.transactionportal.data.requests.TransactionRequest
import com.example.transactionportal.data.responces.LoginResponse
import com.example.transactionportal.data.responces.TransactionResponse
import com.example.transactionportal.utils.Constants
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST(Constants.LOGIN_URL)
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @POST(Constants.TRANSACTION_URL)
    fun getId(@Body request: TransactionRequest): Call<TransactionResponse>

}