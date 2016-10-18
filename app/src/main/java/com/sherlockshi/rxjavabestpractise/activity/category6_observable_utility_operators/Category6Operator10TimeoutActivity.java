package com.sherlockshi.rxjavabestpractise.activity.category6_observable_utility_operators;

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
 * Date:   2016-10-18 21:41
 * Description:
 */
public class Category6Operator10TimeoutActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "timeout";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category6_observable_utility_operators_10_timeout_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.f10_timeout;
    }

    @Override
    protected int setImageHeight() {
        return 170;
    }

    @Override
    protected void runSampleCode() {
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i = 1; i < 4; i++) {
                    try {
                        Thread.sleep(100 * i);
                    } catch (InterruptedException e) {
                        subscriber.onError(e);
                    }
                    subscriber.onNext(i);
                }
                subscriber.onCompleted();
            }
        })
                .timeout(250, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.newThread())
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
        return "Observable.create(new Observable.OnSubscribe<Integer>() {\n" +
                "    @Override\n" +
                "    public void call(Subscriber<? super Integer> subscriber) {\n" +
                "        for (int i = 1; i < 4; i++) {\n" +
                "            try {\n" +
                "                Thread.sleep(100 * i);\n" +
                "            } catch (InterruptedException e) {\n" +
                "                subscriber.onError(e);\n" +
                "            }\n" +
                "            subscriber.onNext(i);\n" +
                "        }\n" +
                "        subscriber.onCompleted();\n" +
                "    }\n" +
                "})\n" +
                "        .timeout(250, TimeUnit.MILLISECONDS)\n" +
                "        .subscribeOn(Schedulers.newThread())\n" +
                "        .subscribe(new Subscriber<Integer>() {\n" +
                "            @Override\n" +
                "            public void onCompleted() {\n" +
                "                System.out.println(\"onCompleted.\");\n" +
                "            }\n" +
                "\n" +
                "            @Override\n" +
                "            public void onError(Throwable e) {\n" +
                "                System.out.println(\"onError: \" + e.getMessage());\n" +
                "            }\n" +
                "\n" +
                "            @Override\n" +
                "            public void onNext(Integer integer) {\n" +
                "                System.out.println(\"onNext: \" + integer);\n" +
                "            }\n" +
                "        });";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext: 1");
        output.add("\nonNext: 2");
        output.add("\nonError: null");

        return output;
    }
}
