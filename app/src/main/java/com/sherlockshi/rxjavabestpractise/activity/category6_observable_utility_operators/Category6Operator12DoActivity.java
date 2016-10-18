package com.sherlockshi.rxjavabestpractise.activity.category6_observable_utility_operators;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Notification;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * Author: SherlockShi
 * Date:   2016-10-18 22:49
 * Description:
 */
public class Category6Operator12DoActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "doOnEach";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category6_observable_utility_operators_12_do_on_each_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.f12_do;
    }

    @Override
    protected int setImageHeight() {
        return 170;
    }

    @Override
    protected void runSampleCode() {
        Observable.just(1, 2, 3)
                .doOnEach(new Action1<Notification<? super Integer>>() {
                    @Override
                    public void call(Notification<? super Integer> notification) {
                        if (notification.getKind() == Notification.Kind.OnNext
                                && (Integer) notification.getValue() == 2) {
                            throw new RuntimeException("The value is 2!");
                        }
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
        return "Observable.just(1, 2, 3)\n" +
                "        .doOnEach(new Action1<Notification<? super Integer>>() {\n" +
                "            @Override\n" +
                "            public void call(Notification<? super Integer> notification) {\n" +
                "                if (notification.getKind() == Notification.Kind.OnNext\n" +
                "                        && (Integer) notification.getValue() == 2) {\n" +
                "                    throw new RuntimeException(\"The value is 2!\");\n" +
                "                }\n" +
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
        output.add("onNext: 1");
        output.add("\nonError: The value is 2!");

        return output;
    }
}
