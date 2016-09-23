package com.sherlockshi.rxjavabestpractise.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.sherlockshi.rxjavabestpractise.BaseActivity;
import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.util.SpannableUtil;
import com.sherlockshi.rxjavabestpractise.util.StringBufferUtil;
import com.sherlockshi.rxjavabestpractise.util.ViewUtil;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func0;

/**
 * Author: SherlockShi
 * Date:   2016-09-17 21:41
 * Description:
 */
public class Category1Operator2DeferActivity extends BaseActivity {

    private TextView tvSampleCode;
    private TextView tvOutput;
    private CardView cvOutput;

    private String[] outputString = {"Next: 0", "\nNext: 1", "\nNext: 2", "\nNext: 3", "\nSequence complete."};
    private StringBuffer outputStringBuffer = new StringBuffer();

    int number;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_category1_operator2_defer);

        initView();

        initData();
    }

    private void initView() {
        initFloatingActionButton();

        tvSampleCode = (TextView) findViewById(R.id.tv_sample_code);

        tvOutput = (TextView) findViewById(R.id.tv_output);

        cvOutput = (CardView) findViewById(R.id.cv_output);
    }

    private void initData() {
        tvSampleCode.setText(getSampleCode());
        SpannableUtil.setPartialTextOtherColor(tvSampleCode,
                getSampleCode().indexOf(".") + 1,
                getSampleCode().indexOf("("));
    }

    private void initFloatingActionButton() {
        showFab();

        getFab().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runCreateOperatorCode();

                showOutputInScreen();
            }
        });
    }

    private void runCreateOperatorCode() {
        // TODO: 16/9/23 验证每次订阅时，生成的Observable为不同对象
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

        System.out.println("deferObservable0: " + deferObservable.toString());

        deferObservable.subscribe(new Action1() {
            @Override
            public void call(Object o) {
                System.out.println("defer1 result: " + o.toString());
            }
        });

        System.out.println("deferObservable1: " + deferObservable.toString());

        number = 4;

        deferObservable.subscribe(new Action1() {
            @Override
            public void call(Object o) {
                System.out.println("defer2 result: " + o.toString());
            }
        });

        System.out.println("deferObservable2: " + deferObservable.toString());
    }

    private void showOutputInScreen() {
        ViewUtil.hide(cvOutput);

        StringBufferUtil.clear(outputStringBuffer);

        Observable
                .interval(500, TimeUnit.MILLISECONDS)
                .take(outputString.length)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        ViewUtil.show(cvOutput);

                        outputStringBuffer.append(outputString[aLong.intValue()]);
                        tvOutput.setText(outputStringBuffer);
                    }
                });
    }

    private String getSampleCode() {
        return "Observable.create(new Observable.OnSubscribe<Integer>() {\n" +
                "            @Override\n" +
                "            public void call(Subscriber<? super Integer> observer) {\n" +
                "                try {\n" +
                "                    if (!observer.isUnsubscribed()) {\n" +
                "                        for (int i = 0; i < 4; i++) {\n" +
                "                            observer.onNext(i);\n" +
                "                        }\n" +
                "                        observer.onCompleted();\n" +
                "                    }\n" +
                "                } catch (Exception e) {\n" +
                "                    observer.onError(e);\n" +
                "                }\n" +
                "            }\n" +
                "        }).subscribe(new Subscriber<Integer>() {\n" +
                "            @Override\n" +
                "            public void onCompleted() {\n" +
                "                System.out.println(\"Sequence complete.\");\n" +
                "            }\n" +
                "\n" +
                "            @Override\n" +
                "            public void onError(Throwable e) {\n" +
                "                System.out.println(\"Error: \" + e.getMessage());\n" +
                "            }\n" +
                "\n" +
                "            @Override\n" +
                "            public void onNext(Integer integer) {\n" +
                "                System.out.println(\"Next: \" + integer);\n" +
                "            }\n" +
                "        });";
    }
}
