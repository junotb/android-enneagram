package com.johanneslee.development.enneagram;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by development on 2015-11-04.
 */
public class DictionaryActivity extends Activity implements View.OnClickListener{
    private Button leftArrow;
    private Button basicButton1;
    private Button basicButton2;
    private Button basicButton3;
    private Button basicButton4;
    private Button basicButton5;
    private Button basicButton6;
    private Button basicButton7;
    private Button basicButton8;
    private Button basicButton9;
    private Button wingButton19;
    private Button wingButton12;
    private Button wingButton21;
    private Button wingButton23;
    private Button wingButton32;
    private Button wingButton34;
    private Button wingButton43;
    private Button wingButton45;
    private Button wingButton54;
    private Button wingButton56;
    private Button wingButton65;
    private Button wingButton67;
    private Button wingButton76;
    private Button wingButton78;
    private Button wingButton87;
    private Button wingButton89;
    private Button wingButton98;
    private Button wingButton91;
    Intent intent;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dictionary);

        setupViews();
    }

    private void setupViews() {
        leftArrow = (Button) findViewById(R.id.leftArrow);
        leftArrow.setOnClickListener(this);

        basicButton1 = (Button) findViewById(R.id.basicButton1);
        basicButton1.setOnClickListener(this);
        basicButton2 = (Button) findViewById(R.id.basicButton2);
        basicButton2.setOnClickListener(this);
        basicButton3 = (Button) findViewById(R.id.basicButton3);
        basicButton3.setOnClickListener(this);
        basicButton4 = (Button) findViewById(R.id.basicButton4);
        basicButton4.setOnClickListener(this);
        basicButton5 = (Button) findViewById(R.id.basicButton5);
        basicButton5.setOnClickListener(this);
        basicButton6 = (Button) findViewById(R.id.basicButton6);
        basicButton6.setOnClickListener(this);
        basicButton7 = (Button) findViewById(R.id.basicButton7);
        basicButton7.setOnClickListener(this);
        basicButton8 = (Button) findViewById(R.id.basicButton8);
        basicButton8.setOnClickListener(this);
        basicButton9 = (Button) findViewById(R.id.basicButton9);
        basicButton9.setOnClickListener(this);

        wingButton19 = (Button) findViewById(R.id.wingButton1w9);
        wingButton19.setOnClickListener(this);
        wingButton12 = (Button) findViewById(R.id.wingButton1w2);
        wingButton12.setOnClickListener(this);
        wingButton21 = (Button) findViewById(R.id.wingButton2w1);
        wingButton21.setOnClickListener(this);
        wingButton23 = (Button) findViewById(R.id.wingButton2w3);
        wingButton23.setOnClickListener(this);
        wingButton32 = (Button) findViewById(R.id.wingButton3w2);
        wingButton32.setOnClickListener(this);
        wingButton34 = (Button) findViewById(R.id.wingButton3w4);
        wingButton34.setOnClickListener(this);
        wingButton43 = (Button) findViewById(R.id.wingButton4w3);
        wingButton43.setOnClickListener(this);
        wingButton45 = (Button) findViewById(R.id.wingButton4w5);
        wingButton45.setOnClickListener(this);
        wingButton54 = (Button) findViewById(R.id.wingButton5w4);
        wingButton54.setOnClickListener(this);
        wingButton56 = (Button) findViewById(R.id.wingButton5w6);
        wingButton56.setOnClickListener(this);
        wingButton65 = (Button) findViewById(R.id.wingButton6w5);
        wingButton65.setOnClickListener(this);
        wingButton67 = (Button) findViewById(R.id.wingButton6w7);
        wingButton67.setOnClickListener(this);
        wingButton76 = (Button) findViewById(R.id.wingButton7w6);
        wingButton76.setOnClickListener(this);
        wingButton78 = (Button) findViewById(R.id.wingButton7w8);
        wingButton78.setOnClickListener(this);
        wingButton87 = (Button) findViewById(R.id.wingButton8w7);
        wingButton87.setOnClickListener(this);
        wingButton89 = (Button) findViewById(R.id.wingButton8w9);
        wingButton89.setOnClickListener(this);
        wingButton98 = (Button) findViewById(R.id.wingButton9w8);
        wingButton98.setOnClickListener(this);
        wingButton91 = (Button) findViewById(R.id.wingButton9w1);
        wingButton91.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.leftArrow:
                onBackPressed();
                return;
            case R.id.basicButton1:
                onClickHandling(1, 0);
                break;
            case R.id.basicButton2:
                onClickHandling(2, 0);
                break;
            case R.id.basicButton3:
                onClickHandling(3, 0);
                break;
            case R.id.basicButton4:
                onClickHandling(4, 0);
                break;
            case R.id.basicButton5:
                onClickHandling(5, 0);
                break;
            case R.id.basicButton6:
                onClickHandling(6, 0);
                break;
            case R.id.basicButton7:
                onClickHandling(7, 0);
                break;
            case R.id.basicButton8:
                onClickHandling(8, 0);
                break;
            case R.id.basicButton9:
                onClickHandling(9, 0);
                break;
            case R.id.wingButton1w9:
                onClickHandling(1, 9);
                break;
            case R.id.wingButton1w2:
                onClickHandling(1, 2);
                break;
            case R.id.wingButton2w1:
                onClickHandling(2, 1);
                break;
            case R.id.wingButton2w3:
                onClickHandling(2, 3);
                break;
            case R.id.wingButton3w2:
                onClickHandling(3, 2);
                break;
            case R.id.wingButton3w4:
                onClickHandling(3, 4);
                break;
            case R.id.wingButton4w3:
                onClickHandling(4, 3);
                break;
            case R.id.wingButton4w5:
                onClickHandling(4, 5);
                break;
            case R.id.wingButton5w4:
                onClickHandling(5, 4);
                break;
            case R.id.wingButton5w6:
                onClickHandling(5, 6);
                break;
            case R.id.wingButton6w5:
                onClickHandling(6, 5);
                break;
            case R.id.wingButton6w7:
                onClickHandling(6, 7);
                break;
            case R.id.wingButton7w6:
                onClickHandling(7, 6);
                break;
            case R.id.wingButton7w8:
                onClickHandling(7, 8);
                break;
            case R.id.wingButton8w7:
                onClickHandling(8, 7);
                break;
            case R.id.wingButton8w9:
                onClickHandling(8, 9);
                break;
            case R.id.wingButton9w8:
                onClickHandling(9, 8);
                break;
            case R.id.wingButton9w1:
                onClickHandling(9, 1);
                break;
        }
    }

    private void onClickHandling(int first, int second) {
        intent = new Intent(getApplicationContext(), ResultActivity.class);
        bundle = new Bundle();

        bundle.putInt("first", first);
        bundle.putInt("second", second);

        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }
}
