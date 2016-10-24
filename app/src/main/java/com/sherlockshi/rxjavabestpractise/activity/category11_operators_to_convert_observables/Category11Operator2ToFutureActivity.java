package com.sherlockshi.rxjavabestpractise.activity.category11_operators_to_convert_observables;

import com.sherlockshi.rxjavabestpractise.R;
import com.sherlockshi.rxjavabestpractise.base.BaseOperatorSampleActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import rx.Observable;

/**
 * Author: SherlockShi
 * Date:   2016-10-21 23:15
 * Description:
 */
public class Category11Operator2ToFutureActivity extends BaseOperatorSampleActivity {

    @Override
    protected String getOperatorName() {
        return "toFuture";
    }

    @Override
    protected String getDescription() {
        return getString(R.string.activity_category11_operators_to_convert_observables_2_to_future_description);
    }

    @Override
    protected int getImageResourceId() {
        return R.drawable.k2_to_future;
    }

    @Override
    protected int setImageHeight() {
        return 230;
    }

    @Override
    protected void runSampleCode() {
        Future future = Observable.just(1).toBlocking().toFuture();
//        Future future = Observable.just(1, 2, 3, 4, 5).toBlocking().toFuture();
//        Future future = Observable.just(1, 2, 3, 4, 5).toList().toBlocking().toFuture();
//        Future future = Observable.empty().toBlocking().toFuture();

        try {
            System.out.println("Data: " + future.get());
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getCause());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getCause());
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getCause());
        } catch (ExecutionException e) {
            System.out.println("Error: " + e.getCause());
        }
    }

    @Override
    protected String getSampleCode() {
        return "Future future = Observable.just(1).toBlocking().toFuture();\n" +
                "//Future future = Observable.just(1, 2, 3, 4, 5).toBlocking().toFuture();\n" +
                "//Future future = Observable.just(1, 2, 3, 4, 5).toList().toBlocking().toFuture();\n" +
                "//Future future = Observable.empty().toBlocking().toFuture();\n" +
                "\n" +
                "try {\n" +
                "    System.out.println(\"Data: \" + future.get());\n" +
                "} catch (NoSuchElementException e) {\n" +
                "    System.out.println(\"Error: \" + e.getCause());\n" +
                "} catch (IllegalArgumentException e) {\n" +
                "    System.out.println(\"Error: \" + e.getCause());\n" +
                "} catch (InterruptedException e) {\n" +
                "    System.out.println(\"Error: \" + e.getCause());\n" +
                "} catch (ExecutionException e) {\n" +
                "    System.out.println(\"Error: \" + e.getCause());\n" +
                "}";
    }

    @Override
    protected List<String> getOutputList() {
        List<String> output = new ArrayList<String>();
        output.add("Data: 1");

        return output;
    }
}
