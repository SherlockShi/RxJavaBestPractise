package com.sherlockshi.rxjavabestpractise.activity.category1_creating_observables;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func0;

/**
 * Author: SherlockShi
 * Date:   2016-09-17 21:41
 * Description:
 */
public class Category1Operator2DeferActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "defer";
    }

    private int number;

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category1_creating_observables_2_defer_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.a2_defer;
    }

    @Override
    protected int setImageHeight() {
        return 180;
    }

    @Override
    protected void runSampleCode() {
        number = 1;
        Observable justObservable = Observable.just(number);

        number = 2;
        Observable deferObservable = Observable.defer(new Func0<Observable<Integer>>() {
            @Override
            public Observable<Integer> call() {
                return Observable.just(number);
            }
        });

        number = 3;

        justObservable.subscribe(new Action1() {
            @Override
            public void call(Object o) {
                System.out.println("just result: " + o.toString());
            }
        });

        deferObservable.subscribe(new Action1() {
            @Override
            public void call(Object o) {
                System.out.println("defer1 result: " + o.toString());
            }
        });

        number = 4;

        deferObservable.subscribe(new Action1() {
            @Override
            public void call(Object o) {
                System.out.println("defer2 result: " + o.toString());
            }
        });
    }

    @Override
    protected String getSampleCode() {
        return "    number = 1;\n" +
                "    Observable justObservable = Observable.just(number);\n" +
                "\n" +
                "    number = 2;\n" +
                "    Observable deferObservable = Observable.defer(new Func0<Observable<Integer>>() {\n" +
                "        @Override\n" +
                "        public Observable<Integer> call() {\n" +
                "            return Observable.just(number);\n" +
                "        }\n" +
                "    });\n" +
                "\n" +
                "    number = 3;\n" +
                "\n" +
                "    justObservable.subscribe(new Action1() {\n" +
                "        @Override\n" +
                "        public void call(Object o) {\n" +
                "            System.out.println(\"just result: \" + o.toString());\n" +
                "        }\n" +
                "    });\n" +
                "\n" +
                "    deferObservable.subscribe(new Action1() {\n" +
                "        @Override\n" +
                "        public void call(Object o) {\n" +
                "            System.out.println(\"defer1 result: \" + o.toString());\n" +
                "        }\n" +
                "    });\n" +
                "\n" +
                "    number = 4;\n" +
                "\n" +
                "    deferObservable.subscribe(new Action1() {\n" +
                "        @Override\n" +
                "        public void call(Object o) {\n" +
                "            System.out.println(\"defer2 result: \" + o.toString());\n" +
                "        }\n" +
                "    });";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("just result: 1");
        output.add("\ndefer1 result: 3");
        output.add("\ndefer2 result: 4");

        return output;
    }
}
