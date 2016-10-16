package com.sherlockshi.rxjavabestpractise.activity.category4_combining_observables;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

/**
 * Author: SherlockShi
 * Date:   2016-10-16 16:42
 * Description:
 */
public class Category4Operator5CombineLatestActivity extends BaseOperatorSampleActivity {

    private Subscriber subscriber;

    @Override
    protected String getOperatorName() {
        return "combineLatest";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category4_combining_observables_5_combine_latest_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.d5_combine_latest;
    }

    @Override
    protected int setImageHeight() {
        return 220;
    }

    @Override
    protected void runSampleCode() {
        Observable create1 = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i = 0; i < 3; i++) {
                    subscriber.onNext(i);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        subscriber.onError(e);
                    }
                }
            }
        }).subscribeOn(Schedulers.newThread());

        Observable create2 = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i = 0; i < 3; i++) {
                    subscriber.onNext(i);

                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException e) {
                        subscriber.onError(e);
                    }
                }
            }
        }).subscribeOn(Schedulers.newThread());

        subscriber = new Subscriber<String>() {
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
        };

        Observable.combineLatest(create1, create2, new Func2<Integer, Integer, String>() {
            @Override
            public String call(Integer integer1, Integer integer2) {
                return integer1 + "-" + integer2;
            }
        }).subscribe(subscriber);

        // 跟预期结果不一致
//        Observable interval1 = Observable.interval(1000, TimeUnit.MILLISECONDS, Schedulers.newThread());
//        Observable interval2 = Observable.interval(600, 600, TimeUnit.MILLISECONDS, Schedulers.newThread());
//
//        subscriber = new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//                System.out.println("onCompleted.");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                System.out.println("onError: " + e.getMessage());
//            }
//
//            @Override
//            public void onNext(String s) {
//                System.out.println("onNext: " + s);
//            }
//        };
//
//        Observable.combineLatest(interval1, interval2, new Func2<Long, Long, String>() {
//            @Override
//            public String call(Long aLong1, Long aLong2) {
//                return aLong1 + "-" + aLong2;
//            }
//        })
//                .subscribe(subscriber);

        // 缺少时间间隔,看不出效果
//        Observable just1 = Observable.just("A", "B", "C");
//        Observable just2 = Observable.just(1, 2, 3);
//
//        Observable.combineLatest(just1, just2, new Func2<String, Integer, String>() {
//            @Override
//            public String call(String s, Integer i) {
//                return s + i;
//            }
//        })
//                .subscribe(new Subscriber<String>() {
//                    @Override
//                    public void onCompleted() {
//                        System.out.println("onCompleted.");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println("onError: " + e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        System.out.println("onNext: " + s);
//                    }
//                });
    }

    @Override
    protected String getSampleCode() {
        return "Observable create1 = Observable.create(new Observable.OnSubscribe<Integer>() {\n" +
                "    @Override\n" +
                "    public void call(Subscriber<? super Integer> subscriber) {\n" +
                "        for (int i = 0; i < 3; i++) {\n" +
                "            subscriber.onNext(i);\n" +
                "\n" +
                "            try {\n" +
                "                Thread.sleep(1000);\n" +
                "            } catch (InterruptedException e) {\n" +
                "                subscriber.onError(e);\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}).subscribeOn(Schedulers.newThread());\n" +
                "\n" +
                "Observable create2 = Observable.create(new Observable.OnSubscribe<Integer>() {\n" +
                "    @Override\n" +
                "    public void call(Subscriber<? super Integer> subscriber) {\n" +
                "        for (int i = 0; i < 3; i++) {\n" +
                "            subscriber.onNext(i);\n" +
                "\n" +
                "            try {\n" +
                "                Thread.sleep(600);\n" +
                "            } catch (InterruptedException e) {\n" +
                "                subscriber.onError(e);\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}).subscribeOn(Schedulers.newThread());\n" +
                "\n" +
                "subscriber = new Subscriber<String>() {\n" +
                "    @Override\n" +
                "    public void onCompleted() {\n" +
                "        System.out.println(\"onCompleted.\");\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void onError(Throwable e) {\n" +
                "        System.out.println(\"onError: \" + e.getMessage());\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void onNext(String s) {\n" +
                "        System.out.println(\"onNext: \" + s);\n" +
                "    }\n" +
                "};\n" +
                "\n" +
                "Observable.combineLatest(create1, create2, new Func2<Integer, Integer, String>() {\n" +
                "    @Override\n" +
                "    public String call(Integer integer1, Integer integer2) {\n" +
                "        return integer1 + \"-\" + integer2;\n" +
                "    }\n" +
                "}).subscribe(subscriber);";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext: 0-0");
        output.add("\nonNext: 0-1");
        output.add("\nonNext: 1-1");
        output.add("\nonNext: 1-2");
        output.add("\nonNext: 2-2");
        output.add("\nonCompleted.");

        return output;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (subscriber != null
                && !subscriber.isUnsubscribed()) {
            subscriber.unsubscribe();
        }
    }
}
