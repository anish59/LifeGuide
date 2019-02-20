package bbt.com.lifeguide.viewModel

import android.content.Context
import bbt.com.lifeguide.client.ApiClient
import bbt.com.lifeguide.models.MovieResponse

class MainActivityViewModel(
    private val context: Context,
    private val callBack: MainActivityViewModel.MainActivityViewModelCallBack
) {

    fun getData() {
        ApiClient(context).getMovieList(object : ApiClient.ApiClientMoviesCallBack {
            override fun onSuccess(movieResponse: MovieResponse) {
                callBack.onSuccess(movieResponse)
            }

            override fun onError(errMsg: String) {
                callBack.onError(errMsg)
            }
        })
    }


    public interface MainActivityViewModelCallBack {
        fun onSuccess(movieResponse: MovieResponse)
        fun onError(err: String)
    }
}