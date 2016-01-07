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
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.habit_layout, null);
        first = (ImageView) rootView.findViewById(R.id.habit_button);
        startAnimaton();
        return rootView;
    }


    @Override
    public void startAnimaton() {
        ValueAnimator firetAnim = ObjectAnimator.ofFloat(first,"scale",0.0f,1.0f);
        firetAnim.setDuration(1000);
        first.setPivotX(first.getWidth());
        first.setPivotY(first.getHeight());
        first.invalidate();
        firetAnim.setInterpolator(new CycleInterpolator(2));
        AnimatorSet set = new AnimatorSet();
        set.play(firetAnim);
        set.start();
    }

    @Override
    public void stopAnimation() {

    }
}
