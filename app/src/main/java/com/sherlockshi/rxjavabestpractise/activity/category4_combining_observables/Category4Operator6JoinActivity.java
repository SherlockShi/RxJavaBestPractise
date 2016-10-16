package com.sherlockshi.rxjavabestpractise.activity.category4_combining_observables;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

/**
 * Author: SherlockShi
 * Date:   2016-10-16 17:48
 * Description:
 */
public class Category4Operator6JoinActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "join";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category4_combining_observables_6_join_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.d6_join;
    }

    @Override
    protected int setImageHeight() {
        return 220;
    }

    @Override
    protected void runSampleCode() {
//        Observable interval1 = Observable.interval(600, TimeUnit.MILLISECONDS, Schedulers.newThread());
//        Observable interval2 = Observable.interval(1000, TimeUnit.MILLISECONDS, Schedulers.newThread());
//
//        interval1.join(interval2,
//                new Func1<Long, Observable<Long>>() {
//                    @Override
//                    public Observable<Long> call(Long aLong) {
//                        return Observable.timer(550, TimeUnit.MILLISECONDS);
//                    }
//                },
//                new Func1<Long, Observable<Long>>() {
//                    @Override
//                    public Observable<Long> call(Long aLong) {
//                        return Observable.timer(950, TimeUnit.MILLISECONDS);
//                    }
//                },
//                new Func2<Long, Long, String>() {
//                    @Override
//                    public String call(Long aLong1, Long aLong2) {
//                        return aLong1 + "-" + aLong2;
//                    }
//                })
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

        Observable create1 = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i = 0; i < 6; i++) {
                    subscriber.onNext(i);

                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException e) {
                        subscriber.onError(e);
                    }
                }
            }
        }).subscribeOn(Schedulers.newThread());

        Observable create2 = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i = 0; i < 4; i++) {
                    subscriber.onNext(i);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        subscriber.onError(e);
                    }
                }
            }
        }).subscribeOn(Schedulers.newThread());

        create1.join(create2,
                new Func1<Integer, Observable<Long>>() {
                    @Override
                    public Observable<Long> call(Integer integer) {
                        return Observable.timer(1000, TimeUnit.MILLISECONDS);
                    }
                },
                new Func1<Integer, Observable<Long>>() {
                    @Override
                    public Observable<Long> call(Integer integer) {
                        return Observable.timer(1000, TimeUnit.MILLISECONDS);
                    }
                },
                new Func2<Integer, Integer, String>() {
                    @Override
                    public String call(Integer integer1, Integer integer2) {
                        return integer1 + "-" + integer2;
                    }
                })
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

//        Observable just1 = Observable.just(1, 2, 3, 4);
//        Observable just2 = Observable.just(1, 2, 3, 4);
//
//        just1.join(just2,
//                new Func1<Integer, Observable<Long>>() {
//                    @Override
//                    public Observable<Long> call(Integer integer) {
//                        return Observable.timer(1, TimeUnit.SECONDS);
//                    }
//                },
//                new Func1<Integer, Observable<Long>>() {
//                    @Override
//                    public Observable<Long> call(Integer integer) {
//                        return Observable.timer(1, TimeUnit.SECONDS);
//                    }
//                },
//                new Func2<Integer, Integer, String>() {
//                    @Override
//                    public String call(Integer integer1, Integer integer2) {
//                        return integer1 + "-" + integer2;
//                    }
//                })
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
                "        for (int i = 0; i < 6; i++) {\n" +
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
                "Observable create2 = Observable.create(new Observable.OnSubscribe<Integer>() {\n" +
                "    @Override\n" +
                "    public void call(Subscriber<? super Integer> subscriber) {\n" +
                "        for (int i = 0; i < 4; i++) {\n" +
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
                "create1.join(create2,\n" +
                "        new Func1<Integer, Observable<Long>>() {\n" +
                "            @Override\n" +
                "            public Observable<Long> call(Integer integer) {\n" +
                "                return Observable.timer(1000, TimeUnit.MILLISECONDS);\n" +
                "            }\n" +
                "        },\n" +
                "        new Func1<Integer, Observable<Long>>() {\n" +
                "            @Override\n" +
                "            public Observable<Long> call(Integer integer) {\n" +
                "                return Observable.timer(1000, TimeUnit.MILLISECONDS);\n" +
                "            }\n" +
                "        },\n" +
                "        new Func2<Integer, Integer, String>() {\n" +
                "            @Override\n" +
                "            public String call(Integer integer1, Integer integer2) {\n" +
                "                return integer1 + \"-\" + integer2;\n" +
                "            }\n" +
                "        })\n" +
                "        .subscribe(new Subscriber<String>() {\n" +
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
                "            public void onNext(String s) {\n" +
                "                System.out.println(\"onNext: \" + s);\n" +
                "            }\n" +
                "        });";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext: 0-0");
        output.add("\nonNext: 1-0");
        output.add("\nonNext: 1-1");
        output.add("\nonNext: 2-1");
        output.add("\nonNext: 3-1");
        output.add("\nonNext: 3-2");
        output.add("\nonNext: 2-2");
        output.add("\nonNext: 4-2");
        output.add("\nonNext: 4-3");
        output.add("\nonNext: 5-3");

        return output;
    }
}
