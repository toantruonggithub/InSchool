package com.comvaca.inschool;

import android.app.Application;

import com.comvaca.inschool.dagger.component.DaggerInSchoolApiComponent;
import com.comvaca.inschool.dagger.component.DaggerNetComponent;
import com.comvaca.inschool.dagger.component.InSchoolApiComponent;
import com.comvaca.inschool.dagger.component.NetComponent;
import com.comvaca.inschool.dagger.module.AppModule;
import com.comvaca.inschool.dagger.module.InSchoolApiModule;
import com.comvaca.inschool.dagger.module.NetModule;
import com.comvaca.inschool.utils.Configuration;

public class App extends Application {

  NetComponent netComponent;
  InSchoolApiComponent inSchoolApiComponent;

  @Override
  public void onCreate() {
    super.onCreate();

    netComponent = DaggerNetComponent.builder().netModule(new NetModule(Configuration.API_BASE_URL)).appModule(new AppModule(this)).build();
    inSchoolApiComponent = DaggerInSchoolApiComponent.builder().netComponent(netComponent).inSchoolApiModule(new InSchoolApiModule()).build();
  }

  public NetComponent getNetComponent() {
    return netComponent;
  }

  public InSchoolApiComponent getInSchoolApiComponent() {
    return inSchoolApiComponent;
  }
}
