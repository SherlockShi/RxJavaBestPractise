package com.sherlockshi.rxjavabestpractise.activity.category6_observable_utility_operators;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Notification;
import rx.Observable;
import rx.Subscriber;

/**
 * Author: SherlockShi
 * Date:   2016-10-17 17:17
 * Description:
 */
public class Category6Operator1MaterializeActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "materialize";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category6_observable_utility_operators_1_materialize_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.f1_materialize;
    }

    @Override
    protected int setImageHeight() {
        return 180;
    }

    @Override
    protected void runSampleCode() {
        Observable.just(1, 2, 3, 4)
                .materialize()
                .subscribe(new Subscriber<Notification<Integer>>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted.");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Notification<Integer> integerNotification) {
                        System.out.println("onNext: Type=" + integerNotification.getKind() + ", Value=" + integerNotification.getValue());
                    }
                });
    }

    @Override
    protected String getSampleCode() {
        return "Observable.just(1, 2, 3, 4)\n" +
                "        .materialize()\n" +
                "        .subscribe(new Subscriber<Notification<Integer>>() {\n" +
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
                "            public void onNext(Notification<Integer> integerNotification) {\n" +
                "                System.out.println(\"onNext: Type=\" + integerNotification.getKind() + \", Value=\" + integerNotification.getValue());\n" +
                "            }\n" +
                "        });";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext: Type=OnNext, Value=1");
        output.add("\nonNext: Type=OnNext, Value=2");
        output.add("\nonNext: Type=OnNext, Value=3");
        output.add("\nonNext: Type=OnNext, Value=4");
        output.add("\nonNext: Type=OnCompleted, Value=null");
        output.add("\nonCompleted.");

        return output;
    }
}
