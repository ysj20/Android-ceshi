package com.xhsun.girlapp.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.xhsun.girlapp.InjectUtils;
import com.xhsun.girlapp.view.IBaseView;

/**
 * @time: 2020/7/5
 * @author: xhsun
 * @description:
 */
public abstract class BaseActivity extends AppCompatActivity implements IBaseView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getContentView());

        InjectUtils.injectView(this);

        initView();

        initData();
    }

    abstract void initView();

    abstract void initData();

    abstract int getContentView();
}
