package com.johanneslee.development.enneagram;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

public class Main extends Activity {
    private final int[] textViewId = {R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4, R.id.textView5, R.id.textView6, R.id.textView7, R.id.textView8, R.id.textView9};
    private final int[] spinnerId = {R.id.spinner1, R.id.spinner2, R.id.spinner3, R.id.spinner4, R.id.spinner5, R.id.spinner6, R.id.spinner7, R.id.spinner8, R.id.spinner9};
    private final int[] stringArrayId = {R.array.stringArray0, R.array.stringArray1, R.array.stringArray2, R.array.stringArray3, R.array.stringArray4, R.array.stringArray5, R.array.stringArray6, R.array.stringArray7, R.array.stringArray8, R.array.stringArray9, R.array.stringArray10, R.array.stringArray11, R.array.stringArray12, R.array.stringArray13, R.array.stringArray14, R.array.stringArray15, R.array.stringArray16, R.array.stringArray17, R.array.stringArray18, R.array.stringArray19};
    private final int[] topbarId = {R.string.page1, R.string.page2, R.string.page3, R.string.page4, R.string.page5, R.string.page6, R.string.page7, R.string.page8, R.string.page9, R.string.page10, R.string.page11, R.string.page12, R.string.page13, R.string.page14, R.string.page15, R.string.page16, R.string.page17, R.string.page18, R.string.page19, R.string.page20};
    private final String[] items = {"0", "1", "2", "3", "4", "5"};
    private String[] stringArray;
    private int[] analysis;
    private int[] values;
    private int progress;

    private ArrayAdapter<String> adapter;
    private ScrollView scrollView;
    private TextView topbar;
    private Spinner[] spinner;
    private TextView[] textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //initializing
        progress = 0;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        stringArray = getResources().getStringArray(stringArrayId[progress]); //questions
        textView = new TextView[9];
        spinner = new Spinner[9];
        analysis = new int[9]; //value to get type of user
        values = new int[9]; //when user check the value of spinner, store to this.
        topbar = (TextView) findViewById(R.id.topbar); //show user how it progressed
        topbar.setText(getString(topbarId[progress]));
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        Button next = (Button) findViewById(R.id.next);

        for (int i = 0; i < 9; i++) { // initializing arraies
            textView[i] = new TextView(this);
            textView[i] = (TextView) findViewById(textViewId[i]);
            textView[i].setText(stringArray[i]);
            spinner[i] = new Spinner(this);
            spinner[i] = (Spinner) findViewById(spinnerId[i]);
            spinner[i].setId(i);
            spinner[i].setAdapter(adapter);
            spinner[i].setOnItemSelectedListener(mOnItemSelectedListener);
            analysis[i] = 0;
            values[i] = 0;
        }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //is it progressed enough?
                if (progress == 20) { //yes
                    int first = 0; //number of type the biggest one
                    int second = 0; //number of type the second biggest one
                    int firstWeight = 0; //weight of type the biggest one
                    int secondWeight = 0; //weight of type the second biggest one

                    for (int i = 0; i < 9; i++) {
                        if (firstWeight < analysis[i]) {
                            first = i;
                            firstWeight = analysis[i];
                            continue;
                        }
                        if (secondWeight < analysis[i]) {
                            second = i;
                            secondWeight = analysis[i];
                        }
                    }

                    Intent i = new Intent(getApplicationContext(), Result.class);

                    Bundle bundle = new Bundle();
                    bundle.putInt("first", first);
                    bundle.putInt("second", first);
                    i.putExtras(bundle);

                    startActivity(i);
                } else { //not enough
                    for (int i = 0; i < 9; i++) { //check all question checked
                        if (values[i] == 0) {
                            new AlertDialog.Builder(Main.this).setMessage(i + "번 선택하지 않은 항목이 있습니다.")
                                    .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dlg, int sumthin) {

                                        }
                                    }).show();
                            return;
                        }
                    }


                    for (int i = 0; i < 9; i++) {
                        //summarize the value
                        analysis[i] += values[i];
                        //initialize
                        values[i] = 0;
                        spinner[i].setSelection(0);
                    }

                    progress++;

                    //setting next page
                    scrollView.smoothScrollTo(0, 0);
                    stringArray = null;
                    stringArray = getResources().getStringArray(stringArrayId[progress]);

                    topbar.setText(getString(topbarId[progress]));
                    for (int i = 0; i < 9; i++) {
                        textView[i].setText(stringArray[i]);
                    }
                }
            }
        });
    }

    private AdapterView.OnItemSelectedListener mOnItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Spinner spinner = (Spinner) parent;

            switch (spinner.getId()) { //Wanna find more simple method :-(
                case 0:
                    values[0] = position;
                    break;
                case 1:
                    values[1] = position;
                    break;
                case 2:
                    values[2] = position;
                    break;
                case 3:
                    values[3] = position;
                    break;
                case 4:
                    values[4] = position;
                    break;
                case 5:
                    values[5] = position;
                    break;
                case 6:
                    values[6] = position;
                    break;
                case 7:
                    values[7] = position;
                    break;
                case 8:
                    values[8] = position;
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

