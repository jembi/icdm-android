package org.jembi.icdm.app;

import android.util.Log;

import com.activeandroid.ActiveAndroid;
import com.squareup.okhttp.Authenticator;
import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.jembi.icdm.R;
import org.jembi.icdm.api.ApiService;

import java.io.IOException;
import java.net.Proxy;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Clive on 21 Mar 2016.
 */
public class AppApplication extends com.activeandroid.app.Application {

    private ApiService mDhis2Service;

    @Override
    public void onCreate() {
        super.onCreate();

        ActiveAndroid.initialize(this);

        OkHttpClient client = new OkHttpClient();

        client.setAuthenticator(new Authenticator() {
            @Override
            public Request authenticate(Proxy proxy, Response response) throws IOException {
                String credential = Credentials.basic("android", "Jembi#123");
                Log.d("Basic auth", credential);
                return response.request().newBuilder()
                        .header("Authorization", credential)
                        .build();
            }

            @Override
            public Request authenticateProxy(Proxy proxy, Response response) throws IOException {
                return null;
            }
        });

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
