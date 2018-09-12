package com.orhanobut.dialogplus;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class RecyclerHolder implements HolderAdapter {

    private int backgroundResource;

    private RecyclerView listView;
    private View.OnKeyListener keyListener;
    private View headerView;
    private View footerView;
    private ViewGroup footerContainer;
    private ViewGroup headerContainer;

    @Override
    public void addHeader(@NonNull View view) {
        addHeader(view, true);
    }

    @Override
    public void addHeader(@NonNull View view, boolean fixed) {
        if (fixed) {
            headerContainer.addView(view);
        }
        headerView = view;
    }

    @Override
    public void addFooter(@NonNull View view) {
        addFooter(view, true);
    }

    @Override
    public void addFooter(@NonNull View view, boolean fixed) {
        if (fixed) {
            footerContainer.addView(view);
        }
        footerView = view;
    }


    @Override
    public void setAdapter(BaseAdapter adapter, RecyclerView.Adapter recyclerAdapter) {
        listView.setAdapter(recyclerAdapter);
    }

    @Override
    public void setLayoutManager(@NonNull RecyclerView.LayoutManager layoutManager){
        if (listView!=null){
            listView.setLayoutManager(layoutManager);
        }
    }

    @Override
    public void setBackgroundResource(int colorResource) {
        this.backgroundResource = colorResource;
    }

    @Override
    @NonNull
    public View getView(@NonNull LayoutInflater inflater, ViewGroup parent) {
        View view = inflater.inflate(R.layout.dialog_recycler, parent, false);
        View outMostView = view.findViewById(R.id.dialogplus_outmost_container);
        outMostView.setBackgroundResource(backgroundResource);
        listView = view.findViewById(R.id.dialogplus_list);
        listView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyListener == null) {
                    throw new NullPointerException("keyListener should not be null");
                }
                return keyListener.onKey(v, keyCode, event);
            }
        });
        headerContainer = view.findViewById(R.id.dialogplus_header_container);
        footerContainer = view.findViewById(R.id.dialogplus_footer_container);
        return view;
    }

    @Override
    public void setOnItemClickListener(OnHolderListener listener) {
    }

    @Override
    public void setOnKeyListener(View.OnKeyListener keyListener) {
        this.keyListener = keyListener;
    }

    @Override
    @NonNull
    public View getInflatedView() {
        return listView;
    }

    @Override
    public View getHeader() {
        return headerView;
    }

    @Override
    public View getFooter() {
        return footerView;
    }

}
