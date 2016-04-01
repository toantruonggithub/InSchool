package com.comvaca.inschool.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.comvaca.inschool.App;
import com.comvaca.inschool.network.InSchoolApi;

import javax.inject.Inject;

import butterknife.ButterKnife;
import retrofit2.Retrofit;

public class BaseActivity extends AppCompatActivity {

  protected final Context context = this;

  @Inject
  SharedPreferences sharedPreferences;

  @Inject
  Retrofit retrofit;

  InSchoolApi inSchoolApi;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ((App) getApplication()).getInSchoolApiComponent().inject(this);
    inSchoolApi = new InSchoolApi(retrofit);
  }

  @Override
  public void setContentView(int layoutResID) {
    super.setContentView(layoutResID);
    ButterKnife.bind(this);
  }
}
