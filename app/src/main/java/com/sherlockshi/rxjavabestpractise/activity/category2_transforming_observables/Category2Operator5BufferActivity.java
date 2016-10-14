package com.sherlockshi.rxjavabestpractise.activity.category2_transforming_observables;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Author: SherlockShi
 * Date:   2016-10-14 14:42
 * Description:
 */
public class Category2Operator5BufferActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "buffer";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category2_transforming_observables_5_buffer_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.b5_buffer;
    }

    @Override
    protected int setImageHeight() {
        return 170;
    }

    @Override
    protected void runSampleCode() {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8)
                .buffer(3, 2)
                .subscribe(new Subscriber<List<Integer>>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted.");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(List<Integer> integers) {
                        System.out.println("onNext: " + integers);
                    }
                });
    }

    @Override
    protected String getSampleCode() {
        return "Observable.just(1, 2, 3, 4, 5, 6, 7, 8)\n" +
                "        .buffer(3, 2)\n" +
                "        .subscribe(new Subscriber<List<Integer>>() {\n" +
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
                "            public void onNext(List<Integer> integers) {\n" +
                "                System.out.println(\"onNext: \" + integers);\n" +
                "            }\n" +
                "        });";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext: [1, 2, 3]");
        output.add("\nonNext: [3, 4, 5]");
        output.add("\nonNext: [5, 6, 7]");
        output.add("\nonNext: [7, 8]");
        output.add("\nonCompleted.");

        return output;
    }
}
