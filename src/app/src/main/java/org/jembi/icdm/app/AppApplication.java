package org.jembi.icdm.app;

import android.util.Log;

import com.activeandroid.ActiveAndroid;

import org.jembi.icdm.R;
import org.jembi.icdm.api.ApiService;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Clive on 21 Mar 2016.
 */
public class AppApplication extends com.activeandroid.app.Application {

    private ApiService mDhis2Service;

    @Override
    public void onCreate() {
        super.onCreate();

        ActiveAndroid.initialize(this);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .authenticator(new Authenticator() {
                    @Override
                    public Request authenticate(Route route, Response response) throws IOException {
                        String credential = Credentials.basic("android", "Jembi#123");
                        Log.d("Basic auth", credential);
                        return response.request().newBuilder()
                                .header("Authorization", credential)
                                .build();
                    }
                })
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.him_url))
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        mDhis2Service = retrofit.create(ApiService.class);
    }

    public ApiService getDhis2ApiService() {
        return mDhis2Service;
    }
}
