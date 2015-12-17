package com.johanneslee.development.enneagram;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.security.MessageDigest;

public class EnneagramActivity extends Activity implements View.OnClickListener{
    private Button toSurveyButton;
    private Button toIntroductionButton;
    private Button toDictionaryButton;

    private TextView thankYouTextView;

    private SharedPreferences isCompletedPref;
    private Boolean isCompleted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_enneagram);

        setupViews();
    }

    private void setupViews() {

        toSurveyButton = (Button) findViewById(R.id.toSurveyButton);
        toIntroductionButton = (Button) findViewById(R.id.toIntroductionButton);
        toDictionaryButton = (Button) findViewById(R.id.toDictionaryButton);

        thankYouTextView = (TextView) findViewById(R.id.thankYouTextView);

        toSurveyButton.setOnClickListener(this);
        toIntroductionButton.setOnClickListener(this);
        toDictionaryButton.setOnClickListener(this);

        isCompletedPref = getSharedPreferences("isCompleted", MODE_PRIVATE);
        isCompleted = isCompletedPref.getBoolean("isCompleted", false);

        if(isCompleted) {
            showViews();
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toSurveyButton:
                onClickHandling(SurveyActivity.class);
                break;

            case R.id.toIntroductionButton:
                onClickHandling(IntroductionActivity.class);
                break;

            case R.id.toDictionaryButton:
                onClickHandling(DictionaryActivity.class);
                break;
        }
    }

    private void onClickHandling(Class activityClass){
        Intent intent = new Intent(getApplicationContext(), activityClass);
        startActivity(intent);
    }

    private void showViews() {
        thankYouTextView.setVisibility(View.VISIBLE);
        toDictionaryButton.setVisibility(View.VISIBLE);
    }
}
