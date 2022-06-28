package com.example.transactionportal.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.transactionportal.R
import com.example.transactionportal.data.ApiClient
import com.example.transactionportal.databinding.LoginActivityBinding
import com.example.transactionportal.databinding.ActivityMainBinding
import com.example.transactionportal.utils.TokenManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var apiClient: ApiClient
    private lateinit var tokenSaver: TokenManager
    private lateinit var binding: ActivityMainBinding  //defining the binding class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)       //viewBinder
        setContentView(binding.root)

        apiClient = ApiClient()
        tokenSaver = TokenManager(this)


    }
}