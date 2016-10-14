package com.sherlockshi.rxjavabestpractise.activity.category2_transforming_observables;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Author: SherlockShi
 * Date:   2016-10-14 09:37
 * Description:
 */
public class Category2Operator1MapActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "map";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category2_transforming_observables_1_map_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.b1_map;
    }

    @Override
    protected int setImageHeight() {
        return 170;
    }

    @Override
    protected void runSampleCode() {
        class Student {
            private String name;

            public Student(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }
        }

        Student student1 = new Student("ZhangSan");
        Student student2 = new Student("LiSi");
        Student student3 = new Student("WangWu");

        Observable.just(student1, student2, student3)
                .map(new Func1<Student, String>() {
                    @Override
                    public String call(Student student) {
                        return student.getName();
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
        return "class Student {\n" +
                "    private String name;\n" +
                "\n" +
                "    public Student(String name) {\n" +
                "        this.name = name;\n" +
                "    }\n" +
                "\n" +
                "    public String getName() {\n" +
                "        return name;\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "Student student1 = new Student(\"ZhangSan\");\n" +
                "Student student2 = new Student(\"LiSi\");\n" +
                "Student student3 = new Student(\"WangWu\");\n" +
                "\n" +
                "Observable.just(student1, student2, student3)\n" +
                "        .map(new Func1<Student, String>() {\n" +
                "            @Override\n" +
                "            public String call(Student student) {\n" +
                "                return student.getName();\n" +
                "            }\n" +
                "        })\n" +
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
        output.add("onNext: ZhangSan");
        output.add("\nonNext: LiSi");
        output.add("\nonNext: WangWu");
        output.add("\nonCompleted.");

        return output;
    }
}
