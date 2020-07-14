package com.jhy.mkskin.skinhelper;

import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class TextViewSkinHelper extends SkinHelper<TextView> {

    private final BackgroundSkinHelper backgroundSkinHelper;
    private final TextColorSkinHelper textColorSkinHelper;
    private final DrawableTintSkinHelper drawableTintSkinHelper;

    public TextViewSkinHelper(@NonNull TextView skinView, @NonNull AttributeSet attributeSet) {
        super(skinView, attributeSet);
        backgroundSkinHelper = new BackgroundSkinHelper(skinView, attributeSet);
        textColorSkinHelper = new TextColorSkinHelper(skinView, attributeSet);
        drawableTintSkinHelper = new DrawableTintSkinHelper(skinView, attributeSet);
    }

    @Override
    public void changeSkin() {
        backgroundSkinHelper.changeSkin();
        textColorSkinHelper.changeSkin();
        drawableTintSkinHelper.changeSkin();
    }
}
