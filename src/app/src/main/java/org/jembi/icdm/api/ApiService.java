package org.jembi.icdm.api;

import org.jembi.icdm.api.model.IcdmLineItems;
import org.jembi.icdm.api.model.TrackedPatient;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by Clive on 23 Mar 2016.
 */
public interface ApiService {
    //http://107.170.125.158:8080/api/sqlViews/d0be6sHVvX2/data.json
    @GET("/dhis2-api/sqlViews/d0be6sHVvX2/data.json")
    Call<IcdmLineItems> getPatients();

    @POST("/dhis2-tracker")
    Call<TrackedPatient> savePatient(@Body TrackedPatient trackedPatient);
}
