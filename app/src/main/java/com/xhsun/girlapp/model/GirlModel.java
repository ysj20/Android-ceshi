package com.xhsun.girlapp.model;

import com.xhsun.girlapp.net.NetUtils;

/**
 * @time: 2020/7/5
 * @author: xhsun
 * @description:
 */
public class GirlModel implements IBaseModel{

    @Override
    public void getData(LoadListener listener) {


        NetUtils.getInstance().LoadFromNet(listener);

    }
}
