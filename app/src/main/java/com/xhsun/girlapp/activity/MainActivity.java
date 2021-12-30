package com.xhsun.girlapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.xhsun.girlapp.R;
import com.xhsun.girlapp.adapter.MyAdapter;
import com.xhsun.girlapp.annotation.InjectView;
import com.xhsun.girlapp.beans.GirlBean;
import com.xhsun.girlapp.presenter.LoadGirlPresenterImpl;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity implements View.OnClickListener, MyAdapter.ItemClickListener {

    @InjectView(R.id.rvContent)
    private RecyclerView recyclerView;

    @InjectView(R.id.btnLoadImg)
    private Button btnLoadImg;

    @InjectView(R.id.tvLoad)
    private TextView tvLoad;

    private LoadGirlPresenterImpl presenter;

    private List<GirlBean.DataBean> girlList;

    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    void initView() {
        btnLoadImg.setOnClickListener(this);
    }

    @Override
    void initData() {
        presenter = new LoadGirlPresenterImpl(this);
        girlList = new ArrayList<>();
        adapter = new MyAdapter(girlList, this, this);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        recyclerView.setAdapter(adapter);
    }

    @Override
    int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void showToast(String data) {

        Toast.makeText(this, "请求失败：" + data, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {

        if (!tvLoad.isShown())
            tvLoad.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {

        if (tvLoad.isShown())
            tvLoad.setVisibility(View.GONE);
    }

    @Override
    public void notifyView() {

        runOnUiThread(() -> adapter.notifyDataSetChanged());
    }

    @Override
    public void onClick(View v) {

        showLoading();
        presenter.loadGirl();
    }

    @Override
    public void success(GirlBean bean) {
        hideLoading();

        girlList.clear();
        girlList.addAll(bean.getData());


    }

    @Override
    public void failure() {

        hideLoading();
    }

    @Override
    public void error(String e) {

        hideLoading();
        showToast(e);
    }

    @Override
    public void itemClick(int position) {
        GirlBean.DataBean girlBean = girlList.get(position);
        Intent intent = new Intent();
        intent.setClass(this, GirlDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("girl", girlBean);
        intent.putExtras(bundle);

        startActivity(intent);
    }
}