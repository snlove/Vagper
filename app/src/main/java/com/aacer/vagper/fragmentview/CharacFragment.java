package com.aacer.vagper.fragmentview;


import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.aacer.vagper.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acer on 2016/1/6.
 */
public class CharacFragment extends  BaseFragment  {

    private ImageView first;
    private ImageView second;
    private ImageView thrid;
    private ImageView four;
    private View chracView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        chracView = inflater.inflate(R.layout.charc_layout, null);
        initView();
        startAnimaton();
        return chracView;
    }

    private void initView() {
        first = (ImageView) chracView.findViewById(R.id.charc_video);
        second = (ImageView) chracView.findViewById(R.id.chrac_right_icon);
        thrid = (ImageView) chracView.findViewById(R.id.charc_bottom_left);
        four = (ImageView) chracView.findViewById(R.id.charc_bottom_right);
    }

    @Override
    public void startAnimaton() {

    }

    @Override
    public void stopAnimation() {
    }
}
