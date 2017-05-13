package com.minminaya.cnode.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.minminaya.cnode.C;
import com.minminaya.cnode.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Niwa on 2017/5/13.
 */

public class CategoryAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == C.TYPE_ITEM) {
            return new CategoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category_list, parent, false));
        } else {
            return new FooterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category_foot, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public int getItemViewType(int position) {
        if (position < 19) {
            // TODO: 2017/5/13 这里size要添加
            return C.TYPE_ITEM;
        } else {
            return C.TYPE_FOOT;
        }
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.category_rank_pic)
        RoundedImageView categoryRankPic;
        @Bind(R.id.user_pic)
        RoundedImageView userPic;
        @Bind(R.id.tv_item_title)
        TextView tvItemTitle;
        @Bind(R.id.text_item_user_title)
        TextView textItemUserTitle;
        @Bind(R.id.text_item_reply)
        TextView textItemReply;
        @Bind(R.id.text_item_total_click)
        TextView textItemTotalClick;
        @Bind(R.id.layout_mid)
        RelativeLayout layoutMid;
        @Bind(R.id.te_item_first_edit)
        TextView teItemFirstEdit;
        @Bind(R.id.text_item_last_reply)
        TextView textItemLastReply;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }

}
