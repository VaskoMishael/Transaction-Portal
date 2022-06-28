package com.example.transactionportal.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.transactionportal.R
import com.example.transactionportal.data.ApiClient
import com.example.transactionportal.data.requests.LoginRequest
import com.example.transactionportal.data.responces.LoginResponse
import com.example.transactionportal.databinding.LoginActivityBinding
import com.example.transactionportal.utils.TokenManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var tokenManager: TokenManager
    private lateinit var apiClient: ApiClient
    private lateinit var binding: LoginActivityBinding  //defining the binding class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        binding = LoginActivityBinding.inflate(layoutInflater)       //viewBinder
        setContentView(binding.root)

        apiClient = ApiClient()
        tokenManager = TokenManager(this)

        binding.loginBtn.setOnClickListener {
            apiClient.getApiService(this).login(
                LoginRequest(
                    name = binding.name.toString(),
                    password = binding.password.toString()
                )
            )
                .enqueue(object : Callback<LoginResponse> {
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        // Error logging in
                    }

                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        val loginResponse = response.body()
                        if (loginResponse?.code == 200 || loginResponse?.code == 100) {
                            tokenManager.saveAuthToken(loginResponse.result)
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            startActivity(intent)
                        } else {
                            // Error logging in
                        }
                    }
                })
        }
    }
}