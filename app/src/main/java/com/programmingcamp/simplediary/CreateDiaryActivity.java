package com.programmingcamp.simplediary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CreateDiaryActivity extends AppCompatActivity implements View.OnClickListener {

    TextView lblDiaryDate, lblDiaryContent;
    EditText txtDiaryDate, txtDiaryContent;

    Button btnSave, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_diary);

        lblDiaryDate = (TextView) findViewById(R.id.lblDiaryDate);
        lblDiaryContent = (TextView) findViewById(R.id.lblDiaryContent);

        txtDiaryDate = (EditText) findViewById(R.id.txtDiaryDate);
        txtDiaryContent = (EditText) findViewById(R.id.txtDiaryContent);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnClear = (Button) findViewById(R.id.btnClear);

        btnSave.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View button) {
        if(button.getId() == btnSave.getId()){
            DiaryModel diaryModel = new DiaryModel();
            diaryModel.setDiaryDate(txtDiaryDate.getText().toString());
            diaryModel.setDiaryContent(txtDiaryContent.getText().toString());

            DBHelper dbHelper = new DBHelper(this);
            dbHelper.SaveDiary(diaryModel);

            Toast.makeText(this, "Diary Saved", Toast.LENGTH_LONG).show();
        }
        else if(button.getId() == btnClear.getId()){
            txtDiaryDate.setText("");
            txtDiaryContent.setText("");
        }
    }
}
