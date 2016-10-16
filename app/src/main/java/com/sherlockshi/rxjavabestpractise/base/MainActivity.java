package com.sherlockshi.rxjavabestpractise.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.activity.category10_connectable_observable_operators.Category10_ConnectableObservableOperatorsActivity;
import com.sherlockshi.rxjavabestpractise.activity.category11_operators_to_convert_observables.Category11_OperatorsToConvertObservablesActivity;
import com.sherlockshi.rxjavabestpractise.activity.category1_creating_observables.Category1_CreatingObservablesActivity;
import com.sherlockshi.rxjavabestpractise.activity.category2_transforming_observables.Category2_TransformingObservablesActivity;
import com.sherlockshi.rxjavabestpractise.activity.category3_filtering_observables.Category3_FilteringObservablesActivity;
import com.sherlockshi.rxjavabestpractise.activity.category4_combining_observables.Category4_CombiningObservablesActivity;
import com.sherlockshi.rxjavabestpractise.activity.category5_error_handling_operators.Category5_ErrorHandlingOperatorsActivity;
import com.sherlockshi.rxjavabestpractise.activity.category6_observable_utility_operators.Category6_ObservableUtilityOperatorsActivity;
import com.sherlockshi.rxjavabestpractise.activity.category7_conditional_and_boolean_operators.Category7_ConditionalAndBooleanOperatorsActivity;
import com.sherlockshi.rxjavabestpractise.activity.category8_mathematical_and_aggregate_operators.Category8_MathematicalAndAggregateOperatorsActivity;
import com.sherlockshi.rxjavabestpractise.activity.category9_backpressure_operators.Category9_BackpressureOperatorsActivity;

public class MainActivity extends BaseOperatorListActivity {

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
        startActivity(new Intent(MainActivity.this, Category1_CreatingObservablesActivity.class));
    }

    /**
     * 2. 变换操作(Transforming Observables)
     * @param view
     */
    public void jumpToTransformingObservablesActivity(View view) {
        startActivity(new Intent(MainActivity.this, Category2_TransformingObservablesActivity.class));
    }

    /**
     * 3. 过滤操作(Filtering Observables)
     * @param view
     */
    public void jumpToFilteringObservablesActivity(View view) {
        startActivity(new Intent(MainActivity.this, Category3_FilteringObservablesActivity.class));
    }

    /**
     * 4. 组合操作(Combining Observables)
     * @param view
     */
    public void jumpToCombiningObservablesActivity(View view) {
        startActivity(new Intent(MainActivity.this, Category4_CombiningObservablesActivity.class));
    }

    /**
     * 5. 错误处理(Error Handling Operators)
     * @param view
     */
    public void jumpToErrorHandlingOperatorsActivity(View view) {
        startActivity(new Intent(MainActivity.this, Category5_ErrorHandlingOperatorsActivity.class));
    }

    /**
     * 6. 辅助操作(Observable Utility Operators)
     * @param view
     */
    public void jumpToObservableUtilityOperatorsActivity(View view) {
        startActivity(new Intent(MainActivity.this, Category6_ObservableUtilityOperatorsActivity.class));
    }

    /**
     * 7. 条件和布尔操作\n(Conditional and Boolean Operators)
     * @param view
     */
    public void jumpToConditionalAndBooleanOperatorsActivity(View view) {
        startActivity(new Intent(MainActivity.this, Category7_ConditionalAndBooleanOperatorsActivity.class));
    }

    /**
     * 8. 算术和聚合操作(Mathematical and Aggregate Operators)
     * @param view
     */
    public void jumpToMathematicalAndAggregateOperatorsActivity(View view) {
        startActivity(new Intent(MainActivity.this, Category8_MathematicalAndAggregateOperatorsActivity.class));
    }

    /**
     * 9. (Backpressure Operators)
     * @param view
     */
    public void jumpToBackpressureOperatorsActivity(View view) {
        startActivity(new Intent(MainActivity.this, Category9_BackpressureOperatorsActivity.class));
    }

    /**
     * 10. 连接操作(Connectable Observable Operators)
     * @param view
     */
    public void jumpToConnectableObservableOperatorsActivity(View view) {
        startActivity(new Intent(MainActivity.this, Category10_ConnectableObservableOperatorsActivity.class));
    }

    /**
     * 11. 转换操作(Operators to Convert Observables)
     * @param view
     */
    public void jumpToOperatorsToConvertObservablesActivity(View view) {
        startActivity(new Intent(MainActivity.this, Category11_OperatorsToConvertObservablesActivity.class));
    }

    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime) > 2000){
                Toast.makeText(getApplicationContext(), getString(R.string.activity_main_press_again_to_quit), Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
