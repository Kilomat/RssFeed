/**
 * Created by BAHA on 29/01/2017.
 */
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import model.ChannelResult;
import model.UserResults;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by felip on 20/07/2016.
 */
public interface Service {
    final String BASE_URL = "";

    @POST("users/authenticate")
    Call<UserResults> loginUser(@Body BIConversion.User user);

    @POST("users/")
    Call<UserResults> signupUser(@Body BIConversion.User user);

    @GET("channels/")
    Call<ChannelResult> listChannels();

    @GET("channels/{channelId}/")
    Call<ChannelResult> listChannels(@Path("channelId") Integer channelId);
}