package com.sherlockshi.rxjavabestpractise.activity.category4_combining_observables;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func2;
import rx.joins.Pattern2;
import rx.joins.Plan0;
import rx.observables.JoinObservable;

/**
 * Author: SherlockShi
 * Date:   2016-10-16 13:44
 * Description:
 */
public class Category4Operator4AndThenWhenActivity extends BaseOperatorSampleActivity {

    @Override
    protected String[] getOperatorNames() {
        return new String[]{"and", "then", "when"};
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category4_combining_observables_4_and_then_when_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.d4_and_then_when;
    }

    @Override
    protected int setImageHeight() {
        return 300;
    }

    @Override
    protected void runSampleCode() {
        Observable just1 = Observable.just("A", "B");
        Observable just2 = Observable.just(1, 2, 3);

        Pattern2<String, Integer> pattern = JoinObservable.from(just1).and(just2);
        Plan0 plan = pattern.then(new Func2<String, Integer, String>() {
            @Override
            public String call(String s, Integer integer) {
                return s + integer;
            }
        });

        JoinObservable.when(plan)
                .toObservable()
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
        return "Observable just1 = Observable.just(\"A\", \"B\");\n" +
                "Observable just2 = Observable.just(1, 2, 3);\n" +
                "\n" +
                "Pattern2<String, Integer> pattern = JoinObservable.from(just1).and(just2);\n" +
                "Plan0 plan = pattern.then(new Func2<String, Integer, String>() {\n" +
                "    @Override\n" +
                "    public String call(String s, Integer integer) {\n" +
                "        return s + integer;\n" +
                "    }\n" +
                "});\n" +
                "\n" +
                "JoinObservable.when(plan)\n" +
                "        .toObservable()\n" +
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
