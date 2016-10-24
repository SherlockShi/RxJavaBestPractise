package com.sherlockshi.rxjavabestpractise.activity.category11_operators_to_convert_observables;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorListActivity;

/**
 * Author: SherlockShi
 * Date:   2016-10-21 22:34
 * Description:
 */
public class Category11_OperatorsToConvertObservablesActivity extends BaseOperatorListActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_category11_operators_to_convert_observables);
    }

    /**
     * 11.1 getIterator
     * @param view
     */
    public void jumpToCategory11Operator1GetIteratorActivity(View view) {
        startActivity(new Intent(this, Category11Operator1GetIteratorActivity.class));
    }

    /**
     * 11.2 toFuture
     * @param view
     */
    public void jumpToCategory11Operator2ToFutureActivity(View view) {
        startActivity(new Intent(this, Category11Operator2ToFutureActivity.class));
    }

    /**
     * 11.3 toIterable
     * @param view
     */
    public void jumpToCategory11Operator3ToIterableActivity(View view) {
        startActivity(new Intent(this, Category11Operator3ToIterableActivity.class));
    }

    /**
     * 11.4 toList
     * @param view
     */
    public void jumpToCategory11Operator4ToListActivity(View view) {
        startActivity(new Intent(this, Category11Operator4ToListActivity.class));
    }

    /**
     * 11.5 toMap
     * @param view
     */
    public void jumpToCategory11Operator5ToMapActivity(View view) {
        startActivity(new Intent(this, Category11Operator5ToMapActivity.class));
    }

    /**
     * 11.6 toMultiMap
     * @param view
     */
    public void jumpToCategory11Operator6ToMultiMapActivity(View view) {
        startActivity(new Intent(this, Category11Operator6ToMultiMapActivity.class));
    }

    /**
     * 11.7 toSortedList
     * @param view
     */
    public void jumpToCategory11Operator7ToSortedListActivity(View view) {
        startActivity(new Intent(this, Category11Operator7ToSortedListActivity.class));
    }

    /**
     * 11.8 nest
     * @param view
     */
    public void jumpToCategory11Operator8NestActivity(View view) {
        startActivity(new Intent(this, Category11Operator8NestActivity.class));
    }
}
