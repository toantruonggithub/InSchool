package com.comvaca.inschool.dagger.component;

import com.comvaca.inschool.activity.BaseActivity;
import com.comvaca.inschool.dagger.module.InSchoolApiModule;
import com.comvaca.inschool.dagger.scope.UserScope;

import dagger.Component;

@UserScope
@Component(dependencies = NetComponent.class, modules = InSchoolApiModule.class)
public interface InSchoolApiComponent {

  void inject(BaseActivity activity);
}
