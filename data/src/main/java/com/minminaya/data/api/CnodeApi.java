package com.minminaya.data.api;

import com.minminaya.data.model.TabModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Niwa on 2017/5/14.
 */

public interface CnodeApi {

    /**
     *
     *  获取首页文章列表
     *
     * @param pageIndex Number 页数
     * @param limit Number 每一页的主题数量
     * @param mdrender String 当为 false 时，不渲染。默认为 true，渲染出现的所有 markdown 格式文本。
     * */
    @GET("topics")
    Observable<TabModel> loadTopicHomeItem(@Query("page") Integer pageIndex, @Query("limit") Integer limit, @Query("mdrender") Boolean mdrender);
}
