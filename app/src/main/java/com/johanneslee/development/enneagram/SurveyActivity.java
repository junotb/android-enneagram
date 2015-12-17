package com.johanneslee.development.enneagram;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

public class SurveyActivity extends Activity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private final int[] stringArrayId = {R.array.stringArray0, R.array.stringArray1, R.array.stringArray2, R.array.stringArray3, R.array.stringArray4, R.array.stringArray5, R.array.stringArray6, R.array.stringArray7, R.array.stringArray8, R.array.stringArray9};
    private final int[] textViewId = {R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4, R.id.textView5, R.id.textView6, R.id.textView7, R.id.textView8, R.id.textView9, R.id.textView10, R.id.textView11, R.id.textView12, R.id.textView13, R.id.textView14, R.id.textView15, R.id.textView16, R.id.textView17, R.id.textView18};
    private final int[] radioGroupsId = {R.id.radioGroup1, R.id.radioGroup2, R.id.radioGroup3, R.id.radioGroup4, R.id.radioGroup5, R.id.radioGroup6, R.id.radioGroup7, R.id.radioGroup8, R.id.radioGroup9, R.id.radioGroup10, R.id.radioGroup11, R.id.radioGroup12, R.id.radioGroup13, R.id.radioGroup14, R.id.radioGroup15, R.id.radioGroup16, R.id.radioGroup17, R.id.radioGroup18};

    private int[] surveyValues;
    private int[] resultValues;

    private int pages = 0;

    private TextView topBar;
    private ScrollView mScrollView;

    private Button leftArrowButton;
    private Button rightArrowButton;

    private String[] mStringArray;
    private TextView[] mTextView;
    private RadioGroup[] mRadioGroups;

    private RadioButton radioButton;

    private SharedPreferences isCompletedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_survey);

        setupValues();
        setupViews();
    }

    private void setupValues() {
        mStringArray = getResources().getStringArray(stringArrayId[pages]); //questions

        surveyValues = new int[180]; //when user check the value of spinner, store to this.
        resultValues = new int[9]; //value to get type of user

        for(int i = 0;i < 9;i++) {
            for(int j = 0; j < 20;j++) {
                //Want init 0 ~ 179
                surveyValues[(i * 10) + (j * 2)] = -1;
                surveyValues[(i * 10) + (j * 2) + 1] = -1;
            }
            //Want init only 0 ~ 8
            resultValues[i % 9] = -1;
        }

    }

    private void setupViews() {
        topBar = (TextView) findViewById(R.id.topbar); //show user how it progressed
        mScrollView = (ScrollView) findViewById(R.id.scrollView);

        leftArrowButton = (Button) findViewById(R.id.leftArrow);
        rightArrowButton = (Button) findViewById(R.id.rightArrow);
        leftArrowButton.setOnClickListener(this);
        rightArrowButton.setOnClickListener(this);

        mTextView = new TextView[18];
        mRadioGroups = new RadioGroup[18];

        for (int i = 0; i < 18; i++) { // initializing arraies
            mTextView[i] = new TextView(this);
            mTextView[i] = (TextView) findViewById(textViewId[i]);
            mRadioGroups[i] = new RadioGroup(this);
            mRadioGroups[i] = (RadioGroup) findViewById(radioGroupsId[i]);

            for (int j = 0; j < 5; j++) {
                radioButton = (RadioButton) mRadioGroups[i].getChildAt(j);
                radioButton.setOnCheckedChangeListener(this);
            }
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.leftArrow:
                if (pages <= 0) { //it's first page
                    alert("첫 번째 페이지입니다.");
                    return;
                } else { //not enough
                    pages--;
                    setPage();
                }
                break;

            case R.id.rightArrow:
                //is all question checked?
                for (int i = 0; i < 18; i++) {
                    if (mRadioGroups[i].getCheckedRadioButtonId() == -1) {
                        alert("선택하지 않은 항목이 있습니다.");
                        return;
                    }
                }

                setSurveyValues(); //store answerValues

                //is it progressed enough?
                if (pages >= 1) { //yes
                    Node[] typeArray = setResultValues(); //get nodes arranged in ascending order

                    unLock(); //unlock Dictionary activity

                    //activate next activity
                    Intent i = new Intent(getApplicationContext(), ResultActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putInt("first", typeArray[8].num);
                    bundle.putInt("second", typeArray[7].num);
                    i.putExtras(bundle);

                    startActivity(i);
                    finish();
                } else {
                    pages++;
                    setPage();
                }

                break;
        }
    }

    private void alert(String string){
        new AlertDialog.Builder(SurveyActivity.this).setMessage(string).setNeutralButton("닫기", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dlg, int sumthin) { }
        }).show();
    }

    private void setPage(){
        mStringArray = null;
        mStringArray = getResources().getStringArray(stringArrayId[pages]);

        //setting topBar
        topBar.setText((pages + 1) + " / 10");

        for (int i = 0; i < 18; i++) {
            //setting radiobuttons
            mRadioGroups[i].clearCheck();

            //setting questions
            mTextView[i].setText(mStringArray[i]);

            //setting previous values below
            if(surveyValues[pages * 18 + i] < 0)
                continue;

            radioButton = (RadioButton) mRadioGroups[i].getChildAt(surveyValues[pages * 18 + i]);
            radioButton.setChecked(true);
        }

        mScrollView.smoothScrollTo(0, 0);
    }

    private void setSurveyValues() {
        for (int i = 0; i < 18; i++) {
            int checkedRadioButtonID = mRadioGroups[i].getCheckedRadioButtonId();
            radioButton = (RadioButton) mRadioGroups[i].findViewById(checkedRadioButtonID);
            surveyValues[pages * 18 + i] = mRadioGroups[i].indexOfChild(radioButton);
        }
    }

    private Node[] setResultValues(){
        Node[] typeArray = new Node[9];

        //summarize all answerValues to typeValues
        for(int i = 0; i < 180; i++){
            resultValues[i % 9] += surveyValues[i];
        }

        //setting nodes
        for (int i = 0; i < 9; i++) {
            typeArray[i] = new Node(i + 1, resultValues[i]);
        }

        //arrange ascending order
        Node temp;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 8; j++) {
                if (typeArray[j].value > typeArray[j + 1].value) {
                    temp = typeArray[j];
                    typeArray[j] = typeArray[j + 1];
                    typeArray[j + 1] = temp;
                }
            }
        }

        return typeArray;
    }

    private void unLock() {
        SharedPreferences.Editor editor;

        isCompletedPref = getSharedPreferences("isCompleted", MODE_PRIVATE);
        editor = isCompletedPref.edit();
        editor.putBoolean("isCompleted", true);
        editor.commit();
    }

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            buttonView.setBackgroundColor(Color.rgb(255, 255, 255));
            buttonView.setTextColor(Color.rgb(48, 21, 81));
        } else{
            buttonView.setBackgroundColor(Color.rgb(48, 21, 81));
            buttonView.setTextColor(Color.rgb(255, 255, 255));
        }
    }

    //scraped open source :-)
    public void onBackPressed() {
        //TODO Auto-generated method stub
        //super.onBackPressed(); //지워야 실행됨

        AlertDialog.Builder d = new AlertDialog.Builder(this);
        d.setMessage("검사를 종료하시겠습니까?");
        d.setPositiveButton("예", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            //process전체 종료
            finish();
            }
        });

        d.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        d.show();
    }

}

