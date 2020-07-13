package com.jhy.mkskin.skinhelper;

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
    private View skinView;

    public BackgroundSkinHelper(@NonNull View skinView, AttributeSet attributeSet) {
        super(skinView, attributeSet);
        this.skinView = skinView;
        if(attributeSet != null){
            backgroundColorKey = attributeSet.getAttributeResourceValue(null, "background", 0);
        }
        if (SkinUtil.isSkinNotEmpty())
            changeSkin();
    }

    @Override
    public void changeSkin() {
        if (skinView != null)
            skinView.setBackground(SkinUtil.getSkinDrawable(backgroundColorKey));
    }
}
