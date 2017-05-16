package com.minminaya.cnode.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.minminaya.cnode.R;
import com.minminaya.cnode.adapter.ViewPagerAdapter;
import com.minminaya.cnode.base.BaseActivity;
import com.minminaya.cnode.ui.fragment.CategoryListFragment;
import com.minminaya.data.http.NetWork;
import com.minminaya.data.model.TabModel;

import java.util.List;

import butterknife.Bind;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends BaseActivity {
    @Bind(R.id.content_ViewPager)
    ViewPager mContentViewPager;
    @Bind(R.id.bottomNavigationView)
    BottomNavigationView mBottomNavigationView;


    @Override
    public void unBind() {

    }

    @Override
    public void bind() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(CategoryListFragment.newInstance("ask"));
        viewPagerAdapter.addFragment(CategoryListFragment.newInstance("share"));
        viewPagerAdapter.addFragment(CategoryListFragment.newInstance("job"));
        viewPagerAdapter.addFragment(CategoryListFragment.newInstance("good"));
        mContentViewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public void setListeners() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.item_tab_star:
                        mContentViewPager.setVisibility(View.VISIBLE);
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
