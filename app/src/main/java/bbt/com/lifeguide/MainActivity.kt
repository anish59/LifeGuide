package bbt.com.lifeguide

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import bbt.com.lifeguide.models.ChannelResponse
import bbt.com.lifeguide.models.MovieResponse
import bbt.com.lifeguide.viewModel.MainActivityViewModel

class MainActivity : AppCompatActivity(), MainActivityViewModel.MainActivityViewModelCallBack {
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        viewModel = MainActivityViewModel(this, this)
        viewModel.getData("UCnrG75VRwdlp2wtwfpOCBRQ")
    }

    override fun onSuccess(channelResponse: ChannelResponse) {

    }


    override fun onError(err: String) {

    }

}


