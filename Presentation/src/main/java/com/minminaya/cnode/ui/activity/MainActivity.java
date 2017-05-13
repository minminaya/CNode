package com.minminaya.cnode.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.minminaya.cnode.R;
import com.minminaya.cnode.adapter.ViewPagerAdapter;
import com.minminaya.cnode.base.BaseActivity;
import com.minminaya.cnode.ui.fragment.CategoryListFragment;



public class MainActivity extends BaseActivity {
//    @BindView(R.id.content_ViewPager)
    ViewPager mContentViewPager;
//    @BindView(R.id.bottomNavigationView)
    BottomNavigationView mBottomNavigationView;

    @Override
    public void unBind() {

    }

    @Override
    public void bind() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(CategoryListFragment.newInstance());
        viewPagerAdapter.addFragment(CategoryListFragment.newInstance());
        viewPagerAdapter.addFragment(CategoryListFragment.newInstance());
        viewPagerAdapter.addFragment(CategoryListFragment.newInstance());
        mContentViewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public void setListeners() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.item_tab_star:
                        mContentViewPager.setCurrentItem(0);
                    break;
                    case R.id.item_tab_share:
                        mContentViewPager.setCurrentItem(1);
                        break;
                    case R.id.item_tab_question:
                        mContentViewPager.setCurrentItem(2);
                        break;
                    case R.id.item_tab_offer:
                        mContentViewPager.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        mContentViewPager = (ViewPager) findViewById(R.id.content_ViewPager);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }
}
