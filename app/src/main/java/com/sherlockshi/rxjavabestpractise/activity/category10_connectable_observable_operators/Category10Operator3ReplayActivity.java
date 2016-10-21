package com.sherlockshi.rxjavabestpractise.activity.category10_connectable_observable_operators;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.observables.ConnectableObservable;

/**
 * Author: SherlockShi
 * Date:   2016-10-20 22:45
 * Description:
 */
public class Category10Operator3ReplayActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "replay";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category10_connectable_observable_operators_3_replay_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.j3_replay;
    }

    @Override
    protected int setImageHeight() {
        return 240;
    }

    @Override
    protected void runSampleCode() {
        final ConnectableObservable observable = Observable.range(1, 6).replay();

        final Subscriber subscriber2 = new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted2.");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError2: " + e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext2: " + integer);
            }
        };

        Subscriber subscriber1 = new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted1.");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError1: " + e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                if (integer == 3) {
                    observable.subscribe(subscriber2);
                }
                System.out.println("onNext1: " + integer);
            }
        };

        observable.subscribe(subscriber1);

        observable.connect();
    }

    @Override
    protected String getSampleCode() {
        return "final ConnectableObservable observable = Observable.range(1, 6).replay();\n" +
                "\n" +
                "final Subscriber subscriber2 = new Subscriber<Integer>() {\n" +
                "    @Override\n" +
                "    public void onCompleted() {\n" +
                "        System.out.println(\"onCompleted2.\");\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void onError(Throwable e) {\n" +
                "        System.out.println(\"onError2: \" + e.getMessage());\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void onNext(Integer integer) {\n" +
                "        System.out.println(\"onNext2: \" + integer);\n" +
                "    }\n" +
                "};\n" +
                "\n" +
                "Subscriber subscriber1 = new Subscriber<Integer>() {\n" +
                "    @Override\n" +
                "    public void onCompleted() {\n" +
                "        System.out.println(\"onCompleted1.\");\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void onError(Throwable e) {\n" +
                "        System.out.println(\"onError1: \" + e.getMessage());\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void onNext(Integer integer) {\n" +
                "        if (integer == 3) {\n" +
                "            observable.subscribe(subscriber2);\n" +
                "        }\n" +
                "        System.out.println(\"onNext1: \" + integer);\n" +
                "    }\n" +
                "};\n" +
                "\n" +
                "observable.subscribe(subscriber1);\n" +
                "\n" +
                "observable.connect();";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext1: 1");
        output.add("\nonNext1: 2");
        output.add("\nonNext2: 1");
        output.add("\nonNext2: 2");
        output.add("\nonNext2: 3");
        output.add("\nonNext1: 3");
        output.add("\nonNext1: 4");
        output.add("\nonNext2: 4");
        output.add("\nonNext1: 5");
        output.add("\nonNext2: 5");
        output.add("\nonNext1: 6");
        output.add("\nonNext2: 6");
        output.add("\nonCompleted1.");
        output.add("\nonCompleted2.");

        return output;
    }
}
