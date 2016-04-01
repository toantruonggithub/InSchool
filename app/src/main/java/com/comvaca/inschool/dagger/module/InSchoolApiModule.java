package com.comvaca.inschool.dagger.module;

import com.comvaca.inschool.dagger.scope.UserScope;
import com.comvaca.inschool.network.interfaces.InSchoolApiInterface;

import javax.inject.Singleton;

import dagger.Module;
import retrofit2.Retrofit;

@Module
public class InSchoolApiModule {

  @UserScope
  @Singleton
  InSchoolApiInterface providesInSchoolApiInterface(Retrofit retrofit) {
    return retrofit.create(InSchoolApiInterface.class);
  }
}
