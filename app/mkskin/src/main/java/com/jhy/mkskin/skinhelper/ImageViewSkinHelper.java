package com.jhy.mkskin.skinhelper;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.jhy.mkskin.SkinUtil;

/**
 * 实现控件背景颜色的切换。
 */
public class ImageViewSkinHelper extends SkinHelper {

    private final BackgroundSkinHelper backgroundSkinHelper;
    private final View skinView;
    private int tintColor;

    public ImageViewSkinHelper(@NonNull View skinView, AttributeSet attributeSet) {
        super(skinView, attributeSet);
        backgroundSkinHelper = new BackgroundSkinHelper(skinView, attributeSet);
        this.skinView = skinView;
        if (attributeSet != null) {
            tintColor = attributeSet.getAttributeResourceValue(null, "tint", 0);
        }
        if (SkinUtil.isSkinNotEmpty())
            changeSkin();
    }

    @Override
    public void changeSkin() {
        if (skinView == null)
            return;
        backgroundSkinHelper.changeSkin();
        Drawable drawable = SkinUtil.getSkinDrawable(tintColor);
        if (skinView instanceof ImageView && drawable instanceof ColorDrawable) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                ((ImageView) skinView).setImageTintList(ColorStateList.valueOf(((ColorDrawable) drawable).getColor()));
            }
        }

    }
}
