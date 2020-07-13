package com.jhy.mkskin.skinhelper;

import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

import com.jhy.mkskin.SkinEnable;
import com.jhy.mkskin.SkinUtil;

/**
 * 这是用于皮肤切换具体实现的抽象类。
 * {@link SkinEnable}
 */
public abstract class SkinHelper {

    public SkinHelper(@NonNull View skinView, AttributeSet attributeSet) {

    }

    /**
     * 当整体皮肤切换时，{@link SkinUtil} 将会调用所有实现了{@link SkinEnable}接口的控件的{@link SkinEnable#getSkinHelpers()}方法。
     * 在{@link SkinEnable#getSkinHelpers()}中，会获取并调用该控件中所有创建出来的{@link SkinHelper}。
     */
    abstract public void changeSkin();
}
