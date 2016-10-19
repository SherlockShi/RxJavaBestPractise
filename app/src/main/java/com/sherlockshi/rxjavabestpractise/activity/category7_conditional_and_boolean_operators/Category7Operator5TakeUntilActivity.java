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
 * Date:   2016-10-19 10:32
 * Description:
 */
public class Category7Operator5TakeUntilActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "takeUntil";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category7_conditional_and_boolean_operators_5_take_until_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.g5_take_until;
    }

    @Override
    protected int setImageHeight() {
        return 200;
    }

    @Override
    protected void runSampleCode() {
        Observable observable1 = Observable.interval(1000, TimeUnit.MILLISECONDS).take(5);
        Observable observable2 = Observable.just(1, 2).delay(2500, TimeUnit.MILLISECONDS);

        observable1.takeUntil(observable2)
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted.");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Long aLong) {
                        System.out.println("onNext: " + aLong);
                    }
                });
    }

    @Override
    protected String getSampleCode() {
        return "Observable observable1 = Observable.interval(1000, TimeUnit.MILLISECONDS).take(5);\n" +
                "Observable observable2 = Observable.just(1, 2).delay(2500, TimeUnit.MILLISECONDS);\n" +
                "\n" +
                "observable1.takeUntil(observable2)\n" +
                "    .subscribe(new Subscriber<Long>() {\n" +
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
                "        public void onNext(Long aLong) {\n" +
                "            System.out.println(\"onNext: \" + aLong);\n" +
                "        }\n" +
                "    });";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext: 0");
        output.add("\nonNext: 1");
        output.add("\nonCompleted.");

        return output;
    }
}
