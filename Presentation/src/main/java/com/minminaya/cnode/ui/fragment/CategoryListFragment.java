package com.minminaya.cnode.ui.fragment;


import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.minminaya.cnode.R;
import com.minminaya.cnode.adapter.CategoryAdapter;
import com.minminaya.cnode.base.BaseFragment;
import com.minminaya.cnode.mvp.view.MvpView;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by Niwa on 2017/5/13.
 */

public class CategoryListFragment extends BaseFragment implements MvpView {


    @Bind(R.id.category_recycleView)
    RecyclerView mCategoryRecycleView;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;


    private CategoryAdapter mAdapter = new CategoryAdapter();


    public static CategoryListFragment newInstance() {
        return new CategoryListFragment();
    }

    @Override
    protected void unBind() {

    }

    @Override
    public void setListeners() {

    }

    @Override
    public void lazyLoad() {

    }

    @Override
    public void bind() {

    }

    @Override
    public void iniView(View view) {
//        mCategoryRecycleView = (RecyclerView) view.findViewById(R.id.category_recycleView);

        mCategoryRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        mCategoryRecycleView.setHasFixedSize(true);
        mCategoryRecycleView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        mCategoryRecycleView.setAdapter(mAdapter);
    }

    @Override
    public int setContView() {
        return R.layout.fragment_category_list;
    }

    @Override
    public void onFailed(Throwable e) {

    }


//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        ButterKnife.unbind(this);
//    }
}
