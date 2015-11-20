package com.sumauto.support.android.recyclerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;

import com.sumauto.support.utils.TextPainUtil;


/**
 * Created by user1 on 2015/7/13.
 * 当列表数据为空时展示提示文字
 */
public class EmptyTextDecoration extends RecyclerView.ItemDecoration
{

    private Context context;
    private CharSequence empty = null;
    private Paint        paint = new Paint();
    float offsetY = 0;

    public EmptyTextDecoration(Context context, String empty)
    {
        this.context = context;
        this.empty = empty;
        paint.setTextAlign(Paint.Align.CENTER);
    }

    /**
     * @param offsetY
     */
    public void setOffsetY(float offsetY)
    {
        this.offsetY = offsetY;
    }

    /**
     * 获取画笔,可以通过修改画笔属性来改变文本样式
     *
     * @return 用来绘制文本的画笔
     */
    public Paint getPaint()
    {
        return paint;
    }

    /**
     * 设置一个空信息用于展示
     */
    public void setEmptyMessage(CharSequence empty)
    {
        this.empty = empty;
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state)
    {
        if (state.getItemCount() == 0)
        {
            CharSequence text;
            String empty = this.empty.toString();
            if (paint.measureText(empty) < parent.getWidth())
            {
                text = this.empty;
            }
            else
            {
                text = empty.substring(0, paint.breakText(this.empty, 0, this.empty.length(), true, parent.getWidth(), null));
            }
            c.drawText(text, 0, text.length(), parent.getWidth() / 2, parent.getHeight() / 2 - TextPainUtil.getBaseLineOffset(paint) + offsetY, paint);
        }
        super.onDrawOver(c, parent, state);
    }

}
