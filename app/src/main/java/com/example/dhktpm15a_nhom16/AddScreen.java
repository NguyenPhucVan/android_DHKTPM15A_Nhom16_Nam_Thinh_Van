package com.example.dhktpm15a_nhom16;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;

public class AddScreen extends AppCompatActivity {

    Button btnAddNV;
    EditText txtAddNameNV,txtAddAgeNV;
    DataNhanVien dataNhanVien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_screen);

//        txtAddNameNV = findViewById(R.id.txtAddNameNV);
//        txtAddAgeNV = findViewById(R.id.txtAddAgeNV);

      //  dataNhanVien = new DataNhanVien(this,"nhanviendb.sqlite",null,1);

//        findViewById(R.id.btn_AddNV).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dataNhanVien.addNhanVien(new NhanVien(txtAddNameNV.getText().toString(),txtAddAgeNV.getText().toString(),imgAddNV.getImage));
//                getNameList();
//                adapter.notifyDataSetChanged();
//            }
//        });
    }
}