package com.sherlockshi.rxjavabestpractise.activity.category10_connectable_observable_operators;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.observables.ConnectableObservable;

/**
 * Author: SherlockShi
 * Date:   2016-10-21 14:48
 * Description:
 */
public class Category10Operator4RefCountActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "refCount";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category10_connectable_observable_operators_4_ref_count_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.j4_fef_count;
    }

    @Override
    protected int setImageHeight() {
        return 240;
    }

    @Override
    protected void runSampleCode() {
        System.out.println("<========before refCount()=======>");

        ConnectableObservable connectableObservable = Observable.range(1, 50000).sample(10, TimeUnit.MILLISECONDS).publish();

        connectableObservable.subscribe(new Subscriber<Integer>() {
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
                System.out.println("onNext1: " + integer);
            }
        });

        connectableObservable.subscribe(new Subscriber<Integer>() {
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
        });

        connectableObservable.connect();

        System.out.println("<========after refCount()=======>");

        Observable observable = connectableObservable.refCount();

        observable.subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted3.");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError3: " + e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext3: " + integer);
            }
        });

        observable.subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted4.");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError4: " + e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext4: " + integer);
            }
        });
    }

    @Override
    protected String getSampleCode() {
        return "System.out.println(\"<========before refCount()=======>\");\n" +
                "\n" +
                "ConnectableObservable connectableObservable = Observable.range(1, 50000).sample(10, TimeUnit.MILLISECONDS).publish();\n" +
                "\n" +
                "connectableObservable.subscribe(new Subscriber<Integer>() {\n" +
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
                "        System.out.println(\"onNext1: \" + integer);\n" +
                "    }\n" +
                "});\n" +
                "\n" +
                "connectableObservable.subscribe(new Subscriber<Integer>() {\n" +
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
                "});\n" +
                "\n" +
                "connectableObservable.connect();\n" +
                "\n" +
                "System.out.println(\"<========after refCount()=======>\");\n" +
                "\n" +
                "Observable observable = connectableObservable.refCount();\n" +
                "\n" +
                "observable.subscribe(new Subscriber<Integer>() {\n" +
                "    @Override\n" +
                "    public void onCompleted() {\n" +
                "        System.out.println(\"onCompleted3.\");\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void onError(Throwable e) {\n" +
                "        System.out.println(\"onError3: \" + e.getMessage());\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void onNext(Integer integer) {\n" +
                "        System.out.println(\"onNext3: \" + integer);\n" +
                "    }\n" +
                "});\n" +
                "\n" +
                "observable.subscribe(new Subscriber<Integer>() {\n" +
                "    @Override\n" +
                "    public void onCompleted() {\n" +
                "        System.out.println(\"onCompleted4.\");\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void onError(Throwable e) {\n" +
                "        System.out.println(\"onError4: \" + e.getMessage());\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void onNext(Integer integer) {\n" +
                "        System.out.println(\"onNext4: \" + integer);\n" +
                "    }\n" +
                "});";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("<========before refCount()=======>");
        output.add("\nonNext1: 11653");
        output.add("\nonNext2: 11653");
        output.add("\nonNext1: 21317");
        output.add("\nonNext2: 21317");
        output.add("\nonNext1: 32731");
        output.add("\nonNext2: 32731");
        output.add("\nonNext1: 40808");
        output.add("\nonNext2: 40808");
        output.add("\nonCompleted1.");
        output.add("\nonCompleted2.");
        output.add("\n<========after refCount()=======>");
        output.add("\nonNext3: 15517");
        output.add("\nonNext3: 30592");
        output.add("\nonNext3: 45208");
        output.add("\nonCompleted3.");
        output.add("\nonNext4: 16052");
        output.add("\nonNext4: 16090");
        output.add("\nonNext4: 20936");
        output.add("\nonNext4: 31274");
        output.add("\nonNext4: 47841");
        output.add("\nonCompleted4.");

        return output;
    }
}
