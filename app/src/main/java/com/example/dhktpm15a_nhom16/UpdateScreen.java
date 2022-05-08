package com.example.dhktpm15a_nhom16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Iterator;

public class UpdateScreen extends AppCompatActivity {

    DataNhanVien dataNhanVien;
    EditText txtUpdateName,txtUpdatePosition,txtUpdateAge,txtUpdateCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_screen);

        dataNhanVien = new DataNhanVien(this,"nhanviendb.sqlite",null,1);

        txtUpdateName = findViewById(R.id.txtUpdateName);
        txtUpdatePosition = findViewById(R.id.txtUpdatePosition);
        txtUpdateAge = findViewById(R.id.txtUpdateAge);
        txtUpdateCountry = findViewById(R.id.txtUpdateCountry);

        //nút <- trong main screen
        findViewById(R.id.btnBack2).setOnClickListener(view -> {
            Intent intent = new Intent(UpdateScreen.this, MainScreen.class);
            startActivity(intent);
        });

        Intent intent = getIntent();
        int id = intent.getIntExtra("id",-1);

        NhanVien nhanVien = dataNhanVien.getNVById(id+1);

        txtUpdateName.setText(nhanVien.getName());
        txtUpdatePosition.setText(nhanVien.getPosition());
        txtUpdateAge.setText(nhanVien.getAge()+"");
        txtUpdateCountry.setText(nhanVien.getCountry());

//        findViewById(R.id.btnRemove).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

    }
}