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
 * Date:   2016-10-19 16:43
 * Description:
 */
public class Category9Operator1OnBackpressureBufferActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "onBackpressureBuffer";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category9_backpressure_operators_1_on_backpressure_buffer_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.i1_on_backpressure_buffer;
    }

    @Override
    protected int setImageHeight() {
        return 180;
    }

    @Override
    protected void runSampleCode() {
        Observable.interval(1, TimeUnit.MILLISECONDS)
                .onBackpressureBuffer(1000)
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
                "    .onBackpressureBuffer(1000)\n" +
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
        output.add("\nonNext: 3");
        output.add("\nonNext: 4");
        output.add("\nonNext: 5");
        output.add("\nonNext: 6");
        output.add("\nonNext: 7");
        output.add("\nonNext: 8");
        output.add("\nonNext: 9");
        output.add("\nonNext: 10");
        output.add("\nonError: Overflowed buffer of 1000");

        return output;
    }
}
