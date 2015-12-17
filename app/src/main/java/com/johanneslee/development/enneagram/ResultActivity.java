package com.johanneslee.development.enneagram;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.kakao.kakaolink.AppActionBuilder;
import com.kakao.kakaolink.KakaoLink;
import com.kakao.kakaolink.KakaoTalkLinkMessageBuilder;
import com.kakao.util.KakaoParameterException;

public class ResultActivity extends Activity implements View.OnClickListener{
    private final int[] resultId = {R.string.result1, R.string.result1w9, R.string.result1w2, R.string.result2, R.string.result2w1, R.string.result2w3, R.string.result3, R.string.result3w2, R.string.result3w4, R.string.result4, R.string.result4w3, R.string.result4w5, R.string.result5, R.string.result5w4, R.string.result5w6, R.string.result6, R.string.result6w5, R.string.result6w7, R.string.result7, R.string.result7w6, R.string.result7w8, R.string.result8, R.string.result8w7, R.string.result8w9, R.string.result9, R.string.result9w8, R.string.result9w1};
    private final int[] typeId = {R.string.type11, R.string.type12, R.string.type21, R.string.type22, R.string.type31, R.string.type32, R.string.type41, R.string.type42, R.string.type51, R.string.type52, R.string.type61, R.string.type62, R.string.type71, R.string.type72, R.string.type81, R.string.type82, R.string.type91, R.string.type92};
    private final int[] typewId = {R.string.type1w9, R.string.type1w2, R.string.type2w1, R.string.type2w3, R.string.type3w2, R.string.type3w4, R.string.type4w3, R.string.type4w5, R.string.type5w4, R.string.type5w6, R.string.type6w5, R.string.type6w7, R.string.type7w6, R.string.type7w8, R.string.type8w7, R.string.type8w9, R.string.type9w8, R.string.type9w1};

    private StringBuffer stringBuffer = new StringBuffer();

    private int first, second = 0;

    private TextView result;
    private TextView resultWing;
    private TextView type1, type2, typew;

    private Button leftArrowButton;
    private Button shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_result);

        setupViews();
    }

    private void setupViews() {
        result = (TextView) findViewById(R.id.resultBar);
        resultWing = (TextView) findViewById(R.id.resultWing);

        type1 = (TextView) findViewById(R.id.type1);
        type2 = (TextView) findViewById(R.id.type2);
        typew = (TextView) findViewById(R.id.typew);

        leftArrowButton = (Button) findViewById(R.id.leftArrow);
        leftArrowButton.setOnClickListener(this);
        shareButton = (Button) findViewById(R.id.share);
        shareButton.setOnClickListener(this);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Bundle bundle = getIntent().getExtras();
        first = bundle.getInt("first");
        second = bundle.getInt("second");

        routeResult(first, second);
    }

    public void routeResult(int first, int second) {
        if(second != first + 1 && second != first - 1 && second != first - 8 && second != first + 8)
            second = 0;

        int value = (first * 10) + second;

        switch (value) {
            case 10:
                handlingResult(0, -1);
                break;
            case 19:
                handlingResult(0, 0);
                break;
            case 12:
                handlingResult(0, 1);
                break;
            case 20:
                handlingResult(1, -1);
                break;
            case 21:
                handlingResult(1, 0);
                break;
            case 23:
                handlingResult(1, 1);
                break;
            case 30:
                handlingResult(2, -1);
                break;
            case 32:
                handlingResult(2, -1);
                break;
            case 34:
                handlingResult(2, 0);
                break;
            case 40:
                handlingResult(3, -1);
                break;
            case 43:
                handlingResult(3, 0);
                break;
            case 45:
                handlingResult(3, 1);
                break;
            case 50:
                handlingResult(4, -1);
                break;
            case 54:
                handlingResult(4, 0);
                break;
            case 56:
                handlingResult(4, 1);
                break;
            case 60:
                handlingResult(5, -1);
                break;
            case 65:
                handlingResult(5, 0);
                break;
            case 67:
                handlingResult(5, 1);
                break;
            case 70:
                handlingResult(6, -1);
                break;
            case 76:
                handlingResult(6, 0);
                break;
            case 78:
                handlingResult(6, 1);
                break;
            case 80:
                handlingResult(7, -1);
                break;
            case 87:
                handlingResult(7, 0);
                break;
            case 88:
                handlingResult(7, 1);
                break;
            case 90:
                handlingResult(8, -1);
                break;
            case 98:
                handlingResult(8, 0);
                break;
            case 91:
                handlingResult(8, 1);
                break;
        }
    }

    private void handlingResult(int type, int wing) {
        result.setText(resultId[type * 3 + wing + 1]);
        stringBuffer.append(getResources().getString(resultId[type * 3 + wing + 1]));
        type1.setText(typeId[type * 2 + 0]);
        stringBuffer.append("\n개요 : " + getResources().getString(typeId[type * 2 + 0]));
        type2.setText(typeId[type * 2 + 1]);
        stringBuffer.append("\n성장 : " + getResources().getString(typeId[type * 2 + 1]));

        if(wing == -1) {
            resultWing.setVisibility(View.GONE);
            typew.setVisibility(View.GONE);
        }
        else {
            typew.setText(typewId[type * 2 + wing]);
            stringBuffer.append("\n날개 : " + getResources().getString(typewId[type * 2 + wing]));
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.leftArrow:
                onBackPressed();
                break;
            case R.id.share:
                try {
                    final KakaoLink kakaoLink = KakaoLink.getKakaoLink(getApplicationContext());
                    final KakaoTalkLinkMessageBuilder kakaoTalkLinkMessageBuilder = kakaoLink.createKakaoTalkLinkMessageBuilder();
                    kakaoTalkLinkMessageBuilder.addText(stringBuffer.toString()).addAppButton("앱으로 이동", new AppActionBuilder().setUrl("market://details?id=com.johanneslee.development.enneagram").build());
                    kakaoLink.sendMessage(kakaoTalkLinkMessageBuilder, this);
                } catch (KakaoParameterException e) {
                    Log.e("error", e.getMessage());
                }
                break;
        }
    }

    //scraped open source :-)
    public void onBackPressed() {
        //TODO Auto-generated method stub
        //super.onBackPressed(); //지워야 실행됨

        Intent i = new Intent(getApplicationContext(), EnneagramActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
}