package com.example.transactionportal.ui

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
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
        fun login() {
            apiClient.getApiService(this).login(
                LoginRequest(
                    name = binding.name.text.toString(), password = binding.password.text.toString()
                )
            )
                .enqueue(object : Callback<LoginResponse> {

                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        val loginResponse = response.body()
                        if (response.isSuccessful) {
                            Toast.makeText(this@LoginActivity, "Success", Toast.LENGTH_SHORT).show()
                            if (loginResponse != null) {
                                tokenManager.saveAuthToken(loginResponse.result)
                            }
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(
                                this@LoginActivity,
                                "Failed to login",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(
                            this@LoginActivity,
                            "Throwable " + t.localizedMessage,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                })
        }
        binding.loginBtn.setOnClickListener {
            if (TextUtils.isEmpty(binding.name.text.toString()) || TextUtils.isEmpty(binding.password.text.toString())) {
                Toast.makeText(this, "Enter all fields please", Toast.LENGTH_SHORT).show()
            } else {
                login()
            }
        }

    }
}
