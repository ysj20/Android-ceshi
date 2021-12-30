package com.xhsun.girlapp.presenter;

import com.xhsun.girlapp.beans.GirlBean;
import com.xhsun.girlapp.model.GirlModel;
import com.xhsun.girlapp.model.IBaseModel;
import com.xhsun.girlapp.view.IBaseView;

/**
 * @time: 2020/7/5
 * @author: xhsun
 * @description:
 */
public class LoadGirlPresenterImpl implements ILoadGirlPresenter, IBaseModel.LoadListener {

    private GirlModel model;

    private IBaseView baseView;

    public LoadGirlPresenterImpl(IBaseView baseView) {
        this.baseView = baseView;
        model = new GirlModel();
    }

    @Override
    public void loadGirl() {

        model.getData(this);
    }


    @Override
    public void loadSuccess(GirlBean bean) {
        baseView.success(bean);
    }

    @Override
    public void loadFailed(String e) {

        baseView.error(e);
    }
}
