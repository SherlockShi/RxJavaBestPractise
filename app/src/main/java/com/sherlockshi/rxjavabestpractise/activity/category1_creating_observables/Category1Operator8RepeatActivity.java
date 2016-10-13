package com.sherlockshi.rxjavabestpractise.activity.category1_creating_observables;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Author: SherlockShi
 * Date:   2016-10-12 23:28
 * Description:
 */
public class Category1Operator8RepeatActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "repeat";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category1_creating_observables_8_repeat_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.a8_repeat;
    }

    @Override
    protected int setImageHeight() {
        return 180;
    }

    @Override
    protected void runSampleCode() {
        Observable.range(2, 3)
                .repeat(2)
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
        return "Observable.range(2, 3)\n" +
                "        .repeat(2)\n" +
                "        .subscribe(new Subscriber<Integer>() {\n" +
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
                "            public void onNext(Integer integer) {\n" +
                "                System.out.println(\"onNext: \" + integer);\n" +
                "            }\n" +
                "        });";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext: 2");
        output.add("\nonNext: 3");
        output.add("\nonNext: 4");
        output.add("\nonNext: 2");
        output.add("\nonNext: 3");
        output.add("\nonNext: 4");
        output.add("\nonCompleted.");

        return output;
    }
}
