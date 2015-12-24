package com.sumauto.diary.adapter;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.sumauto.diary.R;

import java.util.List;

/**
 * Created by Lincoln on 2015/10/28.
 * 加载更多adapter
 */
public abstract class LoadMoreAdapter<ET> extends BaseAdapter<ET, BaseHolder<ET>> implements SwipeRefreshLayout.OnRefreshListener {
    private final int TYPE_LOAD_MORE = 0x12222;
    //是否有更多数据
    private boolean hasMoreData = true;
    private int currentPage = 0;
    private SwipeRefreshLayout swipeRefreshLayout;

    public LoadMoreAdapter(Context context, List<ET> data) {
        super(context, data);
    }

    @Override
    public final BaseHolder<ET> onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_LOAD_MORE) {
            return new LoadMoreHolder(parent);
        }
        return onCreateHolder(parent, viewType);
    }

    @Override
    public final int getItemCount() {
        return getCount() + 1;
    }

    @Override
    public final int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            return TYPE_LOAD_MORE;
        }
        return getViewType(position);
    }

    @Override
    public final void onBindViewHolder(BaseHolder<ET> holder, int position) {
        if (getCount() == position) {
            LoadMoreHolder loadMoreHolder = (LoadMoreHolder) holder;
            if (hasMoreData) {
                loadMoreHolder.progress.setVisibility(View.VISIBLE);
                loadMoreHolder.loadMoreText.setText(R.string.loading);
                onLoadMore();
            } else {
                loadMoreHolder.progress.setVisibility(View.GONE);
                if (getDataList().size() != 0) {
                    loadMoreHolder.loadMoreText.setText(R.string.noMore);
                } else {
                    loadMoreHolder.loadMoreText.setText(R.string.noData_refresh);
                }
            }
        } else {
            onBindHolder(holder, position);
        }
    }

    public void setHasMoreData(boolean hasMoreData) {
        this.hasMoreData = hasMoreData;
        try {
            notifyItemChanged(getItemCount() - 1);
        } catch (Exception ignore) {

        }
    }


    public void setSwipeRefreshLayout(SwipeRefreshLayout swipeRefreshLayout) {
        this.swipeRefreshLayout = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    public int getCount() {
        return getDataList().size();
    }

    public int getViewType(int position) {
        return 0;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void addPage(List<ET> newData) {

        if (newData != null && newData.size() > 0) {
            currentPage++;
            getDataList().addAll(newData);
            setHasMoreData(true);
            notifyDataSetChanged();
        } else {
            setHasMoreData(false);
        }
    }

    public abstract BaseHolder<ET> onCreateHolder(ViewGroup parent, int viewType);

    public abstract void onBindHolder(BaseHolder holder, int position);

    public abstract void onLoadMore();

    @Override
    public void onRefresh() {

    }

    public void setRefreshDone() {
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    private class LoadMoreHolder extends BaseHolder<ET> {
        View progress;
        TextView loadMoreText;

        public LoadMoreHolder(ViewGroup container) {
            super(container, R.layout.load_more_footer);
            progress = itemView.findViewById(R.id.loadMoreProgress);
            loadMoreText = (TextView) itemView.findViewById(R.id.loadMoreText);
        }
    }
}
