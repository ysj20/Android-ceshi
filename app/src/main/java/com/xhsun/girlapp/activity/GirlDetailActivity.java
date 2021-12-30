package com.xhsun.girlapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xhsun.girlapp.R;
import com.xhsun.girlapp.annotation.InjectView;
import com.xhsun.girlapp.beans.GirlBean;

public class GirlDetailActivity extends BaseActivity {


    @InjectView(R.id.imgGirlContent)
    private ImageView imgGirlContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    void initView() {


    }

    @Override
    void initData() {

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        GirlBean.DataBean dataBean = bundle.getParcelable("girl");

        String url  = dataBean.getUrl();

        Glide.with(this).load(url).into(imgGirlContent);
    }

    @Override
    int getContentView() {
        return R.layout.activity_girl_detail;
    }

    @Override
    public void showToast(String data) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void notifyView() {

    }

    @Override
    public void success(GirlBean bean) {

    }

    @Override
    public void failure() {

    }

    @Override
    public void error(String e) {

    }
}