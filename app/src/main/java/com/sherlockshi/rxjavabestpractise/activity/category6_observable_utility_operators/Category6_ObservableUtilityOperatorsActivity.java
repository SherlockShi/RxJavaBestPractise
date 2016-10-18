package com.sherlockshi.rxjavabestpractise.activity.category6_observable_utility_operators;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorListActivity;

/**
 * Author: SherlockShi
 * Date:   2016-09-16 20:29
 * Description:
 */
public class Category6_ObservableUtilityOperatorsActivity extends BaseOperatorListActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_category6_observable_utility_operators);
    }

    /**
     * 6.1 materialize
     * @param view
     */
    public void jumpToCategory6Operator1MaterializeActivity(View view) {
        startActivity(new Intent(this, Category6Operator1MaterializeActivity.class));
    }

    /**
     * 6.2 dematerialize
     * @param view
     */
    public void jumpToCategory6Operator2DematerializeActivity(View view) {
        startActivity(new Intent(this, Category6Operator2DematerializeActivity.class));
    }

    /**
     * 6.3 timestamp
     * @param view
     */
    public void jumpToCategory6Operator3TimestampActivity(View view) {
        startActivity(new Intent(this, Category6Operator3TimestampActivity.class));
    }

    /**
     * 6.4 serialize
     * @param view
     */
    public void jumpToCategory6Operator4SerializeActivity(View view) {
        startActivity(new Intent(this, Category6Operator4SerializeActivity.class));
    }

    /**
     * 6.5 observeOn
     * @param view
     */
    public void jumpToCategory6Operator5ObserveOnActivity(View view) {
        startActivity(new Intent(this, Category6Operator5ObserveOnActivity.class));
    }

    /**
     * 6.6 subscribe
     * @param view
     */
    public void jumpToCategory6Operator6SubscribeActivity(View view) {
        startActivity(new Intent(this, Category6Operator6SubscribeActivity.class));
    }

    /**
     * 6.7 subscribeOn
     * @param view
     */
    public void jumpToCategory6Operator7SubscribeOnActivity(View view) {
        startActivity(new Intent(this, Category6Operator7SubscribeOnActivity.class));
    }

    /**
     * 6.8 delay
     * @param view
     */
    public void jumpToCategory6Operator8DelayActivity(View view) {
        startActivity(new Intent(this, Category6Operator8DelayActivity.class));
    }

    /**
     * 6.9 timeInterval
     * @param view
     */
    public void jumpToCategory6Operator9TimeIntervalActivity(View view) {
        startActivity(new Intent(this, Category6Operator9TimeIntervalActivity.class));
    }

    /**
     * 6.10 timeout
     * @param view
     */
    public void jumpToCategory6Operator10TimeoutActivity(View view) {
        startActivity(new Intent(this, Category6Operator10TimeoutActivity.class));
    }

    /**
     * 6.11 using
     * @param view
     */
    public void jumpToCategory6Operator11UsingActivity(View view) {
        startActivity(new Intent(this, Category6Operator11UsingActivity.class));
    }

    /**
     * 6.11 do
     * @param view
     */
    public void jumpToCategory6Operator12DoActivity(View view) {
        startActivity(new Intent(this, Category6Operator12DoActivity.class));
    }
}
