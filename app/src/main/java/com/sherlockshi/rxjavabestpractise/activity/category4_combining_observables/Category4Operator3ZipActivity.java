package com.sherlockshi.rxjavabestpractise.activity.category4_combining_observables;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func2;

/**
 * Author: SherlockShi
 * Date:   2016-10-16 11:25
 * Description:
 */
public class Category4Operator3ZipActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "zip";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category4_combining_observables_3_zip_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.d3_zip;
    }

    @Override
    protected int setImageHeight() {
        return 230;
    }

    @Override
    protected void runSampleCode() {
        Observable just11 = Observable.just("A", "B");
        Observable just21 = Observable.just(1, 2, 3);

        Observable.zip(just11, just21, new Func2<String, Integer, String>() {
            @Override
            public String call(String string, Integer integer) {
                return string + integer;
            }
        })
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted.");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("onNext: " + s);
                    }
                });
    }

    @Override
    protected String getSampleCode() {
        return "Observable just11 = Observable.just(\"A\", \"B\");\n" +
                "Observable just21 = Observable.just(1, 2, 3);\n" +
                "\n" +
                "Observable.zip(just11, just21, new Func2<String, Integer, String>() {\n" +
                "    @Override\n" +
                "    public String call(String string, Integer integer) {\n" +
                "        return string + integer;\n" +
                "    }\n" +
                "})\n" +
                "        .subscribe(new Subscriber<String>() {\n" +
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
                "            public void onNext(String s) {\n" +
                "                System.out.println(\"onNext: \" + s);\n" +
                "            }\n" +
                "        });";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext: A1");
        output.add("\nonNext: B2");
        output.add("\nonCompleted.");

        return output;
    }
}
