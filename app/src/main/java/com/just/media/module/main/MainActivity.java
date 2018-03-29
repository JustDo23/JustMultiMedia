package com.just.media.module.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.just.media.R;
import com.just.media.module.sensor.SensorActivity;

/**
 * [多媒体][学习][练习]
 *
 * @author JustDo23
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    findViewById(R.id.bt_orientation).setOnClickListener(this);
  }

  @Override
  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.bt_orientation:// 屏幕方向
        //startActivity(new Intent(this, ScreenOrientationActivity.class));
        startActivity(new Intent(this, SensorActivity.class));
        break;
    }
  }
}
