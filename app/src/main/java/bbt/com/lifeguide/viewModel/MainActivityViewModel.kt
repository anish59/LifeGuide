package bbt.com.lifeguide.viewModel

import android.content.Context
import bbt.com.lifeguide.client.ApiClient
import bbt.com.lifeguide.models.ChannelResponse

class MainActivityViewModel(
    private val context: Context,
    private val callBack: MainActivityViewModel.MainActivityViewModelCallBack
) {

    fun getData(channelId: String) {
        ApiClient(context).getChannelDetails(channelId, object : ApiClient.ApiClientMoviesCallBack {
            override fun onSuccess(channelResponse: ChannelResponse) {
                callBack.onSuccess(channelResponse)
            }

            override fun onError(errMsg: String) {
                callBack.onError(errMsg)
            }
        })
    }


    public interface MainActivityViewModelCallBack {
        fun onSuccess(channelResponse: ChannelResponse)
        fun onError(err: String)
    }
}