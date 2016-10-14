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
 * Date:   2016-10-14 13:42
 * Description:
 */
public class Category2Operator2FlatMapActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "flatMap";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category2_transforming_observables_2_flatmap_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.b2_flatmap;
    }

    @Override
    protected int setImageHeight() {
        return 180;
    }

    @Override
    protected void runSampleCode() {
        class Course {
            private String name;

            public Course(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }
        }

        class Student {
            private List<Course> courses;

            public Student(List<Course> courses) {
                this.courses = courses;
            }

            public List<Course> getCourses() {
                return courses;
            }
        }

        /* Student1 */
        Course course11 = new Course("C#");
        Course course12 = new Course("Java");
        Course course13 = new Course("Python");

        List<Course> courses1 = new ArrayList<Course>();
        courses1.add(course11);
        courses1.add(course12);
        courses1.add(course13);

        Student student1 = new Student(courses1);

        /* Student2 */
        Course course21 = new Course("OC");
        Course course22 = new Course("Ruby");

        List<Course> courses2 = new ArrayList<Course>();
        courses2.add(course21);
        courses2.add(course22);

        Student student2 = new Student(courses2);

        Observable.just(student1, student2)
                .flatMap(new Func1<Student, Observable<Course>>() {
                    @Override
                    public Observable<Course> call(Student student) {
                        return Observable.from(student.getCourses());
                    }
                })
                .subscribe(new Subscriber<Course>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted.");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Course course) {
                        System.out.println("onNext: " + course.getName());
                    }
                });
    }

    @Override
    protected String getSampleCode() {
        return "class Course {\n" +
                "    private String name;\n" +
                "\n" +
                "    public Course(String name) {\n" +
                "        this.name = name;\n" +
                "    }\n" +
                "\n" +
                "    public String getName() {\n" +
                "        return name;\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "class Student {\n" +
                "    private List<Course> courses;\n" +
                "\n" +
                "    public Student(List<Course> courses) {\n" +
                "        this.courses = courses;\n" +
                "    }\n" +
                "\n" +
                "    public List<Course> getCourses() {\n" +
                "        return courses;\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "/* Student1 */\n" +
                "Course course11 = new Course(\"C#\");\n" +
                "Course course12 = new Course(\"Java\");\n" +
                "Course course13 = new Course(\"Python\");\n" +
                "\n" +
                "List<Course> courses1 = new ArrayList<Course>();\n" +
                "courses1.add(course11);\n" +
                "courses1.add(course12);\n" +
                "courses1.add(course13);\n" +
                "\n" +
                "Student student1 = new Student(courses1);\n" +
                "\n" +
                "/* Student2 */\n" +
                "Course course21 = new Course(\"OC\");\n" +
                "Course course22 = new Course(\"Ruby\");\n" +
                "\n" +
                "List<Course> courses2 = new ArrayList<Course>();\n" +
                "courses2.add(course21);\n" +
                "courses2.add(course22);\n" +
                "\n" +
                "Student student2 = new Student(courses2);\n" +
                "\n" +
                "Observable.just(student1, student2)\n" +
                "        .flatMap(new Func1<Student, Observable<Course>>() {\n" +
                "            @Override\n" +
                "            public Observable<Course> call(Student student) {\n" +
                "                return Observable.from(student.getCourses());\n" +
                "            }\n" +
                "        })\n" +
                "        .subscribe(new Subscriber<Course>() {\n" +
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
                "            public void onNext(Course course) {\n" +
                "                System.out.println(\"onNext: \" + course.getName());\n" +
                "            }\n" +
                "        });";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("onNext: C#");
        output.add("\nonNext: Java");
        output.add("\nonNext: Python");
        output.add("\nonNext: OC");
        output.add("\nonNext: Ruby");
        output.add("\nonCompleted.");

        return output;
    }
}
