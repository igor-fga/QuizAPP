package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnSubmit;
    private RadioGroup rg01;
    private RadioGroup rg02;
    private RadioGroup rg03;
    private RadioGroup rg04;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
    }

    public void addListenerOnButton() {

        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        rg01 = (RadioGroup) findViewById(R.id.rg01);
        rg02 = (RadioGroup) findViewById(R.id.rg03);
        rg03 = (RadioGroup) findViewById(R.id.rg04);
        rg04 = (RadioGroup) findViewById(R.id.rg05);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int result = 0;

                int selectedId01 = rg01.getCheckedRadioButtonId();
                int selectedId02 = rg02.getCheckedRadioButtonId();
                int selectedId03 = rg03.getCheckedRadioButtonId();
                int selectedId04 = rg04.getCheckedRadioButtonId();

                CheckBox chk01 = (CheckBox) findViewById(R.id.chkReturn);
                CheckBox chk02 = (CheckBox) findViewById(R.id.chkAttack);
                CheckBox chk03 = (CheckBox) findViewById(R.id.chkBeyond);

                if ((selectedId01 == -1 || selectedId02 == -1 || selectedId03 == -1 || selectedId04 == -1) ||
                        !chk01.isChecked() && !chk02.isChecked() && !chk03.isChecked()) {
                    Toast.makeText(MainActivity.this,
                            getString(R.string.AnswerAll), Toast.LENGTH_LONG).show();
                } else {


                    result += (selectedId01 == 1) ? 1 : 0;
                    result += (selectedId02 == 5) ? 1 : 0;
                    result += (selectedId03 == 8) ? 1 : 0;
                    result += (selectedId04 == 10) ? 1 : 0;

                    if (chk01.isChecked() && chk02.isChecked() && !chk03.isChecked())
                        result += 1;

                    EditText nameField = (EditText) findViewById(R.id.Name);
                    String name = nameField.getText().toString();

                    Toast.makeText(MainActivity.this,
                            name + " " + getString(R.string.Got) + " " + result + " " + getString(R.string.Ans), Toast.LENGTH_LONG).show();

                }

            }
        });

    }
}
