package com.jhy.mkskin;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

import com.jhy.mkskin.skinhelper.SkinHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 皮肤切换工具类。
 */
public class SkinUtil {
    private static final int[] STATE_NORMAL = {-android.R.attr.state_pressed};
    private static final int[] STATE_PRESSED = {android.R.attr.state_pressed};
    private static final int[] STATE_SELECTED = {android.R.attr.state_selected};
    private static final int[] STATE_DIS_ENABLED = {-android.R.attr.state_enabled};
    /**
     * 皮肤属性集，这里存放了所有皮肤的颜色值。
     */
    private static Map<Integer, Drawable> skinDrawableMap = new HashMap<>();

    public static SkinSetter getSkinSetter() {
        return new SkinSetter();
    }

    /**
     * 获取当前皮肤属性集中的某个属性颜色值。
     *
     * @param skinDrawableKey 皮肤属性名
     * @return 当前皮肤属性集中指定属性名称的颜色
     */
    public static Drawable getSkinDrawable(@StringRes int skinDrawableKey) {
        if (skinDrawableMap != null && skinDrawableMap.containsKey(skinDrawableKey)) {
            return skinDrawableMap.get(skinDrawableKey);
        }
        return null;
    }

    /**
     * 遍历所有控件，并进行皮肤切换
     */
    private static void refreshView(View view) {
        if (view == null) return;
        view.destroyDrawingCache();
        if (view instanceof SkinEnable) {
            SkinHelper[] skinHelpers = ((SkinEnable) view).getSkinHelpers();
            for (SkinHelper skinHelper : skinHelpers) {
                try {
                    skinHelper.changeSkin();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (view instanceof ViewGroup) {
                for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                    refreshView(((ViewGroup) view).getChildAt(i));
                }
            }
        } else {
            if (view instanceof ViewGroup) {
                for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                    refreshView(((ViewGroup) view).getChildAt(i));
                }
            }
        }
    }

    public static void applySkin(@NonNull Activity activity) {
        Drawable statusColor = getSkinDrawable(R.string.skin_statusBarTextColor);
        if (statusColor instanceof ColorDrawable)
            changeStatusBarTextColor(activity, ((ColorDrawable) statusColor).getColor() == Color.BLACK);
        Drawable navColor = getSkinDrawable(R.string.skin_navigationBarColor);
        if (navColor instanceof ColorDrawable)
            setNavigationBarColor(activity, ((ColorDrawable) navColor).getColor());
        View rootView = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        refreshView(rootView);
    }

    public static void setNavigationBarColor(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setNavigationBarColor(color);
        }
    }

    public static StateListDrawable createStateListDrawable(Drawable normal, Drawable pressed, Drawable select, Drawable disEnabled) {
        StateListDrawable drawable = new StateListDrawable();
        if (normal != null)
            drawable.addState(STATE_NORMAL, normal);
        if (pressed != null)
            drawable.addState(STATE_PRESSED, pressed);
        if (select != null)
            drawable.addState(STATE_SELECTED, select);
        if (disEnabled != null)
            drawable.addState(STATE_DIS_ENABLED, disEnabled);
        return drawable;
    }

    public static boolean isSkinNotEmpty() {
        return !skinDrawableMap.isEmpty();
    }

    public static void changeStatusBarTextColor(Activity activity, boolean isBlack) {
        Window window = activity.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            int uiflag = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;// | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            if (isBlack) {
                uiflag |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            }
            window.getDecorView().setSystemUiVisibility(uiflag);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

    }

    public static class SkinSetter {

        private SkinSetter() {
        }

        public void put(@StringRes int id, Drawable drawable) {
            skinDrawableMap.put(id, drawable);
        }

        public void remove(@StringRes int id) {
            skinDrawableMap.remove(id);
        }

        public boolean containsKey(@StringRes int id) {
            return skinDrawableMap.containsKey(id);
        }

        public boolean isEmpty() {
            return skinDrawableMap.isEmpty();
        }

        public boolean containsDrawable(Drawable drawable) {
            return skinDrawableMap.containsValue(drawable);
        }

        public Set<Integer> keySet() {
            return skinDrawableMap.keySet();
        }

        public void clearAll() {
            skinDrawableMap.clear();
        }
    }
}
