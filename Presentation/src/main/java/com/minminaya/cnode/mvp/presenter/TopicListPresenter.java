package com.minminaya.cnode.mvp.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.minminaya.cnode.mvp.view.MvpView;
import com.minminaya.cnode.ui.fragment.CategoryListFragment;
import com.minminaya.data.http.NetWork;
import com.minminaya.data.model.TabModel;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Niwa on 2017/5/15.
 */

public class TopicListPresenter extends BasePresenter<CategoryListFragment> implements MvpView {

    private static final int PAGE_LIMIT = 50;
    private int mPageIndex = 1;
    private String mTab;
    private boolean mHasNextPage = true;
    private boolean mLoading = false;
    private Context context;
    private Boolean isRefresh;

    public TopicListPresenter(Context context) {
        this.context = context;
    }

    Observer<TabModel> observer = new Observer<TabModel>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(TabModel tabModel) {
            mPageIndex++;
            mHasNextPage = tabModel.getData().size() >= PAGE_LIMIT;
            if (tabModel.isSuccess()) {
                getMvpView().notifySucess(tabModel, isRefresh);
            }else{
                getMvpView().onFailed(new Throwable("获取列表失败了"));
            }

//            Toast.makeText(context, "数据加载onNext()", Toast.LENGTH_SHORT).show();
            Log.e("test", tabModel.getData().get(1).getContent());
        }

        @Override
        public void onError(Throwable e) {
            getMvpView().onFailed(e);
            Toast.makeText(context, "数据加载失败", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onComplete() {

        }
    };

    public void refresh() {
        mPageIndex = 1;
        getHomePage(mPageIndex, true);
    }

    public void loadNextPage(){
        getHomePage(mPageIndex, false);
    }

    private void getHomePage(int pageIndex, boolean refresh) {
        if (mLoading) {
            return;
        }
        mLoading = true;
        isRefresh = refresh;
        getObserveble(pageIndex)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * 根据是否有tab值确定加载哪个数据
     *
     * @param pageIndex 页index
     * @return 返回Observable<TabModel>
     */
    private Observable<TabModel> getObserveble(int pageIndex) {
        if (mTab == null) {
            return NetWork.getCnodeApi().loadTopicForHomeItem(pageIndex, PAGE_LIMIT, false);
        } else {
            return NetWork.getCnodeApi().loadTopicFromTabByNameItem(mTab, pageIndex, PAGE_LIMIT, false);
        }
    }


    public int getmPageIndex() {
        return mPageIndex;
    }

    public void setmPageIndex(int mPageIndex) {
        this.mPageIndex = mPageIndex;
    }

    public String getmTab() {
        return mTab;
    }

    public void setmTab(String mTab) {
        this.mTab = mTab;
    }

    public boolean ismHasNextPage() {
        return mHasNextPage;
    }

    public void setmHasNextPage(boolean mHasNextPage) {
        this.mHasNextPage = mHasNextPage;
    }

    public boolean ismLoading() {
        return mLoading;
    }

    public void setmLoading(boolean mLoading) {
        this.mLoading = mLoading;
    }

    @Override
    public void onFailed(Throwable e) {

    }
}
