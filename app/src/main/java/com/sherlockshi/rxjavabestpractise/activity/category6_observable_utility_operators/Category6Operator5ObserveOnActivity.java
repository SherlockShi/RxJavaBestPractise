package com.sherlockshi.rxjavabestpractise.activity.category6_observable_utility_operators;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Author: SherlockShi
 * Date:   2016-10-18 09:00
 * Description:
 */
public class Category6Operator5ObserveOnActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "observeOn";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category6_observable_utility_operators_5_observe_on_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.f5_observe_on;
    }

    @Override
    protected int setImageHeight() {
        return 170;
    }

    @Override
    protected void runSampleCode() {
        System.out.println("ThreadName: " + Thread.currentThread().getName());

        Observable.just(1, 2)
                .map(new Func1<Integer, Integer>() {
                    @Override
                    public Integer call(Integer integer) {
                        System.out.println("ThreadName(just): " + Thread.currentThread().getName());
                        return integer;
                    }
                })
//                .subscribeOn(Schedulers.newThread())
//                .map(new Func1<Integer, Integer>() {
//                    @Override
//                    public Integer call(Integer integer) {
//                        System.out.println("ThreadName(subscribeOn): " + Thread.currentThread().getName());
//                        return integer;
//                    }
//                })
                .observeOn(Schedulers.newThread())
                .map(new Func1<Integer, Integer>() {
                    @Override
                    public Integer call(Integer integer) {
                        System.out.println("ThreadName(observeOn): " + Thread.currentThread().getName());
                        return integer;
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
        return "System.out.println(\"ThreadName: \" + Thread.currentThread().getName());\n" +
                "\n" +
                "Observable.just(1, 2)\n" +
                "        .map(new Func1<Integer, Integer>() {\n" +
                "            @Override\n" +
                "            public Integer call(Integer integer) {\n" +
                "                System.out.println(\"ThreadName(just): \" + Thread.currentThread().getName());\n" +
                "                return integer;\n" +
                "            }\n" +
                "        })\n" +
                "//                .subscribeOn(Schedulers.newThread())\n" +
                "//                .map(new Func1<Integer, Integer>() {\n" +
                "//                    @Override\n" +
                "//                    public Integer call(Integer integer) {\n" +
                "//                        System.out.println(\"ThreadName(subscribeOn): \" + Thread.currentThread().getName());\n" +
                "//                        return integer;\n" +
                "//                    }\n" +
                "//                })\n" +
                "        .observeOn(Schedulers.newThread())\n" +
                "        .map(new Func1<Integer, Integer>() {\n" +
                "            @Override\n" +
                "            public Integer call(Integer integer) {\n" +
                "                System.out.println(\"ThreadName(observeOn): \" + Thread.currentThread().getName());\n" +
                "                return integer;\n" +
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
        output.add("ThreadName: main");
        output.add("\nThreadName(just): main");
        output.add("\nThreadName(just): main");
        output.add("\nThreadName(observeOn): RxNewThreadScheduler-3");
        output.add("\nonNext: 1");
        output.add("\nThreadName(observeOn): RxNewThreadScheduler-3");
        output.add("\nonNext: 2");
        output.add("\nonCompleted.");

        return output;
    }
}
