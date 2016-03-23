package org.jembi.icdm.app;

import com.activeandroid.ActiveAndroid;

import org.jembi.icdm.R;
import org.jembi.icdm.api.ApiService;

import retrofit2.Retrofit;

/**
 * Created by Clive on 21 Mar 2016.
 */
public class AppApplication extends com.activeandroid.app.Application {
    private ApiService mDhis2Service;

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.dhis2_url))
                        .build();

        mDhis2Service = retrofit.create(ApiService.class);
    }

    public ApiService getDhis2ApiService() {
        return mDhis2Service;
    }
}
