package bbt.com.lifeguide

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import bbt.com.lifeguide.models.MovieResponse
import bbt.com.lifeguide.viewModel.MainActivityViewModel

class MainActivity(
    private var viewModel: MainActivityViewModel
) : AppCompatActivity(), MainActivityViewModel.MainActivityViewModelCallBack {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        viewModel = MainActivityViewModel(this, this)
        viewModel.getData()
    }

    override fun onSuccess(movieResponse: MovieResponse) {

    }

    override fun onError(err: String) {

    }

}


