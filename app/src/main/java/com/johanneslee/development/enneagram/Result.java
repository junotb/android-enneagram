package com.johanneslee.development.enneagram;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class Result extends Activity {
    public int first;
    public int second;
    public TextView type;
    public TextView summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_result);

        Bundle bundle = getIntent().getExtras();
        first = bundle.getInt("first");
        second = bundle.getInt("second");

        resultPage();
    }

    public void resultPage() {
        switch (first + 1) {
            case 1:
                type.setText(R.string.result1);
                break;
            case 2:
                type.setText(R.string.result2);
                break;
            case 3:
                type.setText(R.string.result3);
                break;
            case 4:
                type.setText(R.string.result4);
                break;
            case 5:
                type.setText(R.string.result5);
                break;
            case 6:
                type.setText(R.string.result6);
                break;
            case 7:
                type.setText(R.string.result7);
                break;
            case 8:
                type.setText(R.string.result8);
                break;
            case 9:
                type.setText(R.string.result9);
                break;
        }
    }
}