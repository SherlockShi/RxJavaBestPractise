package com.sherlockshi.rxjavabestpractise.activity.category1_creating_observables;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.functions.Func0;
import rx.util.async.Async;

/**
 * Author: SherlockShi
 * Date:   2016-10-13 16:28
 * Description:
 */
public class Category1Operator9StartActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "start";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category1_creating_observables_9_start_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.a9_start;
    }

    @Override
    protected int setImageHeight() {
        return 160;
    }

    @Override
    protected void runSampleCode() {
        Async.start(new Func0<Integer>() {
            @Override
            public Integer call() {
                try {
                    Thread.sleep(5 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return 16;
            }
        }).subscribe(new Subscriber<Integer>() {
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
        return "Async.start(new Func0<Integer>() {\n" +
                "    @Override\n" +
                "    public Integer call() {\n" +
                "        try {\n" +
                "            Thread.sleep(5 * 1000);\n" +
                "        } catch (InterruptedException e) {\n" +
                "            e.printStackTrace();\n" +
                "        }\n" +
                "\n" +
                "        return 16;\n" +
                "    }\n" +
                "}).subscribe(new Subscriber<Integer>() {\n" +
                "    @Override\n" +
                "    public void onCompleted() {\n" +
                "        System.out.println(\"onCompleted.\");\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void onError(Throwable e) {\n" +
                "        System.out.println(\"onError: \" + e.getMessage());\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void onNext(Integer integer) {\n" +
                "        System.out.println(\"onNext: \" + integer);\n" +
                "    }\n" +
                "});";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext: 16");
        output.add("\nonCompleted.");

        return output;
    }
}
