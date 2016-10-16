package com.sherlockshi.rxjavabestpractise.activity.category3_filtering_observables;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;

/**
 * Author: SherlockShi
 * Date:   2016-10-15 19:31
 * Description:
 */
public class Category3Operator9SampleActivity extends BaseOperatorSampleActivity {

    private Subscriber subscriber;

    @Override
    protected String getOperatorName() {
        return "sample";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category3_filtering_observables_9_sample_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.c9_sample;
    }

    @Override
    protected int setImageHeight() {
        return 200;
    }

    @Override
    protected void runSampleCode() {
        Observable observable = Observable.interval(1000, TimeUnit.MILLISECONDS)
                .sample(2200, TimeUnit.MILLISECONDS);

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
                "    Observable observable = Observable.interval(1000, TimeUnit.MILLISECONDS)\n" +
                "            .sample(2200, TimeUnit.MILLISECONDS);\n" +
                "\n" +
                "    subscriber = new Subscriber<Long>() {\n" +
                "                @Override\n" +
                "                public void onCompleted() {\n" +
                "                    System.out.println(\"onCompleted.\");\n" +
                "                }\n" +
                "\n" +
                "                @Override\n" +
                "                public void onError(Throwable e) {\n" +
                "                    System.out.println(\"onError: \" + e.getMessage());\n" +
                "                }\n" +
                "\n" +
                "                @Override\n" +
                "                public void onNext(Long aLong) {\n" +
                "                    System.out.println(\"onNext: \" + aLong);\n" +
                "                }\n" +
                "            };\n" +
                "\n" +
                "    observable.subscribe(subscriber);\n" +
                "}\n" +
                "\n" +
                "protected void onDestroy() {\n" +
                "    super.onDestroy();\n" +
                "\n" +
                "    if (subscriber != null\n" +
                "            && !subscriber.isUnsubscribed()) {\n" +
                "        subscriber.unsubscribe();\n" +
                "    }\n" +
                "}";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext: 1");
        output.add("\nonNext: 3");
        output.add("\nonNext: 5");
        output.add("\nonNext: 7");
        output.add("\nonNext: 9");
        output.add("\nonNext: 12");
        output.add("\n(...)");

        return output;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (subscriber != null
                && !subscriber.isUnsubscribed()) {
            subscriber.unsubscribe();
        }
    }
}
