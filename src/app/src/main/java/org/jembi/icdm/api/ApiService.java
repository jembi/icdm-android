package org.jembi.icdm.api;

import org.jembi.icdm.api.model.IcdmLineItems;
import org.jembi.icdm.api.model.TrackedEntity;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


/**
 * Created by Clive on 23 Mar 2016.
 */
public interface ApiService {
    //http://107.170.125.158:8080/api/sqlViews/d0be6sHVvX2/data.json
    @GET("/dhis2-api/sqlViews/d0be6sHVvX2/data.json")
    Call<IcdmLineItems> getPatients();

    @POST("/dhis2-tracker")
    Call<ResponseBody> addTrackedEntity(@Body TrackedEntity trackedEntity);
}
