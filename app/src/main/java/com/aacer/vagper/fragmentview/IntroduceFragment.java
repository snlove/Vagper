package com.aacer.vagper.fragmentview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.aacer.vagper.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acer on 2016/1/6.
 */
public class IntroduceFragment extends BaseFragment {

    private ImageView finger;
    private ImageView gold;
    private ImageView reward;
    private Bitmap ivgod;
    View rootView;
    private boolean start = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.intro_layout, null);
        initView();
        ivgod = BitmapFactory.decodeResource(getResources(), R.mipmap.icon_gold);
        return rootView;
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
        start = true;
        Animation fingerTrans = new TranslateAnimation(1.0f, 1.0f, finger.getY() - 100, finger.getY());
        fingerTrans.setDuration(1000);
        finger.setAnimation(fingerTrans);
        fingerTrans.start();
        fingerTrans.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                int height = ivgod.getHeight() * 2 + 80;
                if (start) {
                    Animation goldTrans = new TranslateAnimation(1.0f, 1.0f, 0, height);
                    goldTrans.setDuration(500);
                    goldTrans.setFillAfter(true);
                    gold.setAnimation(goldTrans);
                    goldTrans.start();
                    goldTrans.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            reward.setVisibility(View.VISIBLE);
                            final Animation rewardAnim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f,
                                    Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF,1.0f);
                            rewardAnim.setDuration(1000);
                            reward.setAnimation(rewardAnim);
                            rewardAnim.start();
                            rewardAnim.setAnimationListener(new Animation.AnimationListener() {
                                @Override
                                public void onAnimationStart(Animation animation) {

                                }

                                @Override
                                public void onAnimationEnd(Animation animation) {
                                    Animation alphaAnim = new AlphaAnimation(1.0f, 0.0f);
                                    alphaAnim.setDuration(300);
                                    reward.setAnimation(alphaAnim);
                                    alphaAnim.start();
                                    alphaAnim.setAnimationListener(new Animation.AnimationListener() {
                                        @Override
                                        public void onAnimationStart(Animation animation) {

                                        }

                                        @Override
                                        public void onAnimationEnd(Animation animation) {
                                                 reward.setVisibility(View.GONE);
                                        }

                                        @Override
                                        public void onAnimationRepeat(Animation animation) {

                                        }
                                    });
                                }

                                @Override
                                public void onAnimationRepeat(Animation animation) {

                                }
                            });
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });

                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    public void stopAnimation() {
          start = false;
          finger.clearAnimation();
    }
}
