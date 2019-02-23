package bbt.com.lifeguide.client

import android.content.Context
import android.util.Log
import bbt.com.lifeguide.AppApplication
import bbt.com.lifeguide.R
import bbt.com.lifeguide.apis.Services
import bbt.com.lifeguide.helper.AppConstants
import bbt.com.lifeguide.models.ChannelResponse
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiClient(var context: Context) {
    val service = AppApplication.retrofit!!.create(Services::class.java)
    fun getChannelDetails(channelId: String, callBack: ApiClientMoviesCallBack) {
        service.getChannelDetails(context.getString(R.string.key), AppConstants.PART, channelId, AppConstants.ORDER, 20)
            .enqueue(object : Callback<ChannelResponse> {
                override fun onResponse(call: Call<ChannelResponse>?, response: Response<ChannelResponse>?) {

                    if (response != null && response.isSuccessful && response.code() == 200) {
                        val gsonString = Gson().toJson(response)
                        Log.e("response", gsonString)
                        callBack.onSuccess(response.body())
                    } else {
                        Log.e("errResponse", "Error")
                        callBack.onError("errResponse")
                    }
                }

                override fun onFailure(call: Call<ChannelResponse>?, t: Throwable?) {
                    Log.e("errResponse", t.toString())
                    callBack.onError(t.toString())
                }
            })
    }

    public interface ApiClientMoviesCallBack {
        fun onSuccess(channelResponse: ChannelResponse)
        fun onError(errMsg: String)
    }
}
