package com.aacer.vagper.fragmentview;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.CycleInterpolator;
import android.widget.ImageView;

import com.aacer.vagper.R;

/**
 * Created by acer on 2016/1/6.
 */
public class HabitFragmnet extends  BaseFragment {


   private ImageView first;
    private  boolean start = false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.habit_layout, null);
        first = (ImageView) rootView.findViewById(R.id.habit_button);
        startAnimaton();
        return rootView;
    }


    @Override
    public void startAnimaton() {
        start = true;
        ValueAnimator firstXAnim = ObjectAnimator.ofFloat(first,"scaleX",0.0f,1.0f);
        ValueAnimator firstYAnim = ObjectAnimator.ofFloat(first,"scaleY",0.0f,1.0f);
        first.setPivotX(first.getWidth()/2);
        first.setPivotY(first.getHeight()/2);
        first.invalidate();
        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.play(firstXAnim).with(firstYAnim);
        set.start();
    }

    @Override
    public void stopAnimation() {
       start = false;
        first.clearAnimation();
    }
}
