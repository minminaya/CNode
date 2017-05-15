package com.minminaya.cnode.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.minminaya.cnode.R;
import com.minminaya.cnode.adapter.CategoryAdapter;
import com.minminaya.cnode.base.BaseFragment;
import com.minminaya.cnode.mvp.presenter.TopicListPresenter;
import com.minminaya.cnode.mvp.view.MvpView;
import com.minminaya.data.http.NetWork;
import com.minminaya.data.model.TabModel;
import com.minminaya.library.utils.DipConvertUtils;


import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
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
    private String mTab;
    private List<TabModel> tabModelList = new ArrayList<>();
    private TopicListPresenter mPresenter = new TopicListPresenter(getContext());


    /*Observer<TabModel> observer = new Observer<TabModel>() {
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
    };*/

    private CategoryAdapter mAdapter = new CategoryAdapter();


    public static CategoryListFragment newInstance(String tab) {
        CategoryListFragment fragment = new CategoryListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("tab", tab);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //保持Fragment状态
        setRetainInstance(true);
        if (getArguments() != null) {
            mTab = getArguments().getString("tab");
        }


    }

    @Override
    protected void unBind() {
        mPresenter.detachView();
    }

    @Override
    public void setListeners() {
//        NetWork.getCnodeApi()
//                .loadTopicHomeItem(1,20,false)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);

        //入口
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.refresh();
            }
        });
    }

    @Override
    public void lazyLoad() {
        if(tabModelList.size() == 0){
            mPresenter.refresh();
        }
    }

    @Override
    public void bind() {
        mPresenter.attachView(this);
        mPresenter.setmTab(mTab);
    }

    @Override
    public void iniView(View view) {

        mCategoryRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        mCategoryRecycleView.setHasFixedSize(true);
        mCategoryRecycleView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        mCategoryRecycleView.setAdapter(mAdapter);
        //整体向下偏移
        swipeRefreshLayout.setProgressViewOffset(true, 0, DipConvertUtils.dip2px(getContext(), 80));
    }


    public void notifySucess(TabModel tabModel, boolean isRefresh) {
        swipeRefreshLayout.setRefreshing(false);
        if (isRefresh) {
            tabModelList.clear();
        }
        tabModelList.add(tabModel);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public int setContView() {
        return R.layout.fragment_category_list;
    }

    @Override
    public void onFailed(Throwable e) {
        Toast.makeText(getContext(), "加载错误了亲", Toast.LENGTH_SHORT).show();
        swipeRefreshLayout.setRefreshing(false);
    }


}
