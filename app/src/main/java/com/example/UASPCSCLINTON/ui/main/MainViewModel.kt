package com.example.UASPCSCLINTON.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.UASPCSCLINTON.api.RetrofitClient
import com.example.UASPCSCLINTON.data.User
import com.example.UASPCSCLINTON.data.model.UserResponse
import retrofit2.Call
import retrofit2.Response

class MainViewModel : ViewModel() {
    val listUsers = MutableLiveData<ArrayList<User>>()

    fun setSearchUsers(query: String) {
        RetrofitClient.apiInstace
                .getSearchUsers(query)
                .enqueue(object : retrofit2.Callback<UserResponse>{
                    override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                        if (response.isSuccessful){
                            listUsers.postValue(response.body()?.items)
                        }
                    }

                    override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                        Log.d("Failure", t.message.toString())

                    }

                })

    }
    fun getSearchUsers () : LiveData<ArrayList<User>>{
        return listUsers
    }

}