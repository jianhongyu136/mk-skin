package com.jhy.mkskin.skinview;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import com.jhy.mkskin.SkinEnable;
import com.jhy.mkskin.skinhelper.BackgroundSkinHelper;
import com.jhy.mkskin.skinhelper.ImageViewSkinHelper;
import com.jhy.mkskin.skinhelper.SkinHelper;

public class SkinImageView extends AppCompatImageView implements SkinEnable {

    private ImageViewSkinHelper skinHelper;

    public SkinImageView(@NonNull Context context) {
        this(context, null);
    }

    public SkinImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SkinImageView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        skinHelper = new ImageViewSkinHelper(this, attrs);
    }

    @NonNull
    @Override
    public SkinHelper[] getSkinHelpers() {
        return new SkinHelper[]{skinHelper};
    }
}
