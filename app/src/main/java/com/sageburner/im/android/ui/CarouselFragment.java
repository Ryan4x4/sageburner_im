package com.sageburner.im.android.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sageburner.im.android.R;
import com.viewpagerindicator.TitlePageIndicator;

import butterknife.InjectView;
import butterknife.Views;

/**
 * Fragment which houses the View pager.
 */
public class CarouselFragment extends Fragment {

    @InjectView(R.id.tpi_header)
    protected TitlePageIndicator indicator;

    @InjectView(R.id.vp_pages)
    protected ViewPager pager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_carousel, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Views.inject(this, getView());

        BootstrapPagerAdapter bootstrapPagerAdapter = new BootstrapPagerAdapter(getResources(), getChildFragmentManager());

        bootstrapPagerAdapter.addFragment(new FriendsListFragment(), "friends");
//        bootstrapPagerAdapter.addFragment(new ConversationFragment());

        pager.setAdapter(bootstrapPagerAdapter);
        indicator.setViewPager(pager);
        pager.setCurrentItem(0);

    }
}