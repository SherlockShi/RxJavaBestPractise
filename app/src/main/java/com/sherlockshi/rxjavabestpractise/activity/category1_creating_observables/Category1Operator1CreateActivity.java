package com.sherlockshi.rxjavabestpractise.activity.category1_creating_observables;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Author: SherlockShi
 * Date:   2016-09-17 21:41
 * Description:
 */
public class Category1Operator1CreateActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "create";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category1_creating_observables_1_create_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.a1_create;
    }

    @Override
    protected void runSampleCode() {
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> observer) {
                try {
                    if (!observer.isUnsubscribed()) {
                        for (int i = 0; i < 4; i++) {
                            observer.onNext(i);
                        }
                        observer.onCompleted();
                    }
                } catch (Exception e) {
                    observer.onError(e);
                }
            }
        }).subscribe(new Subscriber<Integer>() {
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
                "            @Override\n" +
                "            public void call(Subscriber<? super Integer> observer) {\n" +
                "                try {\n" +
                "                    if (!observer.isUnsubscribed()) {\n" +
                "                        for (int i = 0; i < 4; i++) {\n" +
                "                            observer.onNext(i);\n" +
                "                        }\n" +
                "                        observer.onCompleted();\n" +
                "                    }\n" +
                "                } catch (Exception e) {\n" +
                "                    observer.onError(e);\n" +
                "                }\n" +
                "            }\n" +
                "        }).subscribe(new Subscriber<Integer>() {\n" +
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
        output.add("\nonCompleted.");

        return output;
    }
}
