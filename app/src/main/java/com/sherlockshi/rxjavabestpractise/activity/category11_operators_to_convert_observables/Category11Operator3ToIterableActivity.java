package com.sherlockshi.rxjavabestpractise.activity.category11_operators_to_convert_observables;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * Author: SherlockShi
 * Date:   2016-10-23 22:06
 * Description:
 */
public class Category11Operator3ToIterableActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "toIterable";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category11_operators_to_convert_observables_3_to_iterable_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.k3_to_iterable;
    }

    @Override
    protected int setImageHeight() {
        return 200;
    }

    @Override
    protected void runSampleCode() {
        Iterable<Integer> iterable = Observable.just(1,2, 3, 4).toBlocking().toIterable();

        for (Integer i : iterable) {
            System.out.println("Data: " + i);
        }
    }

    @Override
    protected String getSampleCode() {
        return "Iterable<Integer> iterable = Observable.just(1,2, 3, 4).toBlocking().toIterable();\n" +
                "\n" +
                "for (Integer i : iterable) {\n" +
                "    System.out.println(\"Data: \" + i);\n" +
                "}";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("Data: 1");
        output.add("\nData: 2");
        output.add("\nData: 3");
        output.add("\nData: 4");

        return output;
    }
}
