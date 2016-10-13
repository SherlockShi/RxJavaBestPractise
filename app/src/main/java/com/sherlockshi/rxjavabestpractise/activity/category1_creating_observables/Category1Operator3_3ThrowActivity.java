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
public class Category1Operator3_3ThrowActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "error";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category1_creating_observables_33_throw_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.a3_3_throw;
    }

    @Override
    protected void runSampleCode() {
        Observable.error(new Throwable("something must be wrong!"))
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
        return "Observable.error(new Throwable(\"something must be wrong!\"))\n" +
                "                .subscribe(new Subscriber<Object>() {\n" +
                "                    @Override\n" +
                "                    public void onCompleted() {\n" +
                "                        System.out.println(\"onCompleted.\");\n" +
                "                    }\n" +
                "\n" +
                "                    @Override\n" +
                "                    public void onError(Throwable e) {\n" +
                "                        System.out.println(\"onError: \" + e.getMessage());\n" +
                "                    }\n" +
                "\n" +
                "                    @Override\n" +
                "                    public void onNext(Object o) {\n" +
                "                        System.out.println(\"onNext: \" + o);\n" +
                "                    }\n" +
                "                });";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onError: something must be wrong!");

        return output;
    }
}
