package com.sherlockshi.rxjavabestpractise.activity.category8_mathematical_and_aggregate_operators;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Author: SherlockShi
 * Date:   2016-10-19 15:11
 * Description:
 */
public class Category8Operator5ConcatActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "concat";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category8_mathematical_and_aggregate_operators_5_concat_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.h5_concat;
    }

    @Override
    protected int setImageHeight() {
        return 220;
    }

    @Override
    protected void runSampleCode() {
        Observable observable1 = Observable.interval(1000,
                TimeUnit.MILLISECONDS,
                Schedulers.newThread()).take(2);
        Observable observable2 = Observable.interval(500, 1000,
                TimeUnit.MILLISECONDS,
                Schedulers.newThread()).take(2);

        Observable.concat(observable1, observable2)
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
        return "Observable observable1 = Observable.interval(1000, \n" +
                "        TimeUnit.MILLISECONDS, \n" +
                "        Schedulers.newThread()).take(2);\n" +
                "Observable observable2 = Observable.interval(500, 1000, \n" +
                "        TimeUnit.MILLISECONDS, \n" +
                "        Schedulers.newThread()).take(2);\n" +
                "\n" +
                "Observable.concat(observable1, observable2)\n" +
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
        output.add("\nonNext: 0");
        output.add("\nonNext: 1");
        output.add("\nonCompleted.");

        return output;
    }
}
