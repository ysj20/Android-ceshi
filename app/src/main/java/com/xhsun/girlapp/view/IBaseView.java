package com.xhsun.girlapp.view;

import com.xhsun.girlapp.beans.GirlBean;

/**
 * @time: 2020/7/5
 * @author: xhsun
 * @description:
 */
public interface IBaseView {

    void showToast(String data);

    void showLoading();

    void hideLoading();

    void notifyView();

    void success(GirlBean bean);

    void failure();

    void error(String e);


}
