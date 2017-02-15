package com.hankkin.library;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangwei on 2016/8/15.
 */
public class LoginRecommendTouGuAdapter extends RecyclerView.Adapter<LoginRecommendTouGuAdapter.MyViewHolder> {
    private Context mContext;

    private List<PopBean> dataList;
    private LayoutInflater mLayoutInflater;
    private boolean isShowImg = false;

    public LoginRecommendTouGuAdapter(Context context, List<PopBean> dataList, boolean isShowImg) {
        this.mContext = context;
        this.dataList = dataList;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.isShowImg = isShowImg;
    }


    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = mLayoutInflater.inflate(R.layout.listview_popwindow_item, null);
        MyViewHolder masterViewHolder = new MyViewHolder(inflate);
        return masterViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.tv_name.setText(dataList.get(position).getTitle());

        // 如果设置了回调，则设置点击事件
        if (mOnItemClickLitener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });
        }


    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private View itemView;
        public TextView tv_name;
        public View v_line;


        public MyViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tv_name = (TextView) itemView.findViewById(R.id.tv_title);
            v_line = (View) itemView.findViewById(R.id.v_line);

        }


    }


}
