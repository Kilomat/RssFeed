package controller;

/**
 * Created by BAHA on 29/01/2017.
 */

import model.UserInfo;
import org.json.JSONObject;

import java.util.concurrent.TimeUnit;
import java.util.prefs.Preferences;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitFactory {
    private static final String TAG = "RetrofitFactory";
    private final static String BASE_URL = "https://javale.herokuapp.com/";
    private RetrofitService service;

    public RetrofitFactory() {
        // Init the HTTP client to make requests on the API
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();

        // Retrofit will help us to perform easier HTTP requests / responses
        // We use JacksonConverter to get JSON through API's responses
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        service = retrofit.create(RetrofitService.class);
    }

    // Attempt to login the user
    public void loginUser(UserInfo user) {
        Call<ResponseBody> call = service.loginUser(user.login, user.password);
        call.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                System.out.println(response.raw().toString());
                try {
                    JSONObject res = new JSONObject(response.body().string());
                    if (response.isSuccessful()) {
                        user.setToken(res.getString("token"));

                        // Retrieve the user preference node for the package
                        Preferences prefs = Preferences.userNodeForPackage(controller.RetrofitFactory.class);
                        // Preference key name
                        final String PREF_NAME = "token";
                        // Set the value of the preference
                        String newValue = user.getToken();
                        prefs.put(PREF_NAME, newValue);
                        LoginViewController.authenticateSuccess(res);
                    } else {
                        LoginViewController.authenticateError(res);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
               // Log.e(TAG, t.getMessage());
            }
        });
    }

    // Attempt to signup the guest
    public void signupUser(UserInfo user) {
        Call<ResponseBody> call = service.signupUser(user.login, user.password);
        call.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                //Log.d(TAG, response.raw().toString());
                try {
                    JSONObject res = new JSONObject(response.body().string());
                    if (response.isSuccessful()) {
                        System.out.println(res.toString());
                        user.setToken(res.getString("token"));

                        // Retrieve the user preference node for the package
                        Preferences prefs = Preferences.userNodeForPackage(controller.RetrofitFactory.class);
                        // Preference key name
                        final String PREF_NAME = "token";
                        // Set the value of the preference
                        String newValue = user.getToken();
                        prefs.put(PREF_NAME, newValue);

                        LoginViewController.authenticateSuccess(res);
                    } else {
                        LoginViewController.authenticateError(res);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                //Log.d(TAG, call.toString());
                //Log.e(TAG, t.getMessage());
            }
        });
    }
}