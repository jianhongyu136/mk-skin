package com.jhy.mkskin.skinview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.jhy.mkskin.SkinEnable;
import com.jhy.mkskin.skinhelper.BackgroundSkinHelper;

public class SkinView extends View implements SkinEnable {
    private final BackgroundSkinHelper skinHelper;

    public SkinView(Context context) {
        this(context, null);
    }

    public SkinView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SkinView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        skinHelper = new BackgroundSkinHelper(this, attrs);
    }

    @Override
    public void changeSkin() {
        if (skinHelper != null)
            skinHelper.changeSkin();
    }
}
