package com.comvaca.inschool.network;

import android.nfc.Tag;
import android.util.Log;

import com.comvaca.inschool.network.interfaces.InSchoolApiInterface;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class InSchoolApi {

  private final String LOG_TAG = "API";

  Retrofit mRetrofit;
  InSchoolApiInterface mInSchoolApiService;

  public interface ResponseHandler {
    void onResponse(Object data);
    void onFailure();
  }

  public InSchoolApi(Retrofit retrofit) {
    mRetrofit = retrofit;
    mInSchoolApiService = retrofit.create(InSchoolApiInterface.class);
  }

  public void getAbout(final ResponseHandler responseHandler) {
    Call<ResponseBody> call = mInSchoolApiService.getAppAbout();

    call.enqueue(new Callback<ResponseBody>() {
      @Override
      public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        if (response.isSuccessful()) {
          try {
            responseHandler.onResponse(response.body().string());
          } catch (IOException e) {
            e.printStackTrace();
          }
        } else {
          responseHandler.onFailure();
        }
      }

      @Override
      public void onFailure(Call<ResponseBody> call, Throwable t) {
        Log.d(LOG_TAG, t.getMessage());
      }
    });
  }
}
