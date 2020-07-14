package com.jhy.mkskin.skinhelper;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

import com.jhy.mkskin.SkinEnable;
import com.jhy.mkskin.SkinUtil;

import java.lang.ref.WeakReference;

/**
 * 这是用于皮肤切换具体实现的抽象类。
 * {@link SkinEnable}
 */
public abstract class SkinHelper<T extends View> {
    public final static String XMLN_ANDROID = "http://schemas.android.com/apk/res/android";
    private final AttributeSet attrs;
    private final WeakReference<Context> context;
    private final WeakReference<T> skinView;

    public SkinHelper(@NonNull T skinView, AttributeSet attributeSet) {
        this.attrs = attributeSet;
        this.skinView = new WeakReference<>(skinView);
        this.context = new WeakReference<>(skinView.getContext());
    }

    protected T getSkinView() {
        return skinView.get();
    }

    protected Integer getSkinValue(@AttrRes int attrID) {
        return SkinUtil.getSkinValue(context.get(), attrID);
    }

    protected Drawable getSkinDrawable(@DrawableRes int drawableID) {
        return SkinUtil.getSkinDrawable(context.get(), drawableID);
    }

    /**
     * 当整体皮肤切换时，{@link SkinUtil} 将会调用所有实现了{@link SkinEnable}接口的控件的{@link SkinEnable#changeSkin()}方法。
     * 在{@link SkinEnable#changeSkin()}中，会获取并调用该控件中所有创建出来的{@link SkinHelper}。
     */
    abstract public void changeSkin();

    protected int getAttrResourceID(String namespace, String name) {
        if (attrs == null) return 0;
        int id = attrs.getAttributeResourceValue(namespace, name, 0);
        if (id == 0) {
            String v = attrs.getAttributeValue(namespace, name);
            if (v == null || v.length() < 2 || v.charAt(0) != '?') {
                return 0;
            }
            try {
                return Integer.parseInt(v.subSequence(1, v.length()).toString());
            } catch (NumberFormatException e) {
                return 0;
            }
        }
        return id;
    }
}
