package com.jhy.mkskin.skinview;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;

import com.jhy.mkskin.SkinEnable;
import com.jhy.mkskin.skinhelper.TextViewSkinHelper;

public class SkinEditText extends AppCompatEditText implements SkinEnable {

    private final TextViewSkinHelper skinHelper;

    public SkinEditText(Context context) {
        this(context, null);
    }

    public SkinEditText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        skinHelper = new TextViewSkinHelper(this, attrs);
    }

    @Override
    public void changeSkin() {
        if (skinHelper != null)
            skinHelper.changeSkin();
    }
}
