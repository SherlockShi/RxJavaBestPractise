package com.sherlockshi.rxjavabestpractise.activity.category3_filtering_observables;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorListActivity;

/**
 * Author: SherlockShi
 * Date:   2016-09-16 20:24
 * Description:
 */
public class Category3_FilteringObservablesActivity extends BaseOperatorListActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_category3_filtering_observables);
    }

    /**
     * 3.1 filter
     * @param view
     */
    public void jumpToCategory3Operator1FilterActivity(View view) {
        startActivity(new Intent(this, Category3Operator1FilterActivity.class));
    }

    /**
     * 3.2 takeLast
     * @param view
     */
    public void jumpToCategory3Operator2TakeLastActivity(View view) {
        startActivity(new Intent(this, Category3Operator2TakeLastActivity.class));
    }

    /**
     * 3.3 last
     * @param view
     */
    public void jumpToCategory3Operator3LastActivity(View view) {
        startActivity(new Intent(this, Category3Operator3LastActivity.class));
    }

    /**
     * 3.4 skip
     * @param view
     */
    public void jumpToCategory3Operator4SkipActivity(View view) {
        startActivity(new Intent(this, Category3Operator4SkipActivity.class));
    }

    /**
     * 3.5 skipLast
     * @param view
     */
    public void jumpToCategory3Operator5SkipLastActivity(View view) {
        startActivity(new Intent(this, Category3Operator5SkipLastActivity.class));
    }

    /**
     * 3.6 take
     * @param view
     */
    public void jumpToCategory3Operator6TakeActivity(View view) {
        startActivity(new Intent(this, Category3Operator6TakeActivity.class));
    }

    /**
     * 3.7 first
     * @param view
     */
    public void jumpToCategory3Operator7FirstActivity(View view) {
        startActivity(new Intent(this, Category3Operator7FirstActivity.class));
    }

    /**
     * 3.8 elementAt
     * @param view
     */
    public void jumpToCategory3Operator8ElementAtActivity(View view) {
        startActivity(new Intent(this, Category3Operator8ElementAtActivity.class));
    }

    /**
     * 3.9 sample
     * @param view
     */
    public void jumpToCategory3Operator9SampleActivity(View view) {
        startActivity(new Intent(this, Category3Operator9SampleActivity.class));
    }

    /**
     * 3.10 debounce
     * @param view
     */
    public void jumpToCategory3Operator10DebounceActivity(View view) {
        startActivity(new Intent(this, Category3Operator10DebounceActivity.class));
    }

    /**
     * 3.11 distinct
     * @param view
     */
    public void jumpToCategory3Operator11DistinctActivity(View view) {
        startActivity(new Intent(this, Category3Operator11DistinctActivity.class));
    }

    /**
     * 3.12 ignoreElements
     * @param view
     */
    public void jumpToCategory3Operator12IgnoreElementsActivity(View view) {
        startActivity(new Intent(this, Category3Operator12IgnoreElementsActivity.class));
    }
}
