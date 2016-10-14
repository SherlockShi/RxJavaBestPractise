package com.sherlockshi.rxjavabestpractise.activity.category2_transforming_observables;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.observables.GroupedObservable;

/**
 * Author: SherlockShi
 * Date:   2016-10-14 14:24
 * Description:
 */
public class Category2Operator4GroupByActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "groupBy";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category2_transforming_observables_4_groupby_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.b4_groupby;
    }

    @Override
    protected int setImageHeight() {
        return 200;
    }

    @Override
    protected void runSampleCode() {
        // 完整流程版
        Observable.just(1, 2, 3, 4, 5)
                .groupBy(new Func1<Integer, Integer>() {
                    @Override
                    public Integer call(Integer integer) {
                        return integer % 3;
                    }
                })
                .subscribe(new Subscriber<GroupedObservable<Integer, Integer>>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted.");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(final GroupedObservable<Integer, Integer> result) {
                        result.subscribe(new Subscriber<Integer>() {
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
                                System.out.println("onNext: Key=" + result.getKey() + ", Value=" + integer);
                            }
                        });
                    }
                });

        // 简化版
        Observable.just(1, 2, 3, 4, 5)
                .groupBy(new Func1<Integer, Integer>() {
                    @Override
                    public Integer call(Integer integer) {
                        return integer % 3;
                    }
                })
                .subscribe(new Action1<GroupedObservable<Integer, Integer>>() {
                    @Override
                    public void call(final GroupedObservable<Integer, Integer> result) {
                        result.subscribe(new Action1<Integer>() {
                            @Override
                            public void call(Integer integer) {
                                System.out.println("Key=" + result.getKey() + ", Value=" + integer);
                            }
                        });
                    }
                });
    }

    @Override
    protected String getSampleCode() {
        return "// 完整流程版\n" +
                "Observable.just(1, 2, 3, 4, 5)\n" +
                "        .groupBy(new Func1<Integer, Integer>() {\n" +
                "            @Override\n" +
                "            public Integer call(Integer integer) {\n" +
                "                return integer % 3;\n" +
                "            }\n" +
                "        })\n" +
                "        .subscribe(new Subscriber<GroupedObservable<Integer, Integer>>() {\n" +
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
                "            public void onNext(final GroupedObservable<Integer, Integer> result) {\n" +
                "                result.subscribe(new Subscriber<Integer>() {\n" +
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
                "                        System.out.println(\"onNext: Key=\" + result.getKey() + \", Value=\" + integer);\n" +
                "                    }\n" +
                "                });\n" +
                "            }\n" +
                "        });\n" +
                "\n" +
                "// 简化版\n" +
                "Observable.just(1, 2, 3, 4, 5)\n" +
                "        .groupBy(new Func1<Integer, Integer>() {\n" +
                "            @Override\n" +
                "            public Integer call(Integer integer) {\n" +
                "                return integer % 3;\n" +
                "            }\n" +
                "        })\n" +
                "        .subscribe(new Action1<GroupedObservable<Integer, Integer>>() {\n" +
                "            @Override\n" +
                "            public void call(final GroupedObservable<Integer, Integer> result) {\n" +
                "                result.subscribe(new Action1<Integer>() {\n" +
                "                    @Override\n" +
                "                    public void call(Integer integer) {\n" +
                "                        System.out.println(\"Key=\" + result.getKey() + \", Value=\" + integer);\n" +
                "                    }\n" +
                "                });\n" +
                "            }\n" +
                "        });";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("(完整流程版:)");
        output.add("\nonNext: Key=1, Value=1");
        output.add("\nonNext: Key=2, Value=2");
        output.add("\nonNext: Key=0, Value=3");
        output.add("\nonNext: Key=1, Value=4");
        output.add("\nonNext: Key=2, Value=5");
        output.add("\nonCompleted(inner).");
        output.add("\nonCompleted(inner).");
        output.add("\nonCompleted(inner).");
        output.add("\nonCompleted.");
        output.add("\n");

        output.add("\n(简化版:)");
        output.add("\nKey=1, Value=1");
        output.add("\nKey=2, Value=2");
        output.add("\nKey=0, Value=3");
        output.add("\nKey=1, Value=4");
        output.add("\nKey=2, Value=5");

        return output;
    }
}
