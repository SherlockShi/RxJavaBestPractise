package com.sherlockshi.rxjavabestpractise.activity.category4_combining_observables;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Author: SherlockShi
 * Date:   2016-10-16 21:49
 * Description:
 */
public class Category4Operator7SwitchActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "switchOnNext";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category4_combining_observables_7_switch_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.d7_switch;
    }

    @Override
    protected int setImageHeight() {
        return 220;
    }

    private Observable<String> createObserver(final int index) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                for (int i = 1; i < 5; i++) {
                    subscriber.onNext(index + "-" + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).subscribeOn(Schedulers.newThread());
    }

    @Override
    protected void runSampleCode() {
        Observable.switchOnNext(Observable.create(
                new Observable.OnSubscribe<Observable<String>>() {
                    @Override
                    public void call(Subscriber<? super Observable<String>> subscriber) {
                        for (int i = 1; i < 3; i++) {
                            subscriber.onNext(createObserver(i));
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        ))
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted.");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("onNext: " + s);
                    }
                });
    }

    @Override
    protected String getSampleCode() {
        return "private Observable<String> createObserver(final int index) {\n" +
                "    return Observable.create(new Observable.OnSubscribe<String>() {\n" +
                "        @Override\n" +
                "        public void call(Subscriber<? super String> subscriber) {\n" +
                "            for (int i = 1; i < 5; i++) {\n" +
                "                subscriber.onNext(index + \"-\" + i);\n" +
                "                try {\n" +
                "                    Thread.sleep(1000);\n" +
                "                } catch (InterruptedException e) {\n" +
                "                    e.printStackTrace();\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    }).subscribeOn(Schedulers.newThread());\n" +
                "}\n" +
                "\n" +
                "@Override\n" +
                "protected void runSampleCode() {\n" +
                "    Observable.switchOnNext(Observable.create(\n" +
                "            new Observable.OnSubscribe<Observable<String>>() {\n" +
                "                @Override\n" +
                "                public void call(Subscriber<? super Observable<String>> subscriber) {\n" +
                "                    for (int i = 1; i < 3; i++) {\n" +
                "                        subscriber.onNext(createObserver(i));\n" +
                "                        try {\n" +
                "                            Thread.sleep(2000);\n" +
                "                        } catch (InterruptedException e) {\n" +
                "                            e.printStackTrace();\n" +
                "                        }\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "    ))\n" +
                "            .subscribe(new Subscriber<String>() {\n" +
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
                "                public void onNext(String s) {\n" +
                "                    System.out.println(\"onNext: \" + s);\n" +
                "                }\n" +
                "            });\n" +
                "}";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext: 1-1");
        output.add("\nonNext: 1-2");
        output.add("\nonNext: 2-1");
        output.add("\nonNext: 2-2");
        output.add("\nonNext: 2-3");
        output.add("\nonNext: 2-4");

        return output;
    }
}
