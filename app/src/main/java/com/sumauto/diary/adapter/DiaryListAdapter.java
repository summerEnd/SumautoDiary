package com.sumauto.diary.adapter;

import android.content.Context;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.sumauto.diary.R;
import com.sumauto.diary.adapter.base.CursorAdapter;
import com.sumauto.diary.databinding.ListItemDiaryBinding;
import com.sumauto.diary.data.db.DBManager;
import com.sumauto.diary.data.entity.Diary;

import java.io.File;


public class DiaryListAdapter extends CursorAdapter {
    public static final boolean DEFAULT = true;
    LayoutInflater inflater;
    DBManager dbManager;
    SparseBooleanArray status = new SparseBooleanArray();

    public DiaryListAdapter(Context context) {
        super(context);
        inflater = LayoutInflater.from(context);
        dbManager = new DBManager(context);
    }

    @Override
    protected Cursor onCreateCursor() {
        return new DBManager(context).query(Diary.class.getSimpleName());
    }

    @Override
    public void bindView(RecyclerView.ViewHolder holder, Cursor cursor) {
        DiaryHolder diaryHolder = (DiaryHolder) holder;
        Diary diary = new Diary();
        dbManager.get(cursor, diary);
        ListItemDiaryBinding binding = DataBindingUtil.bind(diaryHolder.itemView);
        int visibility;
        String images = diary.getImages();
        if (!TextUtils.isEmpty(images)&&!"null".equals(images)) {
            visibility = status.get(holder.getAdapterPosition(), DEFAULT) ? View.GONE : View.VISIBLE;
            diaryHolder.itemView.setOnClickListener(diaryHolder);
            ImageLoader.getInstance().displayImage(Uri.decode(Uri.fromFile(new File(images)).toString()),diaryHolder.iv_image);
        } else {
            visibility = View.GONE;
            diaryHolder.itemView.setOnClickListener(null);
        }
        diaryHolder.iv_image.setVisibility(visibility);
        binding.setDiary(diary);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DiaryHolder(inflater.inflate(R.layout.list_item_diary, parent, false));
    }

    private class DiaryHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView iv_image;

        public DiaryHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            iv_image = (ImageView) itemView.findViewById(R.id.iv_image);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            boolean isImageVisible = status.get(position, DEFAULT);
            status.put(position, !isImageVisible);

            notifyItemChanged(position);
            RecyclerView parent = (RecyclerView) itemView.getParent();
            parent.scrollToPosition(position);
        }
    }
}
