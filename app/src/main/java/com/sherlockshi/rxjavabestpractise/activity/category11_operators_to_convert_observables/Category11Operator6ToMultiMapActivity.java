package com.sherlockshi.rxjavabestpractise.activity.category11_operators_to_convert_observables;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Author: SherlockShi
 * Date:   2016-10-24 11:39
 * Description:
 */
public class Category11Operator6ToMultiMapActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "toMultimap";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category11_operators_to_convert_observables_6_to_multi_map_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.k6_to_multi_map;
    }

    @Override
    protected int setImageHeight() {
        return 180;
    }

    @Override
    protected void runSampleCode() {
        class Student {
            private int id;
            private String name;

            public Student(int id, String name) {
                this.id = id;
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            @Override
            public String toString() {
                return "Student{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        '}';
            }
        }

        Student stu1 = new Student(1001, "ZhangSan");
        Student stu2 = new Student(1002, "LiSi");

        Observable.just(stu1, stu2)
                .toMultimap(new Func1<Student, Integer>() {
                    @Override
                    public Integer call(Student student) {
                        return student.getId();
                    }
                })
                .subscribe(new Subscriber<Map<Integer, Collection<Student>>>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted.");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError: " + e.getMessage());
            }

            @Override
            public void onNext(Map<Integer, Collection<Student>> map) {
                System.out.println("onNext: " + map.toString());
            }
        });
    }

    @Override
    protected String getSampleCode() {
        return "class Student {\n" +
                "    private int id;\n" +
                "    private String name;\n" +
                "\n" +
                "    public Student(int id, String name) {\n" +
                "        this.id = id;\n" +
                "        this.name = name;\n" +
                "    }\n" +
                "\n" +
                "    public int getId() {\n" +
                "        return id;\n" +
                "    }\n" +
                "\n" +
                "    public String getName() {\n" +
                "        return name;\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public String toString() {\n" +
                "        return \"Student{\" +\n" +
                "                \"id=\" + id +\n" +
                "                \", name='\" + name + '\\'' +\n" +
                "                '}';\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "Student stu1 = new Student(1001, \"ZhangSan\");\n" +
                "Student stu2 = new Student(1002, \"LiSi\");\n" +
                "\n" +
                "Observable.just(stu1, stu2)\n" +
                "        .toMultimap(new Func1<Student, Integer>() {\n" +
                "            @Override\n" +
                "            public Integer call(Student student) {\n" +
                "                return student.getId();\n" +
                "            }\n" +
                "        })\n" +
                "        .subscribe(new Subscriber<Map<Integer, Collection<Student>>>() {\n" +
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
                "    public void onNext(Map<Integer, Collection<Student>> map) {\n" +
                "        System.out.println(\"onNext: \" + map.toString());\n" +
                "    }\n" +
                "});";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext: {1002=[Student{id=1002, name='LiSi'}], 1001=[Student{id=1001, name='ZhangSan'}]}");
        output.add("\nonCompleted.");

        return output;
    }
}
