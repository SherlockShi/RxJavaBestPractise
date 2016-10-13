package com.sherlockshi.rxjavabestpractise.activity.category1_creating_observables;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Author: SherlockShi
 * Date:   2016-09-23 17:24
 * Description:
 */
public class Category1Operator4FromActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "from";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category1_creating_observables_4_from_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.a4_from;
    }

    @Override
    protected int setImageHeight() {
        return 180;
    }

    @Override
    protected void runSampleCode() {
        Integer[] items = { 0, 1, 2, 3, 4, 5 };

        Observable.from(items)
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
                    public void onNext(Integer i) {
                        System.out.println("onNext: " + i);
                    }
                });
    }

    @Override
    protected String getSampleCode() {
        return "Integer[] items = { 0, 1, 2, 3, 4, 5 };\n" +
                "\n" +
                "Observable.from(items)\n" +
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
                "        public void onNext(Integer i) {\n" +
                "            System.out.println(\"onNext: \" + i);\n" +
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
        output.add("\nonCompleted.");

        return output;
    }
}
