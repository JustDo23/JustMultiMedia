package com.just.media.module.orientation;

import android.content.Context;
import android.view.OrientationEventListener;

import com.just.utils.log.LogUtils;

/**
 * 屏幕方向各个角度监听
 *
 * @author JustDo23
 * @since 2018年03月29日
 */
public class ScreenOrientationEventListener extends OrientationEventListener {

  public ScreenOrientationEventListener(Context context) {
    super(context);
  }

  @Override
  public void onOrientationChanged(int orientation) {
    LogUtils.e("---> onOrientationChanged() : " + orientation);// 顺时针方向
  }

}
