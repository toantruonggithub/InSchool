package com.comvaca.inschool.dagger.component;

import android.content.SharedPreferences;

import com.comvaca.inschool.dagger.module.AppModule;
import com.comvaca.inschool.dagger.module.NetModule;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {

  Retrofit retrofit();

  @Named("cached")
  OkHttpClient okHttpClient();

  SharedPreferences sharedPreferences();
}
