package com.sherlockshi.rxjavabestpractise.activity.category6_observable_utility_operators;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;

/**
 * Author: SherlockShi
 * Date:   2016-10-18 22:22
 * Description:
 */
public class Category6Operator11UsingActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "using";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category6_observable_utility_operators_11_using_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.f11_using;
    }

    @Override
    protected int setImageHeight() {
        return 200;
    }

    @Override
    protected void runSampleCode() {
        class Animal {
            public Animal() {
                System.out.println("Animal create.");
            }

            public void release() {
                System.out.println("Animal release.");
            }
        }

        Observable.using(new Func0<Animal>() {
                             @Override
                             public Animal call() {
                                 return new Animal();
                             }
                         },
                new Func1<Animal, Observable<?>>() {
                    @Override
                    public Observable<?> call(Animal animal) {
                        return Observable.timer(5000, TimeUnit.MILLISECONDS);
                    }
                },
                new Action1<Animal>() {
                    @Override
                    public void call(Animal animal) {
                        animal.release();
                    }
                })
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
        return "class Animal {\n" +
                "    public Animal() {\n" +
                "        System.out.println(\"Animal create.\");\n" +
                "    }\n" +
                "\n" +
                "    public void release() {\n" +
                "        System.out.println(\"Animal release.\");\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "Observable.using(new Func0<Animal>() {\n" +
                "                     @Override\n" +
                "                     public Animal call() {\n" +
                "                         return new Animal();\n" +
                "                     }\n" +
                "                 },\n" +
                "        new Func1<Animal, Observable<?>>() {\n" +
                "            @Override\n" +
                "            public Observable<?> call(Animal animal) {\n" +
                "                return Observable.timer(5000, TimeUnit.MILLISECONDS);\n" +
                "            }\n" +
                "        },\n" +
                "        new Action1<Animal>() {\n" +
                "            @Override\n" +
                "            public void call(Animal animal) {\n" +
                "                animal.release();\n" +
                "            }\n" +
                "        })\n" +
                "        .subscribe(new Subscriber<Object>() {\n" +
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
                "            public void onNext(Object o) {\n" +
                "                System.out.println(\"onNext: \" + o);\n" +
                "            }\n" +
                "        });";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("Animal create.");
        output.add("\nonNext: 0");
        output.add("\nonCompleted.");
        output.add("\nAnimal release.");

        return output;
    }
}
