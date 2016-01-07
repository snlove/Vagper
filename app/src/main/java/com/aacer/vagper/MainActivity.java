package com.aacer.vagper;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.aacer.vagper.adapater.BaseFragmentAdapater;
import com.aacer.vagper.fragmentview.BaseFragment;
import com.aacer.vagper.fragmentview.CharacFragment;
import com.aacer.vagper.fragmentview.HabitFragmnet;
import com.aacer.vagper.fragmentview.IntroduceFragment;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private StartViewPager startViewPager;
    private List<BaseFragment> fragmentList;
    private BaseFragmentAdapater fragmentAdapater;
    private int currentIndex;
    private ImageView[] tips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mian);
        initView();
    }

    /**
     * 初始化视图
     */
    private void initView() {
        initPageIndex();
        initViewPager();
    }

    private void initPageIndex() {
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.viewGroup);
        tips = new ImageView[3];
        for (int i=0; i< tips.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(10,10));
            if(i == 0) {
                imageView.setImageResource(R.mipmap.page_indicator_focused);
            } else {
                imageView.setImageResource(R.mipmap.page_indicator_unfocused);
            }
            tips[i]  = imageView;

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            params.leftMargin = 30;
            params.rightMargin = 30;
            viewGroup.addView(imageView,params);
        }
    }

    private void initViewPager() {
        startViewPager = (StartViewPager) findViewById(R.id.main_viewPager);
        startViewPager.setBack(BitmapFactory.decodeResource(getResources(), R.mipmap.bg_kaka_launcher));

        fragmentList = new LinkedList<BaseFragment>();
        IntroduceFragment introduceFragment = new IntroduceFragment();
        CharacFragment characFragment = new CharacFragment();
        HabitFragmnet habitFragmnet = new HabitFragmnet();
        fragmentList.add(introduceFragment);
        fragmentList.add(characFragment);
        fragmentList.add(habitFragmnet);

        fragmentAdapater = new BaseFragmentAdapater(getSupportFragmentManager(),fragmentList);
        startViewPager.setAdapter(fragmentAdapater);
        startViewPager.setOffscreenPageLimit(2);
        startViewPager.setCurrentItem(0);
        startViewPager.addOnPageChangeListener(new MyPagerListener());
    }

    private class MyPagerListener implements ViewPager.OnPageChangeListener {


        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
                  setSelectItem(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    /**
     * 设置点的显示
     */

    private void setSelectItem(int postion) {

       for(int j=0;j< tips.length; j++) {
           if(j== postion) {
               tips[j].setImageResource(R.mipmap.page_indicator_focused);
           } else {
               tips[j].setImageResource(R.mipmap.page_indicator_unfocused);
           }
       }
    }

}
