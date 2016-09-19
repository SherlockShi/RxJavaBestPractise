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

/**
 * Author: SherlockShi
 * Date:   2016-09-17 21:41
 * Description:
 */
public class Category1Operator1CreateActivity extends BaseActivity {

    private TextView tvSampleCode;
    private TextView tvOutput;
    private CardView cvOutput;

    private String[] outputString = {"Next: 1", "\nNext: 2", "\nNext: 3", "\nNext: 4", "\nSequence complete."};
    private StringBuffer outputStringBuffer = new StringBuffer();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_category1_operator1_create);

        initFloatingActionButton();

        tvSampleCode = (TextView) findViewById(R.id.tv_sample_code);
        tvSampleCode.setText(getSampleCode());
        SpannableUtil.setPartialTextOtherColor(tvSampleCode, 11, 6);

        tvOutput = (TextView) findViewById(R.id.tv_output);

        cvOutput = (CardView) findViewById(R.id.cv_output);
    }

    private void initFloatingActionButton() {
        showFab();

        getFab().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        });
    }

    private String getSampleCode() {
        return "Observable.create(new Observable.OnSubscribe<Integer>() {\n" +
                "    @Override\n" +
                "    public void call(Subscriber<? super Integer> observer) {\n" +
                "        try {\n" +
                "            if (!observer.isUnsubscribed()) {\n" +
                "                for (int i = 1; i < 5; i++) {\n" +
                "                    observer.onNext(i);\n" +
                "                }\n" +
                "                observer.onCompleted();\n" +
                "            }\n" +
                "        } catch (Exception e) {\n" +
                "            observer.onError(e);\n" +
                "        }\n" +
                "    }\n" +
                " } ).subscribe(new Subscriber<Integer>() {\n" +
                "        @Override\n" +
                "        public void onNext(Integer item) {\n" +
                "            System.out.println(\"Next: \" + item);\n" +
                "        }\n" +
                "\n" +
                "        @Override\n" +
                "        public void onError(Throwable error) {\n" +
                "            System.err.println(\"Error: \" + error.getMessage());\n" +
                "        }\n" +
                "\n" +
                "        @Override\n" +
                "        public void onCompleted() {\n" +
                "            System.out.println(\"Sequence complete.\");\n" +
                "        }\n" +
                "    });";
    }
}
