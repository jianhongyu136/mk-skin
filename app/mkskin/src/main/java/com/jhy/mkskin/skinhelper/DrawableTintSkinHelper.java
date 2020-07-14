package com.jhy.mkskin.skinhelper;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.NonNull;

/**
 * 实现控件背景颜色的切换。
 */
public class DrawableTintSkinHelper extends SkinHelper<TextView> {

    private int drawableTint;

    public DrawableTintSkinHelper(@NonNull TextView skinView, AttributeSet attributeSet) {
        super(skinView, attributeSet);
        if (attributeSet != null) {
            drawableTint = getAttrResourceID(XMLN_ANDROID, "drawableTint");
            if (drawableTint == 0)
                drawableTint = getAttrResourceID(null, "drawableTint");
        }
    }

    @Override
    public void changeSkin() {
        TextView textView = getSkinView();
        if (textView == null)
            return;
        Integer color = getSkinValue(drawableTint);
        if (color != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                textView.setCompoundDrawableTintList(ColorStateList.valueOf(color));
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Drawable[] drawables = textView.getCompoundDrawables();
                    for (Drawable compoundDrawable : drawables) {
                        if (compoundDrawable != null)
                            compoundDrawable.setTint(color);
                    }
                    drawables = textView.getCompoundDrawablesRelative();
                    for (Drawable compoundDrawable : drawables) {
                        if (compoundDrawable != null)
                            compoundDrawable.setTint(color);
                    }
                }
            }
        }

    }
}
