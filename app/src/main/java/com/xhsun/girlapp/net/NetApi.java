package com.xhsun.girlapp.net;

import com.xhsun.girlapp.common.Constants;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * @time: 2020/7/5
 * @author: xhsun
 * @description:
 */
public interface NetApi {

    @GET(Constants.GIRL_URL)
    Call<ResponseBody> getGirls();

}
