package com.minminaya.data.http;

import com.minminaya.data.api.CnodeApi;
import com.minminaya.data.api.Urls;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Niwa on 2017/5/14.
 */

public class NetWork {
    private static CnodeApi cnodeApi;
    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJava2CallAdapterFactory.create();

    public static CnodeApi getCnodeApi() {
        if(cnodeApi ==null){
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(Urls.BASE_URL)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            cnodeApi = retrofit.create(CnodeApi.class);
        }
        return cnodeApi;
    }
}
