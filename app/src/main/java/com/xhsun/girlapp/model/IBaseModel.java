package com.xhsun.girlapp.model;

import com.xhsun.girlapp.beans.GirlBean;

import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * @time: 2020/7/5
 * @author: xhsun
 * @description:
 */
public interface IBaseModel {

    void getData(LoadListener loadListener);

    public interface LoadListener{
        void loadSuccess(GirlBean bean);

        void loadFailed(String e);
    }
}
