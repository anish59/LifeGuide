package bbt.com.lifeguide.helper

import android.app.Application
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import java.util.concurrent.TimeUnit

/**
 * Created by anish on 29-08-2017.
 */

class AppApplicationDummy : Application() {
    override fun onCreate() {
        super.onCreate()
        app = this
        initRetroFit()
    }

    private fun initRetroFit() {

        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()

        retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    companion object {
        var retrofit: Retrofit? = null
            private set
        private var app: AppApplicationDummy? = null
    }
}