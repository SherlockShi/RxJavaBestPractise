package com.sherlockshi.rxjavabestpractise.activity.category4_combining_observables;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Author: SherlockShi
 * Date:   2016-10-16 11:08
 * Description:
 */
public class Category4Operator2MergeActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "merge";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category4_combining_observables_2_merge_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.d2_merge;
    }

    @Override
    protected int setImageHeight() {
        return 240;
    }

    @Override
    protected void runSampleCode() {
        Observable just1 = Observable.just(1, 2);
        Observable just2 = Observable.just(6, 7, 8);

        Observable.merge(just1, just2)
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
        return "Observable just1 = Observable.just(1, 2);\n" +
                "Observable just2 = Observable.just(6, 7, 8);\n" +
                "\n" +
                "Observable.merge(just1, just2)\n" +
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
        output.add("onNext: 1");
        output.add("\nonNext: 2");
        output.add("\nonNext: 6");
        output.add("\nonNext: 7");
        output.add("\nonNext: 8");
        output.add("\nonCompleted.");

        return output;
    }
}
