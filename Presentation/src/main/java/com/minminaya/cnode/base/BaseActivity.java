package com.minminaya.cnode.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.minminaya.cnode.utils.StatusBarUtils;

import butterknife.ButterKnife;

/**
 * Activity的base类
 * Created by Niwa on 2017/5/10.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        StatusBarUtils.initStatusBar(this);
        ButterKnife.bind(this);
        initView(savedInstanceState);
        setListeners();
        bind();
    }


    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unBind();
    }

    public abstract void unBind();

    /**
     * --次序3--
     * 绑定
     */
    public abstract void bind();

    /**
     * 设置监听器，在initView()之后
     * --次序2--
     */
    public abstract void setListeners();

    /**
     * --次序1--
     * 初始化view
     */
    public abstract void initView(Bundle savedInstanceState);

    /**
     * --次序0--
     * 返回layout的id
     */
    public abstract int getContentView();
}
