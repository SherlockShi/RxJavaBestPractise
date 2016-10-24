package com.sherlockshi.rxjavabestpractise.activity.category11_operators_to_convert_observables;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Author: SherlockShi
 * Date:   2016-10-24 21:16
 * Description:
 */
public class Category11Operator8NestActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "nest";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category11_operators_to_convert_observables_8_nest_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.k8_nest;
    }

    @Override
    protected int setImageHeight() {
        return 200;
    }

    @Override
    protected void runSampleCode() {
        Observable.just(1, 2, 3, 4)
                .nest()
                .subscribe(new Subscriber<Observable<Integer>>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted.");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Observable<Integer> observable) {
                        observable.subscribe(new Subscriber<Integer>() {
                            @Override
                            public void onCompleted() {
                                System.out.println("onCompleted(inner).");
                            }

                            @Override
                            public void onError(Throwable e) {
                                System.out.println("onError(inner): " + e.getMessage());
                            }

                            @Override
                            public void onNext(Integer integer) {
                                System.out.println("onNext: " + integer);
                            }
                        });
                    }
                });
    }

    @Override
    protected String getSampleCode() {
        return "Observable.just(1, 2, 3, 4)\n" +
                "    .nest()\n" +
                "    .subscribe(new Subscriber<Observable<Integer>>() {\n" +
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
                "        public void onNext(Observable<Integer> observable) {\n" +
                "            observable.subscribe(new Subscriber<Integer>() {\n" +
                "                @Override\n" +
                "                public void onCompleted() {\n" +
                "                    System.out.println(\"onCompleted(inner).\");\n" +
                "                }\n" +
                "\n" +
                "                @Override\n" +
                "                public void onError(Throwable e) {\n" +
                "                    System.out.println(\"onError(inner): \" + e.getMessage());\n" +
                "                }\n" +
                "\n" +
                "                @Override\n" +
                "                public void onNext(Integer integer) {\n" +
                "                    System.out.println(\"onNext: \" + integer);\n" +
                "                }\n" +
                "            });\n" +
                "        }\n" +
                "    });";
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
