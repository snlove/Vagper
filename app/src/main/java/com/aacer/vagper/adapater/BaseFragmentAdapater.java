package com.aacer.vagper.adapater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.aacer.vagper.fragmentview.BaseFragment;

import java.util.List;

/**
 * Created by acer on 2016/1/6.
 */
public class BaseFragmentAdapater extends FragmentPagerAdapter {

    private List<BaseFragment>  fragmentList;

    public BaseFragmentAdapater(FragmentManager fm, List<BaseFragment>  fragmentList) {
        this(fm);
        this.fragmentList = fragmentList;
    }

    public BaseFragmentAdapater(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }


    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
