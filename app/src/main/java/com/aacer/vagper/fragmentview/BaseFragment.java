package com.aacer.vagper.fragmentview;


import android.support.v4.app.Fragment;

/**显示页面的父类，控制动画
 * Created by acer on 2016/1/6.
 */
public abstract class BaseFragment extends Fragment {
     public  abstract  void startAnimaton();
     public abstract void stopAnimation();
}
