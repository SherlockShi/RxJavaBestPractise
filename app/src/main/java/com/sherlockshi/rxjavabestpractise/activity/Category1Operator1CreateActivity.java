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
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Author: SherlockShi
 * Date:   2016-09-17 21:41
 * Description:
 */
public class Category1Operator1CreateActivity extends BaseActivity {

    private TextView tvSampleCode;
    private TextView tvOutput;
    private CardView cvOutput;

    private String[] outputString = {"Next: 0", "\nNext: 1", "\nNext: 2", "\nNext: 3", "\nSequence complete."};
    private StringBuffer outputStringBuffer = new StringBuffer();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_category1_operator1_create);

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
        tvSampleCode.setText(getCreateOperatorSampleCode());
        SpannableUtil.setPartialTextOtherColor(tvSampleCode, 11, 6);
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
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> observer) {
                try {
                    if (!observer.isUnsubscribed()) {
                        for (int i = 0; i < 4; i++) {
                            observer.onNext(i);
                        }
                        observer.onCompleted();
                    }
                } catch (Exception e) {
                    observer.onError(e);
                }
            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("Sequence complete.");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Error: " + e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("Next: " + integer);
            }
        });
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

    private String getCreateOperatorSampleCode() {
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
