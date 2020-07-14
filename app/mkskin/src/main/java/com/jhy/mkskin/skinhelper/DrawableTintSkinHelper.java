package com.jhy.mkskin.skinhelper;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.jhy.mkskin.SkinUtil;

/**
 * 实现控件背景颜色的切换。
 */
public class DrawableTintSkinHelper extends SkinHelper {

    private int drawableTint;
    private View skinView;

    public DrawableTintSkinHelper(@NonNull View skinView, AttributeSet attributeSet) {
        super(skinView, attributeSet);
        this.skinView = skinView;
        if (attributeSet != null) {
            drawableTint = attributeSet.getAttributeResourceValue(null, "drawableTint", 0);
        }
        if (SkinUtil.isSkinNotEmpty())
            changeSkin();
    }

    @Override
    public void changeSkin() {
        if (skinView == null)
            return;
        if (skinView instanceof TextView) {
            TextView textView = (TextView) skinView;
            Drawable drawable = SkinUtil.getSkinDrawable(drawableTint);
            if (drawable instanceof ColorDrawable) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    textView.setCompoundDrawableTintList(ColorStateList.valueOf(((ColorDrawable) drawable).getColor()));
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        for (Drawable compoundDrawable : textView.getCompoundDrawables()) {
                            compoundDrawable.setTint(((ColorDrawable) drawable).getColor());
                        }
                        for (Drawable compoundDrawable : textView.getCompoundDrawablesRelative()) {
                            compoundDrawable.setTint(((ColorDrawable) drawable).getColor());
                        }
                    }
                }
            }
        }
    }
}
