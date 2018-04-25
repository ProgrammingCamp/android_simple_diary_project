package com.programmingcamp.simplediary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchDiaryActivity extends AppCompatActivity implements View.OnClickListener {

    TextView lblDiaryDate, lblDiaryContent;
    EditText txtDiaryDate;

    Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_diary);

        lblDiaryDate = (TextView) findViewById(R.id.lblDiaryDate);
        lblDiaryContent = (TextView) findViewById(R.id.lblDiaryContent);
        txtDiaryDate = (EditText) findViewById(R.id.txtDiaryDate);

        btnSearch = (Button) findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        DBHelper dbHelper = new DBHelper(this);
        DiaryModel diaryModel = dbHelper.SearchDiaryByDate(txtDiaryDate.getText().toString());

        if(diaryModel != null){
            lblDiaryContent.setText(diaryModel.getDiaryContent());
        }
        else{
            Toast.makeText(this, "No record found", Toast.LENGTH_LONG).show();
        }
    }
}
