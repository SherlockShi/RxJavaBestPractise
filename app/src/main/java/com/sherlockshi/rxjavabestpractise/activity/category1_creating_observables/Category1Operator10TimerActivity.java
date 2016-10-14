package com.sherlockshi.rxjavabestpractise.activity.category1_creating_observables;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;

/**
 * Author: SherlockShi
 * Date:   2016-10-13 17:41
 * Description:
 */
public class Category1Operator10TimerActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "timer";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category1_creating_observables_10_timer_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.a10_timer;
    }

    @Override
    protected void runSampleCode() {
        Observable.timer(3, TimeUnit.SECONDS)
            .subscribe(new Subscriber<Long>() {
                @Override
                public void onCompleted() {
                    System.out.println("onCompleted.");
                }

                @Override
                public void onError(Throwable e) {
                    System.out.println("onError: " + e.getMessage());
                }

                @Override
                public void onNext(Long aLong) {
                    System.out.println("onNext: " + aLong);
                }
            });
    }

    @Override
    protected String getSampleCode() {
        return "Observable.timer(3, TimeUnit.SECONDS)\n" +
                "    .subscribe(new Subscriber<Long>() {\n" +
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
                "        public void onNext(Long aLong) {\n" +
                "            System.out.println(\"onNext: \" + aLong);\n" +
                "        }\n" +
                "    });";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext: 0");
        output.add("\nonCompleted.");

        return output;
    }
}
