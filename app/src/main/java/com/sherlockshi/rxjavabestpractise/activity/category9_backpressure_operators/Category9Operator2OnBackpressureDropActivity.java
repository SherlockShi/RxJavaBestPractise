package com.sherlockshi.rxjavabestpractise.activity.category9_backpressure_operators;

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
 * Date:   2016-10-19 17:08
 * Description:
 */
public class Category9Operator2OnBackpressureDropActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "onBackpressureDrop";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category9_backpressure_operators_2_on_backpressure_drop_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.i2_on_backpressure_drop;
    }

    @Override
    protected int setImageHeight() {
        return 140;
    }

    @Override
    protected void runSampleCode() {
        Observable.interval(1, TimeUnit.MILLISECONDS)
                .onBackpressureDrop()
                .observeOn(Schedulers.newThread())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted.");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Long aLong) {
                        System.out.println("onNext: " + aLong);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    protected String getSampleCode() {
        return "Observable.interval(1, TimeUnit.MILLISECONDS)\n" +
                "    .onBackpressureDrop()\n" +
                "    .observeOn(Schedulers.newThread())\n" +
                "    .subscribe(new Subscriber<Long>() {\n" +
                "        @Override\n" +
                "        public void onCompleted() {\n" +
                "            System.out.println(\"onCompleted.\");\n" +
                "        }\n" +
                "\n" +
                "        @Override\n" +
                "        public void onError(Throwable e) {\n" +
                "            System.out.println(\"onError: \" + e.getMessage());\n" +
                "        }\n" +
                "\n" +
                "        @Override\n" +
                "        public void onNext(Long aLong) {\n" +
                "            System.out.println(\"onNext: \" + aLong);\n" +
                "            try {\n" +
                "                Thread.sleep(100);\n" +
                "            } catch (InterruptedException e) {\n" +
                "                e.printStackTrace();\n" +
                "            }\n" +
                "        }\n" +
                "    });";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext: 0");
        output.add("\nonNext: 1");
        output.add("\nonNext: 2");
        output.add("\n...");
        output.add("\nonNext: 15");
        output.add("\nonNext: 1608");
        output.add("\nonNext: 1609");
        output.add("\n...");
        output.add("\nonNext: 1623");
        output.add("\n...");

        return output;
    }
}
