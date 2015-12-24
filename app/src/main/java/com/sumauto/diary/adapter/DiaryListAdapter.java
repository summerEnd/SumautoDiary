package com.sumauto.diary.adapter;

import android.content.Context;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sumauto.diary.R;
import com.sumauto.diary.databinding.ListItemDiaryBinding;
import com.sumauto.diary.db.DBManager;
import com.sumauto.diary.entity.Diary;


public class DiaryListAdapter extends CursorAdapter{
    public static final boolean DEFAULT = true;
    LayoutInflater inflater;
    DBManager dbManager;
    SparseBooleanArray status=new SparseBooleanArray();
    public DiaryListAdapter(Context context) {
        super(context);
        inflater=LayoutInflater.from(context);
        dbManager=new DBManager(context);
    }

    @Override
    protected Cursor onCreateCursor() {
        return new DBManager(context).queryAll(Diary.class.getSimpleName());
    }

    @Override
    public void bindView(RecyclerView.ViewHolder holder, Cursor cursor) {
        DiaryHolder diaryHolder= (DiaryHolder) holder;
        Diary diary=new Diary();
        dbManager.getObject(cursor, diary);
        ListItemDiaryBinding binding= DataBindingUtil.bind(diaryHolder.itemView);
        diaryHolder.iv_image.setVisibility(status.get(holder.getAdapterPosition(), DEFAULT)?View.GONE:View.VISIBLE);

        binding.setDiary(diary);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DiaryHolder(inflater.inflate(R.layout.list_item_diary,parent,false));
    }

    private class DiaryHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView iv_image;
        public DiaryHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            iv_image= (ImageView) itemView.findViewById(R.id.iv_image);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            boolean isImageVisible=status.get(position,DEFAULT);
            status.put(position, !isImageVisible);
            notifyItemChanged(position);
            RecyclerView parent = (RecyclerView) itemView.getParent();
            parent.scrollToPosition(position);
        }
    }
}
