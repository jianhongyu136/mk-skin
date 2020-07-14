package com.jhy.mkskin;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

/**
 * 皮肤切换工具类。
 */
public class SkinUtil {

    private static final int[] STATE_NORMAL = {-android.R.attr.state_pressed};
    private static final int[] STATE_PRESSED = {android.R.attr.state_pressed};
    private static final int[] STATE_SELECTED = {android.R.attr.state_selected};
    private static final int[] STATE_DIS_ENABLED = {-android.R.attr.state_enabled};

    public static Integer getSkinValue(Context context, @AttrRes int attrID) {
        if (context != null && attrID != 0) {
            TypedValue typedValue = new TypedValue();
            if (context.getTheme().resolveAttribute(attrID, typedValue, false)) {
                return typedValue.data;
            }
        }
        return null;
    }

    public static Drawable getSkinDrawable(Context context, @DrawableRes int drawableID) {
        if (context != null && drawableID != 0) {
            try {
                return ContextCompat.getDrawable(context, drawableID);
            } catch (Exception ignored) {
            }
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
            try {
                ((SkinEnable) view).changeSkin();
                view.invalidate();
            } catch (Exception e) {
                e.printStackTrace();
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
        /*  Integer statusColor = getSkinValue(activity, R.attr.skin_statusBarTextColor);
        changeStatusBarTextColor(activity, statusColor != null && statusColor == Color.BLACK);
      Integer navColor = getSkinValue(activity, R.attr.skin_navigationBarColor);
        if (navColor != null)
            setNavigationBarColor(activity, navColor);*/
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

    public static ColorStateList createColorStateList(int normal, int pressed, int focused, int unable) {
        int[] colors = new int[]{pressed, focused, normal, focused, unable, normal};
        int[][] states = new int[6][];
        states[0] = new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled};
        states[1] = new int[]{android.R.attr.state_enabled, android.R.attr.state_focused};
        states[2] = new int[]{android.R.attr.state_enabled};
        states[3] = new int[]{android.R.attr.state_focused};
        states[4] = new int[]{android.R.attr.state_window_focused};
        states[5] = new int[]{};
        return new ColorStateList(states, colors);
    }


    public static void changeStatusBarTextColor(Activity activity, boolean isBlack) {
        Window window = activity.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            int uiflag = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;// | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            if (isBlack) {
                uiflag |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    uiflag |= View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
                }
            }
            window.getDecorView().setSystemUiVisibility(uiflag);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

    }
}
