package org.jembi.icdm.api;

import org.jembi.icdm.api.model.IcdmLineItems;

import retrofit2.http.GET;

/**
 * Created by Clive on 23 Mar 2016.
 */
public interface ApiService {
    //http://107.170.125.158:8080/api/sqlViews/d0be6sHVvX2/data.json
    @GET("/api/sqlViews/d0be6sHVvX2/data.json")
    public IcdmLineItems getPatients();
}
