package com.sherlockshi.rxjavabestpractise.activity.category6_observable_utility_operators;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Author: SherlockShi
 * Date:   2016-10-17 17:47
 * Description:
 */
public class Category6Operator2DematerializeActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "dematerialize";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category6_observable_utility_operators_2_dematerialize_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.f2_dematerialize;
    }

    @Override
    protected int setImageHeight() {
        return 180;
    }

    @Override
    protected void runSampleCode() {
        Observable.just(1, 2, 3, 4)
                .materialize()
                .dematerialize()
                .subscribe(new Subscriber<Object>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted.");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Object o) {
                        System.out.println("onNext: " + o);
                    }
                });
    }

    @Override
    protected String getSampleCode() {
        return "Observable.just(1, 2, 3, 4)\n" +
                "        .materialize()\n" +
                "        .dematerialize()\n" +
                "        .subscribe(new Subscriber<Object>() {\n" +
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
                "            public void onNext(Object o) {\n" +
                "                System.out.println(\"onNext: \" + o);\n" +
                "            }\n" +
                "        });";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext: 1");
        output.add("\nonNext: 2");
        output.add("\nonNext: 3");
        output.add("\nonNext: 4");
        output.add("\nonCompleted.");

        return output;
    }
}
