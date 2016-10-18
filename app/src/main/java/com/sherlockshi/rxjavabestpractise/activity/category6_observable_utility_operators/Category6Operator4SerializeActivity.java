package com.sherlockshi.rxjavabestpractise.activity.category6_observable_utility_operators;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;

/**
 * Author: SherlockShi
 * Date:   2016-10-17 22:39
 * Description:
 */
public class Category6Operator4SerializeActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "serialize";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category6_observable_utility_operators_4_serialize);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.f4_serialize;
    }

    @Override
    protected int setImageHeight() {
        return 220;
    }

    @Override
    protected void runSampleCode() {
        // 1.
//        Observable.create(new Observable.OnSubscribe<Integer>() {
//            @Override
//            public void call(Subscriber<? super Integer> subscriber) {
//                subscriber.onNext(1);
//                subscriber.onNext(2);
//                subscriber.onCompleted();
//                subscriber.onNext(3);
//                subscriber.onCompleted();
//            }
//        })
//                .doOnUnsubscribe(new Action0() {
//                    @Override
//                    public void call() {
//                        System.out.println("onUnsubscribe.");
//                    }
//                })
//                .subscribe(new Subscriber<Integer>() {
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
//                    public void onNext(Integer integer) {
//                        System.out.println("onNext: " + integer);
//                    }
//                });

        // 2.
//        Observable.create(new Observable.OnSubscribe<Integer>() {
//            @Override
//            public void call(Subscriber<? super Integer> subscriber) {
//                subscriber.onNext(1);
//                subscriber.onNext(2);
//                subscriber.onCompleted();
//                subscriber.onNext(3);
//                subscriber.onCompleted();
//            }
//        })
//                .doOnUnsubscribe(new Action0() {
//                    @Override
//                    public void call() {
//                        System.out.println("onUnsubscribe.");
//                    }
//                })
//                .unsafeSubscribe(new Subscriber<Integer>() {
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
//                    public void onNext(Integer integer) {
//                        System.out.println("onNext: " + integer);
//                    }
//                });

        // 3.
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                subscriber.onNext(1);
                subscriber.onNext(2);
                subscriber.onCompleted();
                subscriber.onNext(3);
                subscriber.onCompleted();
            }
        })
                .serialize()
                .doOnUnsubscribe(new Action0() {
                    @Override
                    public void call() {
                        System.out.println("onUnsubscribe.");
                    }
                })
                .unsafeSubscribe(new Subscriber<Integer>() {
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
        return "Observable.just(1, 2, 3)\n" +
                "        .timestamp()\n" +
                "        .subscribe(new Subscriber<Timestamped<Integer>>() {\n" +
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
                "            public void onNext(Timestamped<Integer> time) {\n" +
                "                String timestamp = new SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\")\n" +
                "                        .format(new Date(time.getTimestampMillis()));\n" +
                "                System.out.println(\"onNext: \" + time.getValue() + \"(\" + timestamp + \")\");\n" +
                "            }\n" +
                "        });";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext: 1(2016-10-17 22:05:04)");
        output.add("\nonNext: 2(2016-10-17 22:05:04)");
        output.add("\nonNext: 3(2016-10-17 22:05:04)");
        output.add("\nonCompleted.");

        return output;
    }
}
