package com.sherlockshi.rxjavabestpractise.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.sherlockshi.rxjavabestpractise.BaseActivity;
import com.sherlockshi.rxjavabestpractise.R;

/**
 * Author: SherlockShi
 * Date:   2016-09-16 20:21
 * Description:
 */
public class Category1CreatingObservablesActivity extends BaseActivity {

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
        startActivity(new Intent(Category1CreatingObservablesActivity.this, Category1Operator1CreateActivity.class));
    }
}
