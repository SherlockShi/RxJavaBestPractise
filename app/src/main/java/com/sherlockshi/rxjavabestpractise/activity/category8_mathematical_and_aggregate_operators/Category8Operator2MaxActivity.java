package com.sherlockshi.rxjavabestpractise.activity.category8_mathematical_and_aggregate_operators;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.observables.MathObservable;

/**
 * Author: SherlockShi
 * Date:   2016-10-19 13:50
 * Description:
 */
public class Category8Operator2MaxActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "max";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category8_mathematical_and_aggregate_operators_2_max_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.h2_max;
    }

    @Override
    protected int setImageHeight() {
        return 170;
    }

    @Override
    protected void runSampleCode() {
        MathObservable.max(Observable.just(10, 6, 23, 9))
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted.");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext: " + integer);
                    }
                });
    }

    @Override
    protected String getSampleCode() {
        return "MathObservable.max(Observable.just(10, 6, 23, 9))\n" +
                "    .subscribe(new Subscriber<Integer>() {\n" +
                "        @Override\n" +
                "        public void onCompleted() {\n" +
                "            System.out.println(\"onCompleted.\");\n" +
                "        }\n" +
                "\n" +
                "        @Override\n" +
                "        public void onError(Throwable e) {\n" +
                "            System.out.println(\"onError: \" + e.getMessage());\n" +
                "        }\n" +
                "\n" +
                "        @Override\n" +
                "        public void onNext(Integer integer) {\n" +
                "            System.out.println(\"onNext: \" + integer);\n" +
                "        }\n" +
                "    });";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext: 23");
        output.add("\nonCompleted.");

        return output;
    }
}
