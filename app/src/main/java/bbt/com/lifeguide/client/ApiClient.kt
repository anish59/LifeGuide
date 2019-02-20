package bbt.com.lifeguide.client

import android.content.Context
import android.util.Log
import bbt.com.lifeguide.AppApplication
import bbt.com.lifeguide.apis.Services
import bbt.com.lifeguide.helper.AppConstants
import bbt.com.lifeguide.models.MovieResponse
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiClient(context: Context) {
    val service = AppApplication.retrofit!!.create(Services::class.java)
    fun getMovieList(callBack: ApiClientMoviesCallBack) {
        service.getMovies(AppConstants.MOVIE_KEY).enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>?, response: Response<MovieResponse>?) {

                if (response != null && response.isSuccessful && response.code() == 200) {
                    val gsonString = Gson().toJson(response)
                    Log.e("response", gsonString)
                    callBack.onSuccess(response.body())
                }else{
                    Log.e("errResponse", "Error")
                    callBack.onError("errResponse")
                }
            }

            override fun onFailure(call: Call<MovieResponse>?, t: Throwable?) {
                Log.e("errResponse", t.toString())
                callBack.onError(t.toString())
            }
        })
    }

    public interface ApiClientMoviesCallBack {
        fun onSuccess(movieResponse: MovieResponse)
        fun onError(errMsg: String)
    }
}
