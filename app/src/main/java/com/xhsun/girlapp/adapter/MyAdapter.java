package com.xhsun.girlapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.xhsun.girlapp.R;
import com.xhsun.girlapp.activity.GirlDetailActivity;
import com.xhsun.girlapp.beans.GirlBean;

import java.util.List;

/**
 * @time: 2020/7/5
 * @author: xhsun
 * @description:
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    private List<GirlBean.DataBean> dataBeanList;

    private Context context;
    private LayoutInflater inflater;

    private ItemClickListener itemClickListener;
    public MyAdapter(List<GirlBean.DataBean> dataBeanList, Context context,ItemClickListener listener) {
        this.dataBeanList = dataBeanList;
        this.context = context;
        this.itemClickListener = listener;

        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.img_item, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, int position) {

        GirlBean.DataBean dataBean = dataBeanList.get(position);

        holder.tvTitle.setText(dataBean.getAuthor());

        RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE).dontAnimate();

        Glide.with(context).load(dataBean.getUrl()).apply(options).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                holder.imgContent.setImageDrawable(resource);
            }
        });

        holder.imgContent.setOnClickListener(v -> itemClickListener.itemClick(position));


    }

    @Override
    public int getItemCount() {
        return dataBeanList.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {

        ImageView imgContent;
        TextView tvTitle;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            imgContent = itemView.findViewById(R.id.imgContent);
            tvTitle = itemView.findViewById(R.id.tvTitle);
        }
    }

    public interface ItemClickListener{
        void itemClick(int position);
    }
}
