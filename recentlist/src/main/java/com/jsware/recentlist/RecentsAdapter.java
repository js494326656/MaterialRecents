package com.jsware.recentlist;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin on 2015-04-13.
 */
public abstract class RecentsAdapter<T extends Object> {
    List<T> data = new ArrayList<>();

    public abstract View bindHolder(int position, T item);
    public final int getCount(){
        return data.size();
    }
    public T getItem(int position) {
        return data.get(position);
    }

    public RecentsAdapter(List<T> data){
        this.data = data;
    }
}
