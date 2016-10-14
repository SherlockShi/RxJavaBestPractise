package com.sherlockshi.rxjavabestpractise.activity.category2_transforming_observables;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorListActivity;

/**
 * Author: SherlockShi
 * Date:   2016-09-16 20:23
 * Description:
 */
public class Category2_TransformingObservablesActivity extends BaseOperatorListActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_category2_transforming_observables);
    }

    /**
     * 2.1 map
     * @param view
     */
    public void jumpToCategory2Operator1MapActivity(View view) {
        startActivity(new Intent(this, Category2Operator1MapActivity.class));
    }

    /**
     * 2.2 flatMap
     * @param view
     */
    public void jumpToCategory2Operator2FlatMapActivity(View view) {
        startActivity(new Intent(this, Category2Operator2FlatMapActivity.class));
    }

    /**
     * 2.3 scan
     * @param view
     */
    public void jumpToCategory2Operator3ScanActivity(View view) {
        startActivity(new Intent(this, Category2Operator3ScanActivity.class));
    }

    /**
     * 2.4 groupBy
     * @param view
     */
    public void jumpToCategory2Operator4GroupByActivity(View view) {
        startActivity(new Intent(this, Category2Operator4GroupByActivity.class));
    }

    /**
     * 2.5 buffer
     * @param view
     */
    public void jumpToCategory2Operator1BufferActivity(View view) {
        startActivity(new Intent(this, Category2Operator5BufferActivity.class));
    }

    /**
     * 2.6 window
     * @param view
     */
    public void jumpToCategory2Operator6WindowActivity(View view) {
        startActivity(new Intent(this, Category2Operator6WindowActivity.class));
    }
}
