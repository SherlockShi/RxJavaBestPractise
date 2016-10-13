package com.sherlockshi.rxjavabestpractise.activity.category1_creating_observables;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;

/**
 * Author: SherlockShi
 * Date:   2016-10-12 23:28
 * Description:
 */
public class Category1Operator5IntervalActivity extends BaseOperatorSampleActivity {

    private Subscriber subscriber;

    @Override
    protected String getOperatorName() {
        return "interval";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category1_creating_observables_5_interval_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.a5_interval;
    }

    @Override
    protected void runSampleCode() {
        Observable observable = Observable.interval(1000, TimeUnit.MILLISECONDS);

        subscriber = new Subscriber<Long>() {
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
        };

        observable.subscribe(subscriber);
    }

    @Override
    protected String getSampleCode() {
        return "protected void runSampleCode() {\n" +
                "    Observable observable = Observable.interval(1000, TimeUnit.MILLISECONDS);\n" +
                "\n" +
                "    subscriber = new Subscriber<Long>() {\n" +
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
                "    };\n" +
                "\n" +
                "    observable.subscribe(subscriber);\n" +
                "}\n" +
                "\n" +
                "    @Override\n" +
                "    protected void onDestroy() {\n" +
                "        super.onDestroy();\n" +
                "\n" +
                "        if (subscriber!= null \n" +
                "                && !subscriber.isUnsubscribed()) {\n" +
                "            subscriber.unsubscribe();\n" +
                "        }\n" +
                "    }";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext: 0");
        output.add("\nonNext: 1");
        output.add("\nonNext: 2");
        output.add("\nonNext: 3");
        output.add("\nonNext: 4");
        output.add("\nonNext: 5");
        output.add("\n(...)");

        return output;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (subscriber!= null
                && !subscriber.isUnsubscribed()) {
            subscriber.unsubscribe();
        }
    }
}
