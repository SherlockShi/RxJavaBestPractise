package com.sherlockshi.rxjavabestpractise.activity.category3_filtering_observables;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Author: SherlockShi
 * Date:   2016-10-15 20:42
 * Description:
 */
public class Category3Operator10DebounceActivity extends BaseOperatorSampleActivity {

    private Subscriber subscriber;

    @Override
    protected String getOperatorName() {
        return "debounce";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category3_filtering_observables_10_debounce_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.c10_debounce;
    }

    @Override
    protected int setImageHeight() {
        return 200;
    }

    @Override
    protected void runSampleCode() {
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                if(subscriber.isUnsubscribed()) return;
                try {
                    //产生结果的间隔时间分别为100、200、300...900毫秒
                    for (int i = 1; i < 10; i++) {
                        subscriber.onNext(i);
                        Thread.sleep(i * 100);
                    }
                    subscriber.onCompleted();
                }catch(Exception e){
                    subscriber.onError(e);
                }
            }
        })
                .subscribeOn(Schedulers.newThread())
                .debounce(400, TimeUnit.MILLISECONDS)  //超时时间为400毫秒
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


//        Observable observable = Observable.interval(1000, TimeUnit.MILLISECONDS)
//                .debounce(900, TimeUnit.MILLISECONDS);
//
//        subscriber = new Subscriber<Long>() {
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
//                    public void onNext(Long aLong) {
//                        System.out.println("onNext: " + aLong);
//                    }
//                };
//
//        observable.subscribe(subscriber);
    }

    @Override
    protected String getSampleCode() {
        return "Observable.create(new Observable.OnSubscribe<Integer>() {\n" +
                "    @Override\n" +
                "    public void call(Subscriber<? super Integer> subscriber) {\n" +
                "        if(subscriber.isUnsubscribed()) return;\n" +
                "        try {\n" +
                "            //产生结果的间隔时间分别为100、200、300...900毫秒\n" +
                "            for (int i = 1; i < 10; i++) {\n" +
                "                subscriber.onNext(i);\n" +
                "                Thread.sleep(i * 100);\n" +
                "            }\n" +
                "            subscriber.onCompleted();\n" +
                "        }catch(Exception e){\n" +
                "            subscriber.onError(e);\n" +
                "        }\n" +
                "    }\n" +
                "})\n" +
                "        .subscribeOn(Schedulers.newThread())\n" +
                "        .debounce(400, TimeUnit.MILLISECONDS)  //超时时间为400毫秒\n" +
                "        .subscribe(new Subscriber<Integer>() {\n" +
                "            @Override\n" +
                "            public void onCompleted() {\n" +
                "                System.out.println(\"onCompleted.\");\n" +
                "            }\n" +
                "\n" +
                "            @Override\n" +
                "            public void onError(Throwable e) {\n" +
                "                System.out.println(\"onError:\" + e.getMessage());\n" +
                "            }\n" +
                "\n" +
                "            @Override\n" +
                "            public void onNext(Integer integer) {\n" +
                "                System.out.println(\"onNext:\" + integer);\n" +
                "            }\n" +
                "        });";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext: 5");
        output.add("\nonNext: 6");
        output.add("\nonNext: 7");
        output.add("\nonNext: 8");
        output.add("\nonNext: 9");
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
