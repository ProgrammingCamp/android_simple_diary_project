package com.programmingcamp.simplediary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnShowCreate, btnShowSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowCreate = (Button) findViewById(R.id.btnShowCreate);
        btnShowSearch = (Button) findViewById(R.id.btnShowSearch);

        btnShowCreate.setOnClickListener(this);
        btnShowSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View button) {
        if(button.getId() == btnShowCreate.getId()){
            Intent intent = new Intent(this, CreateDiaryActivity.class);
            startActivity(intent);
        }
        else if(button.getId() == btnShowSearch.getId()){
            Intent intent = new Intent(this, SearchDiaryActivity.class);
            startActivity(intent);
        }
    }
}
