package com.aacer.vagper.fragmentview;


import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
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
    boolean start = false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        chracView = inflater.inflate(R.layout.charc_layout, null);
        initView();
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
        start = true;
        /**
         * 开启动画前将各个view隐藏
         */
        if (start) {
            first.setVisibility(View.GONE);
            second.setVisibility(View.GONE);
            thrid.setVisibility(View.GONE);
            four.setVisibility(View.GONE);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    showFirstAnim();
                }
            }, 500);
        }
    }

    @Override
    public void stopAnimation() {
        start = false;
        first.clearAnimation();
        second.clearAnimation();
        thrid.clearAnimation();
        four.clearAnimation();
    }

    /**
    *show first animmation
    *@date 2016/1/7
    *@time 16:13
    *@author sn
    */

    private void showFirstAnim() {
        first.setVisibility(View.VISIBLE);
        Animation scaleAnim = new ScaleAnimation(0.0f,1.0f,0.0f,1.0f,Animation.RELATIVE_TO_SELF,1.0f,Animation.RELATIVE_TO_SELF,1.0f
                );
        scaleAnim.setDuration(1000);
        scaleAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        first.startAnimation(scaleAnim);
        scaleAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                  showSecondAnim();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    /**
     * show second animation
     *
     * @date 2016/1/7
     * @time 16:48
     * @author sn
     */
    private void showSecondAnim() {
        second.setVisibility(View.VISIBLE);
        Animation secondAnim = new ScaleAnimation(0.0f,1.0f,0.0f,1.0f,Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,1.0f
        );
        secondAnim.setDuration(500);
        secondAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        second.startAnimation(secondAnim);
        secondAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                       showThridAnim();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void showThridAnim() {
        thrid.setVisibility(View.VISIBLE);
        Animation thridAnim = new ScaleAnimation(0.0f,1.0f,0.0f,1.0f,Animation.RELATIVE_TO_SELF,1.0f,Animation.RELATIVE_TO_SELF,1.0f
        );
        thridAnim.setDuration(500);
        thridAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        thrid.startAnimation(thridAnim);
        thridAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                     showFouthAnim();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void showFouthAnim() {
        four.setVisibility(View.VISIBLE);
        Animation fourAnim = new ScaleAnimation(0.0f,1.0f,0.0f,1.0f,Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,1.0f
        );
        fourAnim.setDuration(500);
        fourAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        four.startAnimation(fourAnim);
    }
}
