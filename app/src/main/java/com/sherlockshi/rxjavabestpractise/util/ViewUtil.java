package com.sherlockshi.rxjavabestpractise.util;

import android.view.View;

/**
 * Author: SherlockShi
 * Date:   2016-09-18 22:19
 * Description:
 */
public class ViewUtil {

    public static void hide(View view) {
        if (view.getVisibility() == View.VISIBLE) {
            view.setVisibility(View.GONE);
        }
    }

    public static void show(View view) {
        if (view.getVisibility() == View.GONE) {
            view.setVisibility(View.VISIBLE);
        }
    }
}
