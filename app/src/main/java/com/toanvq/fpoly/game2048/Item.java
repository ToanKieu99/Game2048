package com.toanvq.fpoly.game2048;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.support.annotation.Nullable;
import android.widget.TextView;

public class Item extends TextView {
    public Item(Context context) {
        super(context);
    }

    public Item(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Item(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int dai = getMeasuredWidth();
        setMeasuredDimension(dai, dai);
    }

    @SuppressLint("NewApi")
    public void setTett(int so) {
        if (so < 100) {
            setTextSize(40);
        } else if (so < 1000) {
            setTextSize(35);
        } else {
            setTextSize(30);
        }

        if (so>=2){
            setTextColor(Color.WHITE);
        }
        GradientDrawable drawable = (GradientDrawable) this.getBackground();
        drawable.setColor(DataGame.getDataGame().colorr(so));
        setBackground(drawable);



        if (so == 0){
            setText("");
        }else {
            setText(""+so);
        }
    }
}
