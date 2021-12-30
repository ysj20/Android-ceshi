package com.xhsun.girlapp.net;

import android.util.Log;

import com.google.gson.Gson;
import com.xhsun.girlapp.beans.GirlBean;
import com.xhsun.girlapp.common.Constants;
import com.xhsun.girlapp.model.IBaseModel;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * @time: 2020/7/5
 * @author: xhsun
 * @description: 网络请求封装类
 */
public class NetUtils {

    private static volatile NetUtils instance;

    private Retrofit retrofit;

    NetApi netApi;

    public NetUtils() {
        retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL).build();
        netApi = retrofit.create(NetApi.class);
    }

    public static NetUtils getInstance() {
        if (instance == null) {
            synchronized (NetUtils.class) {
                if (instance == null) {
                    instance = new NetUtils();
                }
            }
        }

        return instance;
    }

    public void LoadFromNet(final IBaseModel.LoadListener listener) {

        Call<ResponseBody> call = netApi.getGirls();

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                try {
                    String jsonStr = response.body().string();
                    GirlBean girlBean = new Gson().fromJson(jsonStr,GirlBean.class);

                    listener.loadSuccess(girlBean);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                Log.d("xhsun", "onFailure: 请求失败");

            }
        });
    }
}
