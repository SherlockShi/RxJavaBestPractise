package com.sherlockshi.rxjavabestpractise.activity.category8_mathematical_and_aggregate_operators;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorListActivity;

/**
 * Author: SherlockShi
 * Date:   2016-09-19 11:30
 * Description:
 */
public class Category8_MathematicalAndAggregateOperatorsActivity extends BaseOperatorListActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_category8_mathematical_and_aggregate_operators);
    }

    /**
     * 8.1 average
     * @param view
     */
    public void jumpToCategory8Operator1AverageActivity(View view) {
        startActivity(new Intent(this, Category8Operator1AverageActivity.class));
    }

    /**
     * 8.2 max
     * @param view
     */
    public void jumpToCategory8Operator2MaxActivity(View view) {
        startActivity(new Intent(this, Category8Operator2MaxActivity.class));
    }

    /**
     * 8.3 min
     * @param view
     */
    public void jumpToCategory8Operator3MinActivity(View view) {
        startActivity(new Intent(this, Category8Operator3MinActivity.class));
    }

    /**
     * 8.4 sum
     * @param view
     */
    public void jumpToCategory8Operator4SumActivity(View view) {
        startActivity(new Intent(this, Category8Operator4SumActivity.class));
    }

    /**
     * 8.5 concat
     * @param view
     */
    public void jumpToCategory8Operator5ConcatActivity(View view) {
        startActivity(new Intent(this, Category8Operator5ConcatActivity.class));
    }

    /**
     * 8.6 count
     * @param view
     */
    public void jumpToCategory8Operator6CountActivity(View view) {
        startActivity(new Intent(this, Category8Operator6CountActivity.class));
    }

    /**
     * 8.7 reduce
     * @param view
     */
    public void jumpToCategory8Operator7ReduceActivity(View view) {
        startActivity(new Intent(this, Category8Operator7ReduceActivity.class));
    }
}
