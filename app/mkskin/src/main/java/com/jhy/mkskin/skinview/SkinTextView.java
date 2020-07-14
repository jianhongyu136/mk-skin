package com.jhy.mkskin.skinview;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.jhy.mkskin.SkinEnable;
import com.jhy.mkskin.skinhelper.TextViewSkinHelper;

public class SkinTextView extends AppCompatTextView implements SkinEnable {

    private final TextViewSkinHelper skinHelper;

    public SkinTextView(Context context) {
        this(context, null);
    }

    public SkinTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SkinTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        skinHelper = new TextViewSkinHelper(this, attrs);
    }

    @Override
    public void changeSkin() {
        if (skinHelper != null)
            skinHelper.changeSkin();
    }
}
