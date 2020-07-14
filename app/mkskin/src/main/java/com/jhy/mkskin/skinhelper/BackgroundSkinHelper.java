package com.jhy.mkskin.skinhelper;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

/**
 * 实现控件背景颜色的切换。
 */
public class BackgroundSkinHelper extends SkinHelper<View> {

    private int background;
    private int backgroundTint;

    public BackgroundSkinHelper(@NonNull View skinView, AttributeSet attributeSet) {
        super(skinView, attributeSet);
        if (attributeSet != null) {
            background = getAttrResourceID(XMLN_ANDROID, "background");
            backgroundTint = getAttrResourceID(XMLN_ANDROID, "backgroundTint");
        }
    }

    @Override
    public void changeSkin() {
        View skinView = getSkinView();
        if (skinView == null)
            return;
        if (background != 0) {
            Integer bg = getSkinValue(background);
            if (bg != null) {
                skinView.setBackgroundColor(bg);
            } else {
                Drawable drawable = getSkinDrawable(background);
                if (drawable != null) {
                    skinView.setBackground(drawable);
                }
            }
        }
        if (backgroundTint != 0) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Integer tint = getSkinValue(backgroundTint);
                if (tint != null) {
                    skinView.setBackgroundTintList(ColorStateList.valueOf(tint));
                }
            }
        }
    }
}
