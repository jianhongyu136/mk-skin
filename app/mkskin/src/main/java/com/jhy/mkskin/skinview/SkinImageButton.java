package com.jhy.mkskin.skinview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;

import com.jhy.mkskin.SkinEnable;
import com.jhy.mkskin.skinhelper.ImageViewSkinHelper;

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

    @Override
    public void setImageBitmap(Bitmap bm) {
        super.setImageBitmap(bm);
        changeSkin();
    }

    @Override
    public void setImageDrawable(@Nullable Drawable drawable) {
        super.setImageDrawable(drawable);
        changeSkin();
    }

    @Override
    public void setImageResource(int resId) {
        super.setImageResource(resId);
        changeSkin();
    }

    @Override
    public void setImageIcon(@Nullable Icon icon) {
        super.setImageIcon(icon);
        changeSkin();
    }

    @Override
    public void setImageURI(@Nullable Uri uri) {
        super.setImageURI(uri);
        changeSkin();
    }

    @Override
    public void changeSkin() {
        if (skinHelper != null)
            skinHelper.changeSkin();
    }
}
