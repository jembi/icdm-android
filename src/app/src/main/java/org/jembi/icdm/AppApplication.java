package org.jembi.icdm;

import com.activeandroid.ActiveAndroid;

/**
 * Created by Clive on 21 Mar 2016.
 */
public class AppApplication extends com.activeandroid.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
