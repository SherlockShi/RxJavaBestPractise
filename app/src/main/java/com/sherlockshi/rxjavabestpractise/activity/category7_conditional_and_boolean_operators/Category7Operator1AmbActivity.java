package com.sherlockshi.rxjavabestpractise.activity.category7_conditional_and_boolean_operators;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;

/**
 * Author: SherlockShi
 * Date:   2016-10-19 09:06
 * Description:
 */
public class Category7Operator1AmbActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "amb";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category7_conditional_and_boolean_operators_1_amb_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.g1_amb;
    }

    @Override
    protected int setImageHeight() {
        return 180;
    }

    @Override
    protected void runSampleCode() {
        Observable just1 = Observable.just(1, 2, 3).delay(1000, TimeUnit.MILLISECONDS);
        Observable just2 = Observable.just(11, 12, 13).delay(800, TimeUnit.MILLISECONDS);

        Observable.amb(just1, just2)
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
        return "Observable just1 = Observable.just(1, 2, 3).delay(1000, TimeUnit.MILLISECONDS);\n" +
                "Observable just2 = Observable.just(11, 12, 13).delay(800, TimeUnit.MILLISECONDS);\n" +
                "\n" +
                "Observable.amb(just1, just2)\n" +
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
        output.add("onNext: 11");
        output.add("\nonNext: 12");
        output.add("\nonNext: 13");
        output.add("\nonCompleted.");

        return output;
    }
}
