package com.sherlockshi.rxjavabestpractise.activity.category7_conditional_and_boolean_operators;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorListActivity;

/**
 * Author: SherlockShi
 * Date:   2016-09-19 09:00
 * Description:
 */
public class Category7_ConditionalAndBooleanOperatorsActivity extends BaseOperatorListActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_category7_conditional_and_boolean_operators);
    }

    /**
     * 7.1 amb
     * @param view
     */
    public void jumpToCategory7Operator1AmbActivity(View view) {
        startActivity(new Intent(this, Category7Operator1AmbActivity.class));
    }

    /**
     * 7.2 defaultIfEmpty
     * @param view
     */
    public void jumpToCategory7Operator2DefaultIfEmptyActivity(View view) {
        startActivity(new Intent(this, Category7Operator2DefaultIfEmptyActivity.class));
    }

    /**
     * 7.3 skipUntil
     * @param view
     */
    public void jumpToCategory7Operator3SkipUntilActivity(View view) {
        startActivity(new Intent(this, Category7Operator3SkipUntilActivity.class));
    }

    /**
     * 7.4 skipWhile
     * @param view
     */
    public void jumpToCategory7Operator4SkipWhileActivity(View view) {
        startActivity(new Intent(this, Category7Operator4SkipWhileActivity.class));
    }

    /**
     * 7.5 takeUntil
     * @param view
     */
    public void jumpToCategory7Operator5TakeUntilActivity(View view) {
        startActivity(new Intent(this, Category7Operator5TakeUntilActivity.class));
    }

    /**
     * 7.6 takeWhile
     * @param view
     */
    public void jumpToCategory7Operator6TakeWhileActivity(View view) {
        startActivity(new Intent(this, Category7Operator6TakeWhileActivity.class));
    }

    /**
     * 7.7 all
     * @param view
     */
    public void jumpToCategory7Operator7AllActivity(View view) {
        startActivity(new Intent(this, Category7Operator7AllActivity.class));
    }

    /**
     * 7.8 contains
     * @param view
     */
    public void jumpToCategory7Operator8ContainsActivity(View view) {
        startActivity(new Intent(this, Category7Operator8ContainsActivity.class));
    }

    /**
     * 7.9 sequenceEqual
     * @param view
     */
    public void jumpToCategory7Operator9SequenceEqualActivity(View view) {
        startActivity(new Intent(this, Category7Operator9SequenceEqualActivity.class));
    }
}
