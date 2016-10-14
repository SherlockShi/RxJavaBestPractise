package com.sherlockshi.rxjavabestpractise.activity.category1_creating_observables;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.sherlockshi.rxjavabestpractise.base.BaseOperatorListActivity;
import com.sherlockshi.rxjavabestpractise.R;

/**
 * Author: SherlockShi
 * Date:   2016-09-16 20:21
 * Description:
 */
public class Category1_CreatingObservablesActivity extends BaseOperatorListActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_category1_creating_observables);
    }

    /**
     * 1.1 create
     * @param view
     */
    public void jumpToCategory1Operator1CreateActivity(View view) {
        startActivity(new Intent(this, Category1Operator1CreateActivity.class));
    }

    /**
     * 1.2 defer
     * @param view
     */
    public void jumpToCategory1Operator2DeferActivity(View view) {
        startActivity(new Intent(this, Category1Operator2DeferActivity.class));
    }

    /**
     * 1.3.1 empty
     * @param view
     */
    public void jumpToCategory1Operator31EmptyActivity(View view) {
        startActivity(new Intent(this, Category1Operator3_1EmptyActivity.class));
    }

    /**
     * 1.3.2 never
     * @param view
     */
    public void jumpToCategory1Operator32NeverActivity(View view) {
        startActivity(new Intent(this, Category1Operator3_2NeverActivity.class));
    }

    /**
     * 1.3.3 throw
     * @param view
     */
    public void jumpToCategory1Operator33ThrowActivity(View view) {
        startActivity(new Intent(this, Category1Operator3_3ThrowActivity.class));
    }

    /**
     * 1.4 from
     * @param view
     */
    public void jumpToCategory1Operator4FromActivity(View view) {
        startActivity(new Intent(this, Category1Operator4FromActivity.class));
    }

    /**
     * 1.5 interval
     * @param view
     */
    public void jumpToCategory1Operator5IntervalActivity(View view) {
        startActivity(new Intent(this, Category1Operator5IntervalActivity.class));
    }

    /**
     * 1.6 just
     * @param view
     */
    public void jumpToCategory1Operator6JustActivity(View view) {
        startActivity(new Intent(this, Category1Operator6JustActivity.class));
    }

    /**
     * 1.7 range
     * @param view
     */
    public void jumpToCategory1Operator7RangeActivity(View view) {
        startActivity(new Intent(this, Category1Operator7RangeActivity.class));
    }

    /**
     * 1.8 repeat
     * @param view
     */
    public void jumpToCategory1Operator8RepeatActivity(View view) {
        startActivity(new Intent(this, Category1Operator8RepeatActivity.class));
    }

    /**
     * 1.9 start
     * @param view
     */
    public void jumpToCategory1Operator9StartActivity(View view) {
        startActivity(new Intent(this, Category1Operator9StartActivity.class));
    }

    /**
     * 1.10 timer
     * @param view
     */
    public void jumpToCategory1Operator10TimerActivity(View view) {
        startActivity(new Intent(this, Category1Operator10TimerActivity.class));
    }
}
