package com.sherlockshi.rxjavabestpractise.util;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

/**
 * Author: SherlockShi
 * Date:   2016-09-17 21:28
 * Description:
 */
public class SpannableUtil {

    public static void setPartialTextOtherColor(TextView textView, int start, int count, int color) {
        Spannable spannable = new SpannableString(textView.getText());
        spannable.setSpan(new ForegroundColorSpan(color), start, start+count, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannable);
    }

    public static void setPartialTextOtherColor(TextView textView, int start, int count) {
        Spannable spannable = new SpannableString(textView.getText());
        spannable.setSpan(new ForegroundColorSpan(Color.RED), start, start+count, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannable);
    }
}
