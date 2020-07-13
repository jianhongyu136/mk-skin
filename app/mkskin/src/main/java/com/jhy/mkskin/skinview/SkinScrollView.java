package com.jhy.mkskin.skinview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

import androidx.annotation.NonNull;

import com.jhy.mkskin.SkinEnable;
import com.jhy.mkskin.skinhelper.BackgroundSkinHelper;
import com.jhy.mkskin.skinhelper.SkinHelper;

public class SkinScrollView extends ScrollView implements SkinEnable {

    private final BackgroundSkinHelper skinHelper;

    public SkinScrollView(Context context) {
        this(context, null);
    }

    public SkinScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SkinScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        skinHelper = new BackgroundSkinHelper(this, attrs);
    }

    @NonNull
    @Override
    public SkinHelper[] getSkinHelpers() {
        return new SkinHelper[]{skinHelper};
    }
}
