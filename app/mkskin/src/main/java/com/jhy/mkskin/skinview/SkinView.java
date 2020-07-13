package com.jhy.mkskin.skinview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.jhy.mkskin.SkinEnable;
import com.jhy.mkskin.skinhelper.BackgroundSkinHelper;
import com.jhy.mkskin.skinhelper.SkinHelper;

public
class SkinView extends View implements SkinEnable {
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

    @NonNull
    @Override
    public SkinHelper[] getSkinHelpers() {
        return new SkinHelper[]{skinHelper};
    }
}
