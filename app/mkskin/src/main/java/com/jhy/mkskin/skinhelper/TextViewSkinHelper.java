package com.jhy.mkskin.skinhelper;

import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.jhy.mkskin.SkinUtil;

public class TextViewSkinHelper extends SkinHelper {

    private final BackgroundSkinHelper backgroundSkinHelper;
    private final TextColorSkinHelper textColorSkinHelper;
    private final DrawableTintSkinHelper drawableTintSkinHelper;

    public TextViewSkinHelper(@NonNull View skinView, @NonNull AttributeSet attributeSet) {
        super(skinView, attributeSet);
        backgroundSkinHelper = new BackgroundSkinHelper(skinView, attributeSet);
        textColorSkinHelper = new TextColorSkinHelper(skinView, attributeSet);
        drawableTintSkinHelper = new DrawableTintSkinHelper(skinView, attributeSet);
        if (SkinUtil.isSkinNotEmpty())
            changeSkin();
    }

    @Override
    public void changeSkin() {
        backgroundSkinHelper.changeSkin();
        textColorSkinHelper.changeSkin();
        drawableTintSkinHelper.changeSkin();
    }
}
