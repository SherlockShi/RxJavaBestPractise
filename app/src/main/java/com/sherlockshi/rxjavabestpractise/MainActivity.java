package com.sherlockshi.rxjavabestpractise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sherlockshi.rxjavabestpractise.activity.Category10ConnectableObservableOperatorsActivity;
import com.sherlockshi.rxjavabestpractise.activity.Category11OperatorsToConvertObservablesActivity;
import com.sherlockshi.rxjavabestpractise.activity.Category1CreatingObservablesActivity;
import com.sherlockshi.rxjavabestpractise.activity.Category2TransformingObservablesActivity;
import com.sherlockshi.rxjavabestpractise.activity.Category3FilteringObservablesActivity;
import com.sherlockshi.rxjavabestpractise.activity.Category4CombiningObservablesActivity;
import com.sherlockshi.rxjavabestpractise.activity.Category5ErrorHandlingOperatorsActivity;
import com.sherlockshi.rxjavabestpractise.activity.Category6ObservableUtilityOperatorsActivity;
import com.sherlockshi.rxjavabestpractise.activity.Category7ConditionalAndBooleanOperatorsActivity;
import com.sherlockshi.rxjavabestpractise.activity.Category8MathematicalAndAggregateOperatorsActivity;
import com.sherlockshi.rxjavabestpractise.activity.Category9BackpressureOperatorsActivity;

public class MainActivity extends BaseActivity {

    protected static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    /**
     * 1. 创建操作(Creating Observables)
     * @param view
     */
    public void jumpToCreatingObservablesActivity(View view) {
        startActivity(new Intent(MainActivity.this, Category1CreatingObservablesActivity.class));
    }

    /**
     * 2. 变换操作(Transforming Observables)
     * @param view
     */
    public void jumpToTransformingObservablesActivity(View view) {
        startActivity(new Intent(MainActivity.this, Category2TransformingObservablesActivity.class));
    }

    /**
     * 3. 过滤操作(Filtering Observables)
     * @param view
     */
    public void jumpToFilteringObservablesActivity(View view) {
        startActivity(new Intent(MainActivity.this, Category3FilteringObservablesActivity.class));
    }

    /**
     * 4. 组合操作(Combining Observables)
     * @param view
     */
    public void jumpToCombiningObservablesActivity(View view) {
        startActivity(new Intent(MainActivity.this, Category4CombiningObservablesActivity.class));
    }

    /**
     * 5. 错误处理(Error Handling Operators)
     * @param view
     */
    public void jumpToErrorHandlingOperatorsActivity(View view) {
        startActivity(new Intent(MainActivity.this, Category5ErrorHandlingOperatorsActivity.class));
    }

    /**
     * 6. 辅助操作(Observable Utility Operators)
     * @param view
     */
    public void jumpToObservableUtilityOperatorsActivity(View view) {
        startActivity(new Intent(MainActivity.this, Category6ObservableUtilityOperatorsActivity.class));
    }

    /**
     * 7. 条件和布尔操作\n(Conditional and Boolean Operators)
     * @param view
     */
    public void jumpToConditionalAndBooleanOperatorsActivity(View view) {
        startActivity(new Intent(MainActivity.this, Category7ConditionalAndBooleanOperatorsActivity.class));
    }

    /**
     * 8. 算术和聚合操作(Mathematical and Aggregate Operators)
     * @param view
     */
    public void jumpToMathematicalAndAggregateOperatorsActivity(View view) {
        startActivity(new Intent(MainActivity.this, Category8MathematicalAndAggregateOperatorsActivity.class));
    }

    /**
     * 9. (Backpressure Operators)
     * @param view
     */
    public void jumpToBackpressureOperatorsActivity(View view) {
        startActivity(new Intent(MainActivity.this, Category9BackpressureOperatorsActivity.class));
    }

    /**
     * 10. 连接操作(Connectable Observable Operators)
     * @param view
     */
    public void jumpToConnectableObservableOperatorsActivity(View view) {
        startActivity(new Intent(MainActivity.this, Category10ConnectableObservableOperatorsActivity.class));
    }

    /**
     * 11. 转换操作(Operators to Convert Observables)
     * @param view
     */
    public void jumpToOperatorsToConvertObservablesActivity(View view) {
        startActivity(new Intent(MainActivity.this, Category11OperatorsToConvertObservablesActivity.class));
    }
}
