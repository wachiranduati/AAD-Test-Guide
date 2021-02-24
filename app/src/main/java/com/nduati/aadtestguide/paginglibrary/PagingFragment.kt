package com.nduati.aadtestguide.paginglibrary

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.nduati.aadtestguide.R
import com.nduati.aadtestguide.paginglibrary.paging.RetrofitClient
import com.nduati.aadtestguide.paginglibrary.paging.StackApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class PagingFragment : Fragment() {
    lateinit var root : View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_paging, container, false)
        callAPI()
        return root
    }

    private fun callAPI() {
        val call : Call<StackApiResponse> = RetrofitClient().getAnswers(1, 50, "stackoverflow")

        call.enqueue(object : Callback<StackApiResponse>{
            override fun onResponse(
                call: Call<StackApiResponse>,
                response: Response<StackApiResponse>
            ) {
                Toast.makeText(
                    view?.context,
                    response.body()?.items?.size.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onFailure(call: Call<StackApiResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }

    companion object {
        private const val TAG = "PagingFragment"
    }


}