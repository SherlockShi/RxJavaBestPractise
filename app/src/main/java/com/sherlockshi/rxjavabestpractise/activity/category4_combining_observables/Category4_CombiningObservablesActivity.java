package com.sherlockshi.rxjavabestpractise.activity.category4_combining_observables;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorListActivity;

/**
 * Author: SherlockShi
 * Date:   2016-10-16 10:48
 * Description:
 */
public class Category4_CombiningObservablesActivity extends BaseOperatorListActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_category4_combining_observables);
    }

    /**
     * 4.1 startWith
     * @param view
     */
    public void jumpToCategory4Operator1StartWithActivity(View view) {
        startActivity(new Intent(this, Category4Operator1StartWithActivity.class));
    }

    /**
     * 4.2 merge
     * @param view
     */
    public void jumpToCategory4Operator2MergeActivity(View view) {
        startActivity(new Intent(this, Category4Operator2MergeActivity.class));
    }

    /**
     * 4.3 zip
     * @param view
     */
    public void jumpToCategory4Operator3ZipActivity(View view) {
        startActivity(new Intent(this, Category4Operator3ZipActivity.class));
    }

    /**
     * 4.4 and/then/when
     * @param view
     */
    public void jumpToCategory4Operator4AndThenWhenActivity(View view) {
        startActivity(new Intent(this, Category4Operator4AndThenWhenActivity.class));
    }

    /**
     * 4.5 combineLatest
     * @param view
     */
    public void jumpToCategory4Operator5CombineLatestActivity(View view) {
        startActivity(new Intent(this, Category4Operator5CombineLatestActivity.class));
    }

    /**
     * 4.6 join
     * @param view
     */
    public void jumpToCategory4Operator6JoinActivity(View view) {
        startActivity(new Intent(this, Category4Operator6JoinActivity.class));
    }

    /**
     * 4.7 switch
     * @param view
     */
    public void jumpToCategory4Operator7SwitchActivity(View view) {
        startActivity(new Intent(this, Category4Operator7SwitchActivity.class));
    }
}
