package com.jhy.mkskin.skinview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;

import com.jhy.mkskin.SkinEnable;
import com.jhy.mkskin.skinhelper.ImageViewSkinHelper;
import com.jhy.mkskin.skinhelper.SkinHelper;

public class SkinImageButton extends AppCompatImageButton implements SkinEnable {

    private final ImageViewSkinHelper skinHelper;

    public SkinImageButton(@NonNull Context context) {
        this(context, null);
    }

    public SkinImageButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SkinImageButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        skinHelper = new ImageViewSkinHelper(this, attrs);
    }

    @NonNull
    @Override
    public SkinHelper[] getSkinHelpers() {
        return new SkinHelper[]{skinHelper};
    }
}
