package com.jhy.mkskin.skinview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.jhy.mkskin.SkinEnable;
import com.jhy.mkskin.skinhelper.BackgroundSkinHelper;
import com.jhy.mkskin.skinhelper.SkinHelper;

public
class SkinFrameLayout extends FrameLayout implements SkinEnable {
    private final BackgroundSkinHelper skinHelper;

    public SkinFrameLayout(Context context) {
        this(context, null);
    }

    public SkinFrameLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SkinFrameLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        skinHelper = new BackgroundSkinHelper(this, attrs);
    }

    @NonNull
    @Override
    public SkinHelper[] getSkinHelpers() {
        return new SkinHelper[]{skinHelper};
    }
}
