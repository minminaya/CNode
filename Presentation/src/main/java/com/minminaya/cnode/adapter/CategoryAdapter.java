package com.minminaya.cnode.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.minminaya.cnode.C;
import com.minminaya.cnode.R;
import com.minminaya.cnode.utils.FormatTimeUtils;
import com.minminaya.data.model.TabModel;
import com.minminaya.data.model.entity.DataBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Niwa on 2017/5/13.
 */

public class CategoryAdapter extends RecyclerView.Adapter {


    private List<DataBean> tabModelList = new ArrayList<>();

    public List<DataBean> getTabModelList() {
        return tabModelList;
    }

    public void setTabModelList(List<DataBean> tabModelList) {
        this.tabModelList = tabModelList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == C.TYPE_ITEM) {
            return new CategoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category_list, parent, false));
        } else if (viewType == C.TYPE_TOP) {
            return new TopViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category_top, parent, false));
        } else {
            return new FooterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category_foot, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        if (holder instanceof CategoryViewHolder) {
            CategoryViewHolder categoryViewHolder = (CategoryViewHolder) holder;
            DataBean dataBean = tabModelList.get(position);
            categoryViewHolder.tvItemTitle.setText(dataBean.getTitle());
            //用户名
            categoryViewHolder.textItemUserTitle.setText(dataBean.getAuthor().getLoginname());
            //用户头像
            Glide.with(categoryViewHolder.itemView.getContext()).load(dataBean.getAuthor().getAvatar_url()).into(categoryViewHolder.userPic);
            //总点击数量
            categoryViewHolder.textItemTotalClick.setText(String.valueOf(dataBean.getVisit_count()));
            //回复数量
            categoryViewHolder.textItemReply.setText(String.valueOf(dataBean.getReply_count()));

            //创建的时间
            categoryViewHolder.teItemFirstEdit.setText(FormatTimeUtils.convertTime(dataBean.getCreate_at()));
        }


    }

    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return C.TYPE_TOP;
        }
        if (position < 20) {
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
//            textItemReply = (TextView) itemView.findViewById(R.id.text_item_reply);
//            tvItemTitle = (TextView) itemView.findViewById(R.id.tv_item_title);
        }
    }

    public class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class TopViewHolder extends RecyclerView.ViewHolder {

        public TopViewHolder(View itemView) {
            super(itemView);
        }
    }

}
