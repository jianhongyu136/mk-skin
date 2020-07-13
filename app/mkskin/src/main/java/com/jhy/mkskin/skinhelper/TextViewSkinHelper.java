package com.jhy.mkskin.skinhelper;

import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

import com.jhy.mkskin.SkinUtil;

public class TextViewSkinHelper extends SkinHelper {

    private BackgroundSkinHelper backgroundSkinHelper;
    private TextColorSkinHelper textColorSkinHelper;

    public TextViewSkinHelper(@NonNull View skinView, @NonNull AttributeSet attributeSet) {
        super(skinView, attributeSet);
        backgroundSkinHelper = new BackgroundSkinHelper(skinView, attributeSet);
        textColorSkinHelper = new TextColorSkinHelper(skinView, attributeSet);
        if (SkinUtil.isSkinEmpty())
            changeSkin();
    }

    @Override
    public void changeSkin() {
        backgroundSkinHelper.changeSkin();
        textColorSkinHelper.changeSkin();
    }
}
