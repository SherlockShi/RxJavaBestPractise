package com.sherlockshi.rxjavabestpractise.activity.category6_observable_utility_operators;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;

/**
 * Author: SherlockShi
 * Date:   2016-10-18 21:04
 * Description:
 */
public class Category6Operator8DelayActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "delay";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category6_observable_utility_operators_8_delay_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.f8_delay;
    }

    @Override
    protected int setImageHeight() {
        return 170;
    }

    @Override
    protected void runSampleCode() {
        Observable.just(1, 2, 3)
                .delay(2000, TimeUnit.MILLISECONDS)
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
        return "Observable.just(1, 2, 3)\n" +
                "    .delay(2000, TimeUnit.MILLISECONDS)\n" +
                "    .subscribe(new Subscriber<Integer>() {\n" +
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
                "        public void onNext(Integer integer) {\n" +
                "            System.out.println(\"onNext: \" + integer);\n" +
                "        }\n" +
                "    });";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext: 1");
        output.add("\nonNext: 2");
        output.add("\nonNext: 3");
        output.add("\nonCompleted.");

        return output;
    }
}
