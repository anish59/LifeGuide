package bbt.com.lifeguide.apis

import bbt.com.lifeguide.helper.AppConstants
import bbt.com.lifeguide.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

public interface Services {
    @GET(AppConstants.TOP_RATED_MOVIES)
    fun getMovies(@Query("api_key") api_key: String): Call<MovieResponse>

}