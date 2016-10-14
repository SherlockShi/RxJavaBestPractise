package com.sherlockshi.rxjavabestpractise.activity.category2_transforming_observables;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * Author: SherlockShi
 * Date:   2016-10-14 14:49
 * Description:
 */
public class Category2Operator6WindowActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "window";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category2_transforming_observables_6_window_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.b6_window;
    }

    @Override
    protected int setImageHeight() {
        return 220;
    }

    @Override
    protected void runSampleCode() {
        // 完整流程版
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8)
                .window(3)
                .subscribe(new Subscriber<Observable<Integer>>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted.");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Observable<Integer> integerObservable) {
                        integerObservable.subscribe(new Subscriber<Integer>() {
                            @Override
                            public void onCompleted() {
                                System.out.println("onCompleted(inner).");
                            }

                            @Override
                            public void onError(Throwable e) {
                                System.out.println("onError(inner): " + e.getMessage());
                            }

                            @Override
                            public void onNext(Integer integer) {
                                System.out.println("onNext: " + integer);
                            }
                        });
                    }
                });

        // 简化版
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8)
                .window(3)
                .subscribe(new Action1<Observable<Integer>>() {
                    @Override
                    public void call(Observable<Integer> integerObservable) {
                        System.out.println("start");

                        integerObservable.subscribe(new Action1<Integer>() {
                            @Override
                            public void call(Integer integer) {
                                System.out.println("onNext: " + integer);
                            }
                        });
                    }
                });
    }

    @Override
    protected String getSampleCode() {
        return "// 完整流程版\n" +
                "Observable.just(1, 2, 3, 4, 5, 6, 7, 8)\n" +
                "        .window(3)\n" +
                "        .subscribe(new Subscriber<Observable<Integer>>() {\n" +
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
                "            public void onNext(Observable<Integer> integerObservable) {\n" +
                "                integerObservable.subscribe(new Subscriber<Integer>() {\n" +
                "                    @Override\n" +
                "                    public void onCompleted() {\n" +
                "                        System.out.println(\"onCompleted(inner).\");\n" +
                "                    }\n" +
                "\n" +
                "                    @Override\n" +
                "                    public void onError(Throwable e) {\n" +
                "                        System.out.println(\"onError(inner): \" + e.getMessage());\n" +
                "                    }\n" +
                "\n" +
                "                    @Override\n" +
                "                    public void onNext(Integer integer) {\n" +
                "                        System.out.println(\"onNext: \" + integer);\n" +
                "                    }\n" +
                "                });\n" +
                "            }\n" +
                "        });\n" +
                "\n" +
                "// 简化版\n" +
                "Observable.just(1, 2, 3, 4, 5, 6, 7, 8)\n" +
                "        .window(3)\n" +
                "        .subscribe(new Action1<Observable<Integer>>() {\n" +
                "            @Override\n" +
                "            public void call(Observable<Integer> integerObservable) {\n" +
                "                System.out.println(\"start\");\n" +
                "                \n" +
                "                integerObservable.subscribe(new Action1<Integer>() {\n" +
                "                    @Override\n" +
                "                    public void call(Integer integer) {\n" +
                "                        System.out.println(\"onNext: \" + integer);\n" +
                "                    }\n" +
                "                });\n" +
                "            }\n" +
                "        });";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("(完整流程版:)");
        output.add("\nonNext: 1");
        output.add("\nonNext: 2");
        output.add("\nonNext: 3");
        output.add("\nonCompleted(inner).");
        output.add("\nonNext: 4");
        output.add("\nonNext: 5");
        output.add("\nonNext: 6");
        output.add("\nonCompleted(inner).");
        output.add("\nonNext: 7");
        output.add("\nonNext: 8");
        output.add("\nonCompleted(inner).");
        output.add("\nonCompleted.");
        output.add("\n");

        output.add("\n(简化版:)");
        output.add("\nstart");
        output.add("\nonNext: 1");
        output.add("\nonNext: 2");
        output.add("\nonNext: 3");
        output.add("\nstart");
        output.add("\nonNext: 4");
        output.add("\nonNext: 5");
        output.add("\nonNext: 6");
        output.add("\nstart");
        output.add("\nonNext: 7");
        output.add("\nonNext: 8");

        return output;
    }
}
