package com.johanneslee.development.enneagram;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

/**
 * Created by development on 2015-10-30.
 */
public class IntroductionActivity extends Activity implements View.OnClickListener{
    TextView link1, link2, link3, leftArrow;
    Intent browserIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_introduction);

        setupViews();
    }

    private void setupViews() {
        leftArrow = (TextView) findViewById(R.id.leftArrow);
        leftArrow.setOnClickListener(this);
        link1 = (TextView) findViewById(R.id.link1);
        link1.setOnClickListener(this);
        link2 = (TextView) findViewById(R.id.link2);
        link2.setOnClickListener(this);
        link3 = (TextView) findViewById(R.id.link3);
        link3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.leftArrow:
                onBackPressed();
                return;
            case R.id.link1:
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maindheart.org"));
            case R.id.link2:
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://hurr.tistory.com"));
                break;
            case R.id.link3:
                browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.naver.com/dryks"));
                break;
        }
        startActivity(browserIntent);
    }
}
