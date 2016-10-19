package com.sherlockshi.rxjavabestpractise.activity.category7_conditional_and_boolean_operators;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Author: SherlockShi
 * Date:   2016-10-19 10:40
 * Description:
 */
public class Category7Operator6TakeWhileActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "takeWhile";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category7_conditional_and_boolean_operators_6_take_while_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.g6_take_while;
    }

    @Override
    protected int setImageHeight() {
        return 170;
    }

    @Override
    protected void runSampleCode() {
        Observable.just(1, 2, 3, 4, 5)
                .takeWhile(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        return integer != 3;
                    }
                })
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
        return "Observable.just(1, 2, 3, 4, 5)\n" +
                "    .takeWhile(new Func1<Integer, Boolean>() {\n" +
                "        @Override\n" +
                "        public Boolean call(Integer integer) {\n" +
                "            return integer != 3;\n" +
                "        }\n" +
                "    })\n" +
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
        output.add("\nonCompleted.");

        return output;
    }
}
