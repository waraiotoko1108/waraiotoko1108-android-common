package org.hand.mas.android_common.utl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by gonglixuan on 15/6/1.
 */
public abstract class CommonAdapter<T> extends BaseAdapter {

    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<T> mList;
    private int mItemLayoutId;

    public CommonAdapter(Context context, List<T> list, int itemLayoutId) {
        this.mContext = context;
        this.mList = list;
        this.mItemLayoutId = itemLayoutId;
        this.mLayoutInflater = LayoutInflater.from(this.mContext);
    }

    @Override
    public int getCount() {
        return this.mList.size();
    }

    @Override
    public T getItem(int position) {
        return this.mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder = getViewHolder(position,convertView,parent);
        convert(viewHolder,getItem(position),position);
        return viewHolder.getConvertView();
    }

    public abstract void convert(ViewHolder helper,T obj,int position);

    public ViewHolder getViewHolder(int position,View convertView,ViewGroup parent){
        return ViewHolder.get(mContext,convertView,parent,mItemLayoutId,position);
    }
}
