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
public class BackgroundSkinHelper extends SkinHelper {

    private int backgroundColorKey;
    private int backgroundTintKey;
    private View skinView;

    public BackgroundSkinHelper(@NonNull View skinView, AttributeSet attributeSet) {
        super(skinView, attributeSet);
        this.skinView = skinView;
        if (attributeSet != null) {
            backgroundColorKey = attributeSet.getAttributeResourceValue(null, "background", 0);
            backgroundTintKey = attributeSet.getAttributeResourceValue(null, "backgroundTint", 0);
        }
        if (SkinUtil.isSkinNotEmpty())
            changeSkin();
    }

    @Override
    public void changeSkin() {
        if (skinView == null)
            return;
        Drawable bg = SkinUtil.getSkinDrawable(backgroundColorKey);
        if (bg != null)
            skinView.setBackground(bg);
        Drawable tint = SkinUtil.getSkinDrawable(backgroundTintKey);
        if (tint instanceof ColorDrawable) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                skinView.setBackgroundTintList(ColorStateList.valueOf(((ColorDrawable) tint).getColor()));
            }
        }
    }
}
