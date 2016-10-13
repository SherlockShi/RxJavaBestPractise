package com.sherlockshi.rxjavabestpractise.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.util.DensityUtils;
import com.sherlockshi.rxjavabestpractise.util.SpannableUtil;
import com.sherlockshi.rxjavabestpractise.util.StringBufferUtil;
import com.sherlockshi.rxjavabestpractise.util.ViewUtil;

import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Author: SherlockShi
 * Date:   2016-09-17 21:48
 * Description:
 */
public abstract class BaseOperatorSampleActivity extends BaseActivity {

    private int DEFAULT_IMAGE_HEIGHT = 120;

    private FloatingActionButton fab;

    private TextView tvDescription; // 描述
    private ImageView ivGraph;      // 示意图

    private TextView tvSampleCode;
    private TextView tvOutput;
    private CardView cvOutput;

    private StringBuffer outputStringBuffer = new StringBuffer();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_base_operator_sample);

        initFloatingActionButton();

        initView();

        initData();
    }

    private void initFloatingActionButton() {
        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setVisibility(View.VISIBLE);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runSampleCode();

                showOutputInScreen();
            }
        });
    }

    private void initView(){
        tvDescription = (TextView) findViewById(R.id.tv_description);
        ivGraph = (ImageView) findViewById(R.id.iv_graph);

        tvSampleCode = (TextView) findViewById(R.id.tv_sample_code);

        tvOutput = (TextView) findViewById(R.id.tv_output);

        cvOutput = (CardView) findViewById(R.id.cv_output);
    }

    protected void initData() {
        tvDescription.setText(getDescription());

        ivGraph.setImageResource(getImageResourceId());
        DensityUtils.changeH(ivGraph, DensityUtils.dp2px(this, setImageHeight()));

        tvSampleCode.setText(getSampleCode());

        int startIndex = getSampleCode().indexOf(getOperatorName() + "(");
        int endIndex = startIndex + getOperatorName().length();

        try {
            SpannableUtil.setMethodNameRed(tvSampleCode,
                    startIndex,
                    endIndex);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    protected void showOutputInScreen() {
        final List<String> outputList = getOutputList();

        ViewUtil.hide(cvOutput);

        StringBufferUtil.clear(outputStringBuffer);

        Observable
                .interval(500, TimeUnit.MILLISECONDS)
                .take(outputList.size())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        ViewUtil.show(cvOutput);

                        outputStringBuffer.append(outputList.get(aLong.intValue()));
                        tvOutput.setText(outputStringBuffer);
                    }
                });
    }

    protected int setImageHeight() {
        return DEFAULT_IMAGE_HEIGHT;
    }

    protected abstract String getOperatorName();

    protected abstract String getDescription();

    protected abstract int getImageResourceId();

    protected abstract void runSampleCode();

    protected abstract String getSampleCode();

    protected abstract List<String> getOutputList();
}
