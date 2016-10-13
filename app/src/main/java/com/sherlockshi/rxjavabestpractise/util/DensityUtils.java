package com.sherlockshi.rxjavabestpractise.util;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

/**
 * http://blog.csdn.net/lmj623565791/article/details/38965311
 */

/**
 * @author: Felix Shi
 * @date: 2015-9-10 14:48
 * @Description: 常用单位转换的辅助类
 */
public class DensityUtils {

    /**
     * dp转px
     *
     * @param context
     * @param dpVal
     * @return
     */
    public static int dp2px(Context context, float dpVal)
    {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, context.getResources().getDisplayMetrics());
    }

    /**
     * sp转px
     *
     * @param context
     * @param spVal
     * @return
     */
    public static int sp2px(Context context, float spVal)
    {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spVal, context.getResources().getDisplayMetrics());
    }

    /**
     * px转dp
     *
     * @param context
     * @param pxVal
     * @return
     */
    public static float px2dp(Context context, float pxVal)
    {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (pxVal / scale);
    }

    /**
     * px转sp
     *
     * @param context
     * @param pxVal
     * @return
     */
    public static float px2sp(Context context, float pxVal)
    {
        return (pxVal / context.getResources().getDisplayMetrics().scaledDensity);
    }
    
	/**
	 * 修改普通View的高<br>
	 * Adapter---getView方法中慎用
	 */
	public static void changeH(View v, int H) {
		LayoutParams params = (LayoutParams) v.getLayoutParams();
		params.height = H;
		v.setLayoutParams(params);
	}

	/**
	 * 修改普通View的宽<br>
	 * Adapter---getView方法中慎用
	 */
	public static void changeW(View v, int W) {
		LayoutParams params = (LayoutParams) v.getLayoutParams();
		params.width = W;
		v.setLayoutParams(params);
	}

	/**
	 * 修改控件的宽高<br>
	 * Adapter---getView方法中慎用
	 * 
	 * @param v
	 *            控件
	 * @param W
	 *            宽度
	 * @param H
	 *            高度
	 */
	public static void changeWH(View v, int W, int H) {
		LayoutParams params = (LayoutParams) v.getLayoutParams();
		params.width = W;
		params.height = H;
		v.setLayoutParams(params);
	}
}
