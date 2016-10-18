package com.sherlockshi.rxjavabestpractise.activity.category6_observable_utility_operators;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Timestamped;

/**
 * Author: SherlockShi
 * Date:   2016-10-17 21:43
 * Description:
 */
public class Category6Operator3TimestampActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "timestamp";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category6_observable_utility_operators_3_timestamp_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.f3_timestamp;
    }

    @Override
    protected int setImageHeight() {
        return 180;
    }

    @Override
    protected void runSampleCode() {
        Observable.just(1, 2, 3)
                .timestamp()
                .subscribe(new Subscriber<Timestamped<Integer>>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted.");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Timestamped<Integer> time) {
                        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                                .format(new Date(time.getTimestampMillis()));
                        System.out.println("onNext: " + time.getValue() + "(" + timestamp + ")");
                    }
                });
    }

    @Override
    protected String getSampleCode() {
        return "Observable.just(1, 2, 3)\n" +
                "        .timestamp()\n" +
                "        .subscribe(new Subscriber<Timestamped<Integer>>() {\n" +
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
                "            public void onNext(Timestamped<Integer> time) {\n" +
                "                String timestamp = new SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\")\n" +
                "                        .format(new Date(time.getTimestampMillis()));\n" +
                "                System.out.println(\"onNext: \" + time.getValue() + \"(\" + timestamp + \")\");\n" +
                "            }\n" +
                "        });";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext: 1(2016-10-17 22:05:04)");
        output.add("\nonNext: 2(2016-10-17 22:05:04)");
        output.add("\nonNext: 3(2016-10-17 22:05:04)");
        output.add("\nonCompleted.");

        return output;
    }
}
