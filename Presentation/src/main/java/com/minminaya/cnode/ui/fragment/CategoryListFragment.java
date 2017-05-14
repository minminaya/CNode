package com.minminaya.cnode.ui.fragment;


import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.minminaya.cnode.R;
import com.minminaya.cnode.adapter.CategoryAdapter;
import com.minminaya.cnode.base.BaseFragment;
import com.minminaya.cnode.mvp.view.MvpView;
import com.minminaya.data.http.NetWork;
import com.minminaya.data.model.TabModel;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Niwa on 2017/5/13.
 */

public class CategoryListFragment extends BaseFragment implements MvpView {


    @Bind(R.id.category_recycleView)
    RecyclerView mCategoryRecycleView;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;


    Observer<TabModel> observer = new Observer<TabModel>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(TabModel value) {
            Toast.makeText(getContext(), "数据加载成功", Toast.LENGTH_SHORT).show();

            Log.e("test", value.getData().get(1).getContent());
        }

        @Override
        public void onError(Throwable e) {
            Toast.makeText(getContext(), "数据加载失败", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onComplete() {

        }
    };

    private CategoryAdapter mAdapter = new CategoryAdapter();


    public static CategoryListFragment newInstance() {
        return new CategoryListFragment();
    }

    @Override
    protected void unBind() {

    }

    @Override
    public void setListeners() {
        NetWork.getCnodeApi()
                .loadTopicHomeItem(1,20,false)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void lazyLoad() {

    }

    @Override
    public void bind() {

    }

    @Override
    public void iniView(View view) {

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


}
