package com.sumauto.diary.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sumauto.diary.R;
import com.sumauto.diary.adapter.BaseAdapter;

/**
 * Created by Lincoln on 2015/12/7.
 * 下拉刷新，滚动加载
 */
public class ListFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView.LayoutManager layoutManager;
    BaseAdapter<?, ?> adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeLayout);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        if (getActivity() instanceof Callback) {
            ((Callback) getActivity()).onListFragmentInit(recyclerView);
        }
    }

    public void setAdapter(BaseAdapter<?, ?> adapter) {
        this.adapter = adapter;
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    public interface Callback {
        void onListFragmentInit(RecyclerView recyclerView);
    }
}
