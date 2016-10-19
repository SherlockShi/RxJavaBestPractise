package com.sherlockshi.rxjavabestpractise.activity.category9_backpressure_operators;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorListActivity;

/**
 * Author: SherlockShi
 * Date:   2016-09-19 16:40
 * Description:
 */
public class Category9_BackpressureOperatorsActivity extends BaseOperatorListActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_category9_backpressure_operators);
    }

    /**
     * 9.1 onBackpressureBuffer
     * @param view
     */
    public void jumpToCategory9Operator1OnBackpressureBufferActivity(View view) {
        startActivity(new Intent(this, Category9Operator1OnBackpressureBufferActivity.class));
    }

    /**
     * 9.2 onBackpressureDrop
     * @param view
     */
    public void jumpToCategory9Operator2OnBackpressureDropActivity(View view) {
        startActivity(new Intent(this, Category9Operator2OnBackpressureDropActivity.class));
    }

    /**
     * 9.3 onBackpressureLatest
     * @param view
     */
    public void jumpToCategory9Operator3OnBackpressureLatestActivity(View view) {
        startActivity(new Intent(this, Category9Operator3OnBackpressureLatestActivity.class));
    }
}
