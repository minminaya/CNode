package com.minminaya.cnode.ui.activity;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;

import com.minminaya.cnode.R;
import com.minminaya.cnode.base.BaseActivity;

import butterknife.BindView;


public class MainActivity extends BaseActivity {
    @BindView(R.id.content_ViewPager)
    ViewPager mContentViewPager;
    @BindView(R.id.bottomNavigationView)
    BottomNavigationView mBottomNavigationView;

    @Override
    public void unBind() {

    }

    @Override
    public void bind() {

    }

    @Override
    public void setListeners() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }
}
