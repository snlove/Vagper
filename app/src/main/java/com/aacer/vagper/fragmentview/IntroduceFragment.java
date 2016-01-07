package com.aacer.vagper.fragmentview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.widget.ImageView;

import com.aacer.vagper.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acer on 2016/1/6.
 */
public class IntroduceFragment extends  BaseFragment {

    private ImageView finger;
    private ImageView gold;
    private ImageView reward;
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
       rootView = inflater.inflate(R.layout.intro_layout,null);
        initView();

        return  rootView;
    }

    private void initView() {
        finger = (ImageView) rootView.findViewById(R.id.intro_finger);
        gold = (ImageView) rootView.findViewById(R.id.intro_gold);
        reward = (ImageView) rootView.findViewById(R.id.intro_reward);
    }

    @Override
    public void onResume() {
        startAnimaton();
        super.onResume();
    }

    @Override
    public void startAnimaton() {
        ValueAnimator fingerAnimaton = ObjectAnimator.ofFloat(finger,"y",150);
        ValueAnimator goldTras = ObjectAnimator.ofFloat(gold,"y",450);
        AnimatorSet bouncer = new AnimatorSet();
        bouncer.setDuration(1000);
        bouncer.play(fingerAnimaton).before(goldTras);
        bouncer.start();
        ValueAnimator rewardtransX = ObjectAnimator.ofFloat(reward,"scaleX",0.0f,1.0f);
        ValueAnimator rewardtransY = ObjectAnimator.ofFloat(reward,"scaleY",0.0f,1.0f);
        AnimatorSet rewardSet = new AnimatorSet();
        rewardSet.setDuration(300);
        rewardSet.play(rewardtransX).with(rewardtransY);
        rewardSet.setStartDelay(1000);
        rewardSet.start();
    }

    @Override
    public void stopAnimation() {

    }
}
