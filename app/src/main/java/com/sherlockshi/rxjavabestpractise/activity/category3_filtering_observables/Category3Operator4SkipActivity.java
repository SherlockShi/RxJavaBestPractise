package com.sherlockshi.rxjavabestpractise.activity.category3_filtering_observables;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Author: SherlockShi
 * Date:   2016-10-15 11:11
 * Description:
 */
public class Category3Operator4SkipActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "skip";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category3_filtering_observables_4_skip_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.c4_skip;
    }

    @Override
    protected int setImageHeight() {
        return 200;
    }

    @Override
    protected void runSampleCode() {
        Observable.just(1, 2, 3, 4, 5, 6)
                .skip(3)
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
        return "Observable.just(1, 2, 3, 4, 5, 6)\n" +
                "        .skip(3)\n" +
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
        output.add("onNext: 4");
        output.add("\nonNext: 5");
        output.add("\nonNext: 6");
        output.add("\nonCompleted.");

        return output;
    }
}
