package com.jhy.mkskin.skinview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.jhy.mkskin.SkinEnable;
import com.jhy.mkskin.skinhelper.BackgroundSkinHelper;
import com.jhy.mkskin.skinhelper.SkinHelper;

public abstract class SkinViewGroup extends ViewGroup implements SkinEnable {

    private final BackgroundSkinHelper skinHelper;

    public SkinViewGroup(Context context) {
        this(context, null);
    }

    public SkinViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SkinViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        skinHelper = new BackgroundSkinHelper(this, attrs);
    }


    @NonNull
    @Override
    public SkinHelper[] getSkinHelpers() {
        return new SkinHelper[]{skinHelper};
    }
}
