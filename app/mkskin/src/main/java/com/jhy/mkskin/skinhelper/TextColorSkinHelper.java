package com.jhy.mkskin.skinhelper;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.jhy.mkskin.SkinUtil;

/**
 * 实现控件背景颜色的切换。
 */
public class TextColorSkinHelper extends SkinHelper {

    private int textColor;
    private View skinView;

    public TextColorSkinHelper(@NonNull View skinView, AttributeSet attributeSet) {
        super(skinView, attributeSet);
        this.skinView = skinView;
        if (attributeSet != null)
            textColor = attributeSet.getAttributeResourceValue(null, "textColor", 0);
        if (SkinUtil.isSkinNotEmpty())
            changeSkin();
    }

    @Override
    public void changeSkin() {
        if (skinView != null)
            if (skinView instanceof TextView) {
                Drawable drawable = SkinUtil.getSkinDrawable(textColor);
                if (drawable instanceof ColorDrawable) {
                    ((TextView) skinView).setTextColor(((ColorDrawable) drawable).getColor());
                }
            }
    }
}
