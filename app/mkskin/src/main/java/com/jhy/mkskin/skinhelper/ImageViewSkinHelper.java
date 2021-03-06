package com.jhy.mkskin.skinhelper;

import android.content.res.ColorStateList;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.NonNull;

/**
 * 实现控件背景颜色的切换。
 */
public class ImageViewSkinHelper extends SkinHelper<ImageView> {

    private final BackgroundSkinHelper backgroundSkinHelper;
    private int tintColor;

    public ImageViewSkinHelper(@NonNull ImageView skinView, AttributeSet attributeSet) {
        super(skinView, attributeSet);
        backgroundSkinHelper = new BackgroundSkinHelper(skinView, attributeSet);
        if (attributeSet != null) {
            tintColor = getAttrResourceID(XMLN_ANDROID, "tint");
        }
    }

    @Override
    public void changeSkin() {
        ImageView skinView = getSkinView();
        if (skinView == null)
            return;
        backgroundSkinHelper.changeSkin();
        if (tintColor != 0) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Integer color = getSkinValue(tintColor);
                if (color != null) {
                    skinView.setImageTintList(ColorStateList.valueOf(color));
                }
            }
        }
    }
}
