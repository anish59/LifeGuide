package bbt.com.lifeguide

import android.app.Application
import bbt.com.lifeguide.helper.AppConstants
import com.facebook.drawee.backends.pipeline.Fresco
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class AppApplication : Application() {

    companion object { // todo doubt may be to access static value as its not in kotlin
        var retrofit: Retrofit? = null
            private set // todo doubt
        private var app: AppApplication? = null
    }

    override fun onCreate() {
        super.onCreate()
        initRetrofit()
        Fresco.initialize(this)

    }

    private fun initRetrofit() {


        val client = OkHttpClient().newBuilder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}