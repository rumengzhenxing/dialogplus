package com.orhanobut.dialogplus;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.widget.BaseAdapter;

public interface HolderAdapter extends Holder {

    void setAdapter(BaseAdapter adapter, RecyclerView.Adapter recyclerAdapter);

    void setLayoutManager(@NonNull RecyclerView.LayoutManager layoutManager);

    void setOnItemClickListener(OnHolderListener listener);
}
