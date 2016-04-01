package com.comvaca.inschool.network.interfaces;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface InSchoolApiInterface {

  @GET("api/v1/app-info")
  Call<String> getAppInfo();

  @GET("about")
  Call<ResponseBody> getAppAbout();
}
