package org.hand.mas.android_common.utl;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gonglixuan on 15/6/1.
 */
public class ViewHolder {
    private final SparseArray<View> mViews;
    private View mConvertView;

    public ViewHolder(Context context, ViewGroup parent,int layoutId, int position) {
        this.mViews = new SparseArray<View>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId,parent,false);
        mConvertView.setTag(this);
    }

    public static  ViewHolder get(Context context,View convertView, ViewGroup parent,int layoutId,int position){
        if(convertView == null){
            return new ViewHolder(context,parent,layoutId,position);
        }
        return (ViewHolder) convertView.getTag();
    }

    public <T extends View>T getView(int viewId){
        View view = mViews.get(viewId);
        if (view == null){
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return (T) view;
    }

    public View getConvertView() {
        return mConvertView;
    }
}


