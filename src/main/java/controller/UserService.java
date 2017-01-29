package controller;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import model.ChannelResult;
import model.UserResults;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by BAHA on 29/01/2017.
 */


public interface UserService {

    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody> loginUser(@Field("login") String login, @Field("password") String password);

    @FormUrlEncoded
    @POST("signup")
    Call<ResponseBody> signupUser(@Field("login") String login, @Field("password") String password);

    @GET("channels/")
    Call<ChannelResult> listChannels();

    @GET("channels/{channelId}/")
    Call<ChannelResult> listChannels(@Path("channelId") Integer channelId);

}