package com.sherlockshi.rxjavabestpractise.activity.category11_operators_to_convert_observables;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Author: SherlockShi
 * Date:   2016-10-24 20:52
 * Description:
 */
public class Category11Operator7ToSortedListActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "toSortedList";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category11_operators_to_convert_observables_7_to_sorted_list_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.k7_to_sorted_list;
    }

    @Override
    protected int setImageHeight() {
        return 180;
    }

    @Override
    protected void runSampleCode() {
        Observable.just(5, 2, 7, 3)
                .toSortedList()
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
        return "Observable.just(5, 2, 7, 3)\n" +
                "    .toSortedList()\n" +
                "    .subscribe(new Subscriber<List<Integer>>() {\n" +
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
                "        public void onNext(List<Integer> integers) {\n" +
                "            System.out.println(\"onNext: \" + integers);\n" +
                "        }\n" +
                "    });";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext: [2, 3, 5, 7]");
        output.add("\nonCompleted.");

        return output;
    }
}
