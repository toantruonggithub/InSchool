package com.comvaca.inschool.activity;

import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;
import android.widget.Toast;

import com.comvaca.inschool.R;
import com.comvaca.inschool.network.InSchoolApi;

import butterknife.Bind;

public class MainActivity extends BaseActivity {

  @Bind(R.id.tv_main_content)
  TextView tvMainContent;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    inSchoolApi.getAbout(new InSchoolApi.ResponseHandler() {
      @Override
      public void onResponse(Object data) {
        tvMainContent.setText(Html.fromHtml(data + ""));
      }

      @Override
      public void onFailure() {
        tvMainContent.setText("Request failed!");
      }
    });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.main, menu);
    return true;
  }
}
