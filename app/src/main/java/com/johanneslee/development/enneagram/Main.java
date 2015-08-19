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
    String[] items = {"0", "1", "2", "3", "4", "5"};
    Button next;
    ArrayAdapter<String> adapter;
    private int[] analysis;
    private int[] values;
    private int progress;
    private int first;
    private int second;
    private ScrollView sv;
    private Spinner sel1;
    private Spinner sel2;
    private Spinner sel3;
    private Spinner sel4;
    private Spinner sel5;
    private Spinner sel6;
    private Spinner sel7;
    private Spinner sel8;
    private Spinner sel9;
    private TextView question1;
    private TextView question2;
    private TextView question3;
    private TextView question4;
    private TextView question5;
    private TextView question6;
    private TextView question7;
    private TextView question8;
    private TextView question9;
    private TextView topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //initializing
        init();

        //events
        spinnersEvents(); //spinner events
        next.setOnClickListener(new View.OnClickListener() { //button event
            @Override
            public void onClick(View v) {
                //is event progressed enough?
                if(progress == 20) {
                    calculate();

                    Intent i = new Intent(getApplicationContext(), Result.class);

                    Bundle bundle = new Bundle();
                    bundle.putInt("first", first);
                    bundle.putInt("second", first);
                    i.putExtras(bundle);

                    startActivity(i);
                } else {
                    //do progressing
                    progressing();
                }
            }
        });
    }

    public void init() {
        progress = 0;

        analysis = new int[9];
        values = new int[9];
        for(int i=0;i<9;i++){
            analysis[i] = 0;
            values[i] = 0;
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);

        sel1 = (Spinner) findViewById(R.id.sel1);
        sel1.setAdapter(adapter);
        sel2 = (Spinner) findViewById(R.id.sel2);
        sel2.setAdapter(adapter);
        sel3 = (Spinner) findViewById(R.id.sel3);
        sel3.setAdapter(adapter);
        sel4 = (Spinner) findViewById(R.id.sel4);
        sel4.setAdapter(adapter);
        sel5 = (Spinner) findViewById(R.id.sel5);
        sel5.setAdapter(adapter);
        sel6 = (Spinner) findViewById(R.id.sel6);
        sel6.setAdapter(adapter);
        sel7 = (Spinner) findViewById(R.id.sel7);
        sel7.setAdapter(adapter);
        sel8 = (Spinner) findViewById(R.id.sel8);
        sel8.setAdapter(adapter);
        sel9 = (Spinner) findViewById(R.id.sel9);
        sel9.setAdapter(adapter);

        question1 = (TextView) findViewById(R.id.qText1);
        question2 = (TextView) findViewById(R.id.qText2);
        question3 = (TextView) findViewById(R.id.qText3);
        question4 = (TextView) findViewById(R.id.qText4);
        question5 = (TextView) findViewById(R.id.qText5);
        question6 = (TextView) findViewById(R.id.qText6);
        question7 = (TextView) findViewById(R.id.qText7);
        question8 = (TextView) findViewById(R.id.qText8);
        question9 = (TextView) findViewById(R.id.qText9);

        next = (Button) findViewById(R.id.next);
        topbar = (TextView) findViewById(R.id.topbar);
        sv = (ScrollView) findViewById(R.id.sv);
    }

    public void spinnersEvents() {
        sel1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                values[0] = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sel2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                values[1] = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sel3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                values[2] = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sel4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                values[3] = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sel5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                values[4] = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sel6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                values[5] = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sel7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                values[6] = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sel8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                values[7] = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sel9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                values[8] = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void progressing() {
        //exception handling
        for (int i = 0; i < 9; i++) {
            if (values[i] == 0) {
                new AlertDialog.Builder(this).setMessage("선택하지 않은 항목이 있습니다.").setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dlg, int sumthin) {

                    }
                }).show();
                return;
            }
        }

        //testing is been progressed
        for (int i = 0; i < 9; i++) {
            analysis[i] += values[i];
            values[i] = 0;
        }

        progress++;

        //spinners init
        sel1.setSelection(0);
        sel2.setSelection(0);
        sel3.setSelection(0);
        sel4.setSelection(0);
        sel5.setSelection(0);
        sel6.setSelection(0);
        sel7.setSelection(0);
        sel8.setSelection(0);
        sel9.setSelection(0);

        //page init
        sv.smoothScrollTo(0, 0);
        nextPage();
    }

    public void nextPage() {
        switch(progress){
            case 1:
                topbar.setText(getString(R.string.page2));
                question1.setText(getString(R.string.question10));
                question2.setText(getString(R.string.question11));
                question3.setText(getString(R.string.question12));
                question4.setText(getString(R.string.question13));
                question5.setText(getString(R.string.question14));
                question6.setText(getString(R.string.question15));
                question7.setText(getString(R.string.question16));
                question8.setText(getString(R.string.question17));
                question9.setText(getString(R.string.question18));
                break;
            case 2:
                topbar.setText(getString(R.string.page3));
                question1.setText(getString(R.string.question19));
                question2.setText(getString(R.string.question20));
                question3.setText(getString(R.string.question21));
                question4.setText(getString(R.string.question22));
                question5.setText(getString(R.string.question23));
                question6.setText(getString(R.string.question24));
                question7.setText(getString(R.string.question25));
                question8.setText(getString(R.string.question26));
                question9.setText(getString(R.string.question27));
                break;
            case 3:
                topbar.setText(getString(R.string.page4));
                question1.setText(getString(R.string.question28));
                question2.setText(getString(R.string.question29));
                question3.setText(getString(R.string.question30));
                question4.setText(getString(R.string.question31));
                question5.setText(getString(R.string.question32));
                question6.setText(getString(R.string.question33));
                question7.setText(getString(R.string.question34));
                question8.setText(getString(R.string.question35));
                question9.setText(getString(R.string.question36));
                break;
            case 4:
                topbar.setText(getString(R.string.page5));
                question1.setText(getString(R.string.question37));
                question2.setText(getString(R.string.question38));
                question3.setText(getString(R.string.question39));
                question4.setText(getString(R.string.question40));
                question5.setText(getString(R.string.question41));
                question6.setText(getString(R.string.question42));
                question7.setText(getString(R.string.question43));
                question8.setText(getString(R.string.question44));
                question9.setText(getString(R.string.question45));
                break;
            case 5:
                topbar.setText(getString(R.string.page6));
                question1.setText(getString(R.string.question46));
                question2.setText(getString(R.string.question47));
                question3.setText(getString(R.string.question48));
                question4.setText(getString(R.string.question49));
                question5.setText(getString(R.string.question50));
                question6.setText(getString(R.string.question51));
                question7.setText(getString(R.string.question52));
                question8.setText(getString(R.string.question53));
                question9.setText(getString(R.string.question54));
                break;
            case 6:
                topbar.setText(getString(R.string.page7));
                question1.setText(getString(R.string.question55));
                question2.setText(getString(R.string.question56));
                question3.setText(getString(R.string.question57));
                question4.setText(getString(R.string.question58));
                question5.setText(getString(R.string.question59));
                question6.setText(getString(R.string.question60));
                question7.setText(getString(R.string.question61));
                question8.setText(getString(R.string.question62));
                question9.setText(getString(R.string.question63));
                break;
            case 7:
                topbar.setText(getString(R.string.page8));
                question1.setText(getString(R.string.question64));
                question2.setText(getString(R.string.question65));
                question3.setText(getString(R.string.question66));
                question4.setText(getString(R.string.question67));
                question5.setText(getString(R.string.question68));
                question6.setText(getString(R.string.question69));
                question7.setText(getString(R.string.question70));
                question8.setText(getString(R.string.question71));
                question9.setText(getString(R.string.question72));
                break;
            case 8:
                topbar.setText(getString(R.string.page9));
                question1.setText(getString(R.string.question73));
                question2.setText(getString(R.string.question74));
                question3.setText(getString(R.string.question75));
                question4.setText(getString(R.string.question76));
                question5.setText(getString(R.string.question77));
                question6.setText(getString(R.string.question78));
                question7.setText(getString(R.string.question79));
                question8.setText(getString(R.string.question80));
                question9.setText(getString(R.string.question81));
                break;
            case 9:
                topbar.setText(getString(R.string.page10));
                question1.setText(getString(R.string.question82));
                question2.setText(getString(R.string.question83));
                question3.setText(getString(R.string.question84));
                question4.setText(getString(R.string.question85));
                question5.setText(getString(R.string.question86));
                question6.setText(getString(R.string.question87));
                question7.setText(getString(R.string.question88));
                question8.setText(getString(R.string.question89));
                question9.setText(getString(R.string.question90));
                break;
            case 10:
                topbar.setText(getString(R.string.page11));
                question1.setText(getString(R.string.question91));
                question2.setText(getString(R.string.question92));
                question3.setText(getString(R.string.question93));
                question4.setText(getString(R.string.question94));
                question5.setText(getString(R.string.question95));
                question6.setText(getString(R.string.question96));
                question7.setText(getString(R.string.question97));
                question8.setText(getString(R.string.question98));
                question9.setText(getString(R.string.question99));
                break;
            case 11:
                topbar.setText(getString(R.string.page12));
                question1.setText(getString(R.string.question100));
                question2.setText(getString(R.string.question101));
                question3.setText(getString(R.string.question102));
                question4.setText(getString(R.string.question103));
                question5.setText(getString(R.string.question104));
                question6.setText(getString(R.string.question105));
                question7.setText(getString(R.string.question106));
                question8.setText(getString(R.string.question107));
                question9.setText(getString(R.string.question108));
                break;
            case 12:
                topbar.setText(getString(R.string.page13));
                question1.setText(getString(R.string.question109));
                question2.setText(getString(R.string.question110));
                question3.setText(getString(R.string.question111));
                question4.setText(getString(R.string.question112));
                question5.setText(getString(R.string.question113));
                question6.setText(getString(R.string.question114));
                question7.setText(getString(R.string.question115));
                question8.setText(getString(R.string.question116));
                question9.setText(getString(R.string.question117));
                break;
            case 13:
                topbar.setText(getString(R.string.page14));
                question1.setText(getString(R.string.question118));
                question2.setText(getString(R.string.question119));
                question3.setText(getString(R.string.question120));
                question4.setText(getString(R.string.question121));
                question5.setText(getString(R.string.question122));
                question6.setText(getString(R.string.question123));
                question7.setText(getString(R.string.question124));
                question8.setText(getString(R.string.question125));
                question9.setText(getString(R.string.question126));
                break;
            case 14:
                topbar.setText(getString(R.string.page15));
                question1.setText(getString(R.string.question127));
                question2.setText(getString(R.string.question128));
                question3.setText(getString(R.string.question129));
                question4.setText(getString(R.string.question130));
                question5.setText(getString(R.string.question131));
                question6.setText(getString(R.string.question132));
                question7.setText(getString(R.string.question133));
                question8.setText(getString(R.string.question134));
                question9.setText(getString(R.string.question135));
                break;
            case 15:
                topbar.setText(getString(R.string.page16));
                question1.setText(getString(R.string.question136));
                question2.setText(getString(R.string.question137));
                question3.setText(getString(R.string.question138));
                question4.setText(getString(R.string.question139));
                question5.setText(getString(R.string.question140));
                question6.setText(getString(R.string.question141));
                question7.setText(getString(R.string.question142));
                question8.setText(getString(R.string.question143));
                question9.setText(getString(R.string.question144));
                break;
            case 16:
                topbar.setText(getString(R.string.page17));
                question1.setText(getString(R.string.question145));
                question2.setText(getString(R.string.question146));
                question3.setText(getString(R.string.question147));
                question4.setText(getString(R.string.question148));
                question5.setText(getString(R.string.question149));
                question6.setText(getString(R.string.question150));
                question7.setText(getString(R.string.question151));
                question8.setText(getString(R.string.question152));
                question9.setText(getString(R.string.question153));
                break;
            case 17:
                topbar.setText(getString(R.string.page18));
                question1.setText(getString(R.string.question154));
                question2.setText(getString(R.string.question155));
                question3.setText(getString(R.string.question156));
                question4.setText(getString(R.string.question157));
                question5.setText(getString(R.string.question158));
                question6.setText(getString(R.string.question159));
                question7.setText(getString(R.string.question160));
                question8.setText(getString(R.string.question161));
                question9.setText(getString(R.string.question162));
                break;
            case 18:
                topbar.setText(getString(R.string.page19));
                question1.setText(getString(R.string.question163));
                question2.setText(getString(R.string.question164));
                question3.setText(getString(R.string.question165));
                question4.setText(getString(R.string.question166));
                question5.setText(getString(R.string.question167));
                question6.setText(getString(R.string.question168));
                question7.setText(getString(R.string.question169));
                question8.setText(getString(R.string.question170));
                question9.setText(getString(R.string.question171));
                break;
            case 19:
                topbar.setText(getString(R.string.page20));
                question1.setText(getString(R.string.question172));
                question2.setText(getString(R.string.question173));
                question3.setText(getString(R.string.question174));
                question4.setText(getString(R.string.question175));
                question5.setText(getString(R.string.question176));
                question6.setText(getString(R.string.question177));
                question7.setText(getString(R.string.question178));
                question8.setText(getString(R.string.question179));
                question9.setText(getString(R.string.question180));
                break;
        }
    }

    public void calculate() {
        first = 0;
        int firstWeight = 0;
        second = 0;
        int secondWeight = 0;

        for (int i = 0; i < 9; i++) {
            if (firstWeight < analysis[i]) {
                first = i;
                firstWeight = analysis[i];
            } else if (secondWeight < analysis[i]) {
                second = i;
                secondWeight = analysis[i];
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}