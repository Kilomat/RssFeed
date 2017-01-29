package controller;

import model.ChannelInfo;
import model.ChannelResult;
import model.Feed;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by BAHA on 29/01/2017.
 */


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.List;

interface RetrofitService {
    // Users routes and endpoints
    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody> loginUser(@Field("login") String login, @Field("password") String password);

    @FormUrlEncoded
    @POST("signup")
    Call<ResponseBody> signupUser(@Field("login") String login, @Field("password") String password);

    // Channels routes and endpoints
    @GET("channels")
    Call<List<ChannelInfo>> getChannels(@Query("token") String token);

    @GET
    Call<List<Feed>> getChannel(@Url String url);
}