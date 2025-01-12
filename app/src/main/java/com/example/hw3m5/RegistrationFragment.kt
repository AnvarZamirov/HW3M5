package com.example.hw3m5

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw3m5.databinding.FragmentRegistrationBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistrationFragment : Fragment() {

    private val binding by lazy { FragmentRegistrationBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCalculate.setOnClickListener {
           val response =  RetrofitService.api.fetchPercentage(
                firstName = binding.etName.text.toString(),
                host = "love-calculator.p.rapidapi.com",
                key = "13db8c0c9fmsh0e8b65404615b3ap1035a5jsn85bfe5faab5c",
                secondName = binding.etSecondName.text.toString()
            ).enqueue(object : Callback<PercentageModel>{
               override fun onResponse(
                   call: Call<PercentageModel>,
                   response: Response<PercentageModel>
               ) {
                   if (response.body() != null && response.isSuccessful) {
                       Log.e("ololo", "success: code:${response.code()} body:${response.body()}")
                   }
               }

               override fun onFailure(call: Call<PercentageModel>, t: Throwable) {
                   Log.e("ololo", "fail: code: ${t.localizedMessage}")
               }

           })

        }
    }
}


