package com.jhy.mkskin;

/**
 * 启用控件皮肤切换的接口。
 * 实现了该接口的控件将会参与皮肤切换。
 */
public interface SkinEnable {

    /**
     * 当切换皮肤时，该方法将会被调用。
     */
    void changeSkin();
}
