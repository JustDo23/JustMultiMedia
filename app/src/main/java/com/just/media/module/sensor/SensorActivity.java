package com.just.media.module.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.just.media.R;
import com.just.utils.log.LogUtils;

/**
 * 传感器初识
 *
 * @author JustDo23
 * @since 2018年03月29日
 */
public class SensorActivity extends AppCompatActivity implements SensorEventListener {

  private SensorManager sensorManager;// 传感器管理服务
  private Sensor sensor;// 传感器对象

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sensor);
    sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);// 传感器管理服务
    sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);// 获取指定的传感器对象
  }

  @Override
  protected void onResume() {
    super.onResume();
    sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
  }

  @Override
  protected void onPause() {
    super.onPause();
    sensorManager.unregisterListener(this);
  }

  @Override
  public void onAccuracyChanged(Sensor sensor, int accuracy) {

  }

  @Override
  public void onSensorChanged(SensorEvent event) {
    if (event.sensor == null) {
      return;
    }
    if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
      int x = (int) event.values[0];
      int y = (int) event.values[1];
      int z = (int) event.values[2];
      LogUtils.e("x = " + x + "\ny = " + y + "\nz = " + z);
    }
  }

}
