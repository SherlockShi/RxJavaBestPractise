package com.sherlockshi.rxjavabestpractise.activity.category5_error_handling_operators;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Author: SherlockShi
 * Date:   2016-10-17 10:06
 * Description:
 */
public class Category5Operator1_1OnErrorReturnActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "onErrorReturn";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category5_error_handling_operators_1_1_on_error_return_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.e1_1_on_error_return;
    }

    @Override
    protected int setImageHeight() {
        return 220;
    }

    @Override
    protected void runSampleCode() {
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                if (subscriber.isUnsubscribed()) {
                    return;
                }

                for (int i = 0; i < 7; i++) {
                    if (i == 4) {
                        subscriber.onError(new Exception("Integer is 4!"));
                    } else {
                        subscriber.onNext(i);
                    }
                }
                subscriber.onCompleted();
            }
        })
                .onErrorReturn(new Func1<Throwable, Integer>() {
                    @Override
                    public Integer call(Throwable throwable) {
                        return 166;
                    }
                })
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
                "        if (subscriber.isUnsubscribed()) {\n" +
                "            return;\n" +
                "        }\n" +
                "\n" +
                "        for (int i = 0; i < 7; i++) {\n" +
                "            if (i == 4) {\n" +
                "                subscriber.onError(new Exception(\"Integer is 4!\"));\n" +
                "            } else {\n" +
                "                subscriber.onNext(i);\n" +
                "            }\n" +
                "        }\n" +
                "        subscriber.onCompleted();\n" +
                "    }\n" +
                "})\n" +
                "        .onErrorReturn(new Func1<Throwable, Integer>() {\n" +
                "            @Override\n" +
                "            public Integer call(Throwable throwable) {\n" +
                "                return 166;\n" +
                "            }\n" +
                "        })\n" +
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
        output.add("onNext: 0");
        output.add("\nonNext: 1");
        output.add("\nonNext: 2");
        output.add("\nonNext: 3");
        output.add("\nonNext: 166");
        output.add("\nonCompleted.");

        return output;
    }
}
