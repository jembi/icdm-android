package org.jembi.icdm.api.utils;

import org.jembi.icdm.api.model.ApiError;
import org.jembi.icdm.app.AppApplication;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Clive on 31 Mar 2016.
 */
public class ErrorUtils {
    public static ApiError parseError(Response<?> response, AppApplication appApplication) {
        Retrofit retrofit = appApplication.getRetrofit();

        Converter<ResponseBody, ApiError> converter =
                retrofit.responseBodyConverter(ApiError.class, new Annotation[0]);

        ApiError error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new ApiError();
        }

        return error;
    }
}
