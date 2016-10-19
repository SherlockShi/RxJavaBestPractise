package com.sherlockshi.rxjavabestpractise.activity.category7_conditional_and_boolean_operators;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;

/**
 * Author: SherlockShi
 * Date:   2016-10-19 11:05
 * Description:
 */
public class Category7Operator9SequenceEqualActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "sequenceEqual";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category7_conditional_and_boolean_operators_9_sequence_equal_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.g9_sequence_equal;
    }

    @Override
    protected int setImageHeight() {
        return 210;
    }

    @Override
    protected void runSampleCode() {
        Observable observable1 = Observable.just(1, 2, 3, 4).delay(1000, TimeUnit.MILLISECONDS);
        Observable observable2 = Observable.just(1, 2, 3, 4).delay(2000, TimeUnit.MILLISECONDS);

        Observable.sequenceEqual(observable1, observable2)
                .subscribe(new Subscriber<Boolean>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted.");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Boolean aBoolean) {
                        System.out.println("onNext: " + aBoolean);
                    }
                });
    }

    @Override
    protected String getSampleCode() {
        return "Observable observable1 = Observable.just(1, 2, 3, 4).delay(1000, TimeUnit.MILLISECONDS);\n" +
                "Observable observable2 = Observable.just(1, 2, 3, 4).delay(2000, TimeUnit.MILLISECONDS);\n" +
                "\n" +
                "Observable.sequenceEqual(observable1, observable2)\n" +
                "    .subscribe(new Subscriber<Boolean>() {\n" +
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
                "        public void onNext(Boolean aBoolean) {\n" +
                "            System.out.println(\"onNext: \" + aBoolean);\n" +
                "        }\n" +
                "    });";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext: true");
        output.add("\nonCompleted.");

        return output;
    }
}
