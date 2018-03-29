package com.just.media.module.orientation;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Surface;
import android.widget.EditText;
import android.widget.TextView;

import com.just.media.R;
import com.just.utils.log.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 屏幕方向
 *
 * @author JustDo23
 * @since 2018年03月28日
 */
public class ScreenOrientationActivity extends AppCompatActivity {

  @BindView(R.id.tv_orientation) TextView tv_orientation;
  @BindView(R.id.tv_bottom) TextView tv_bottom;
  @BindView(R.id.et_input) EditText et_input;

  private boolean isReal = false;

  private ScreenOrientationEventListener screenOrientationEventListener;// 屏幕角度监听类

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_screen_orientation);
    ButterKnife.bind(this);
    LogUtils.e("---> onCreate()");
    screenOrientationEventListener = new ScreenOrientationEventListener(this);// 实例化
  }

  @Override
  protected void onStart() {
    super.onStart();
    LogUtils.e("---> onStart()");
  }

  @Override
  protected void onResume() {
    super.onResume();
    LogUtils.e(String.valueOf(isReal));
    LogUtils.e("---> onResume()");
    isReal = true;
    screenOrientationEventListener.enable();// 开启监听
  }

  @Override
  protected void onPause() {
    super.onPause();
    LogUtils.e("---> onPause()");
    screenOrientationEventListener.disable();// 停止监听
  }

  @Override
  protected void onRestart() {
    super.onRestart();
    LogUtils.e("---> onRestart()");
  }

  @Override
  protected void onStop() {
    super.onStop();
    LogUtils.e("---> onStop()");
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    LogUtils.e("---> onDestroy()");
  }

  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    LogUtils.e("---> onConfigurationChanged()");
    switch (newConfig.orientation) {
      case Configuration.ORIENTATION_PORTRAIT:// 纵向
        break;
      case Configuration.ORIENTATION_LANDSCAPE:// 横向
        break;
    }
    switch (this.getWindowManager().getDefaultDisplay().getRotation()) {
      case Surface.ROTATION_0:
        break;
      case Surface.ROTATION_90:// 顺时针
        break;
      case Surface.ROTATION_180:
        break;
      case Surface.ROTATION_270:
        break;
    }
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    LogUtils.e("---> onSaveInstanceState()");
    outState.putBoolean("isReal", isReal);
  }

  @Override
  protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    LogUtils.e("---> onRestoreInstanceState()");
    isReal = savedInstanceState.getBoolean("isReal");
  }

}
