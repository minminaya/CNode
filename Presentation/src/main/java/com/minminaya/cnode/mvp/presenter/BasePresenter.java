package com.minminaya.cnode.mvp.presenter;

import com.minminaya.cnode.mvp.view.MvpView;

import io.reactivex.disposables.CompositeDisposable;

/** presenter base类
 * Created by Niwa on 2017/5/13.
 */

public class BasePresenter<T extends MvpView> {

    private T mvpView;
    public CompositeDisposable compositeDisposable;


    public void attachView(T view){
        this.mvpView = view;
        this.compositeDisposable = new CompositeDisposable();
    }
    public void detachView(){
        mvpView = null;
        compositeDisposable.isDisposed();
        compositeDisposable = null;

    }
    /**
     *  view是否连接
     *
     * */
    public boolean isViewAttach(){
        return mvpView != null;
    }

    public T getMvpView() {
        return mvpView;
    }
}


