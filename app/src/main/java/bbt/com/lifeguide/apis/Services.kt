package bbt.com.lifeguide.apis

import bbt.com.lifeguide.helper.AppConstants
import bbt.com.lifeguide.models.ChannelResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

public interface Services {
    @GET(AppConstants.GET_CHANNEL)
    fun getChannelDetails(
        @Query("key") key: String, @Query("part") part: String, @Query("channelId") channelId: String,
        @Query("order") order: String, @Query("maxResults") maxResults: Int
    ): Call<ChannelResponse>

}