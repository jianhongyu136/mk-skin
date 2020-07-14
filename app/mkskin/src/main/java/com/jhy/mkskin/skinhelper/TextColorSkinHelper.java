package com.jhy.mkskin.skinhelper;

import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.NonNull;

/**
 * 实现控件背景颜色的切换。
 */
public class TextColorSkinHelper extends SkinHelper<TextView> {

    private int textColor;
    private int textColorHint;

    public TextColorSkinHelper(@NonNull TextView skinView, AttributeSet attributeSet) {
        super(skinView, attributeSet);
        if (attributeSet != null) {
            textColor = getAttrResourceID(XMLN_ANDROID, "textColor");
            textColorHint = getAttrResourceID(XMLN_ANDROID, "textColorHint");
        }
    }

    @Override
    public void changeSkin() {
        TextView textView = getSkinView();
        if (textView == null)
            return;
        Integer color = getSkinValue(textColor);
        if (color != null) {
            textView.setTextColor(color);
        }
        color = getSkinValue(textColorHint);
        if (color != null) {
            textView.setHintTextColor(color);
        }

    }
}
