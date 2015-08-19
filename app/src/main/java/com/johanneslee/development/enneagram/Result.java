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

        type = (TextView) findViewById(R.id.type);
        summary = (TextView) findViewById(R.id.summary);

        Bundle bundle = getIntent().getExtras();
        first = bundle.getInt("first");
        second = bundle.getInt("second");

        resultPage();
    }

    public void resultPage() {
        switch (first + 1) {
            case 1:
                type.setText(R.string.result1);
                summary.setText(R.string.summary1);
                break;
            case 2:
                type.setText(R.string.result2);
                summary.setText(R.string.summary2);
                break;
            case 3:
                type.setText(R.string.result3);
                summary.setText(R.string.summary3);
                break;
            case 4:
                type.setText(R.string.result4);
                summary.setText(R.string.summary4);
                break;
            case 5:
                type.setText(R.string.result5);
                summary.setText(R.string.summary5);
                break;
            case 6:
                type.setText(R.string.result6);
                summary.setText(R.string.summary6);
                break;
            case 7:
                type.setText(R.string.result7);
                summary.setText(R.string.summary7);
                break;
            case 8:
                type.setText(R.string.result8);
                summary.setText(R.string.summary8);
                break;
            case 9:
                type.setText(R.string.result9);
                summary.setText(R.string.summary9);
                break;
        }
    }
}