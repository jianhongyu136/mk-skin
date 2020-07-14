package com.jhy.mkskin.skinhelper;

import android.content.res.ColorStateList;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;

/**
 * 实现控件背景颜色的切换。
 */
public class ProgressTintSkinHelper extends SkinHelper<ProgressBar> {

    private final BackgroundSkinHelper backgroundSkinHelper;
    private final View skinView;
    private int progressTint;

    public ProgressTintSkinHelper(@NonNull ProgressBar skinView, AttributeSet attributeSet) {
        super(skinView, attributeSet);
        backgroundSkinHelper = new BackgroundSkinHelper(skinView, attributeSet);
        this.skinView = skinView;
        if (attributeSet != null) {
            progressTint = getAttrResourceID(XMLN_ANDROID, "progressTint");
        }
    }

    @Override
    public void changeSkin() {
        if (skinView == null)
            return;
        backgroundSkinHelper.changeSkin();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (skinView instanceof ProgressBar) {
                Integer color = getSkinValue(progressTint);
                if (color != null) {
                    ((ProgressBar) skinView).setProgressTintList(ColorStateList.valueOf(color));
                }
            }
        }
    }
}
