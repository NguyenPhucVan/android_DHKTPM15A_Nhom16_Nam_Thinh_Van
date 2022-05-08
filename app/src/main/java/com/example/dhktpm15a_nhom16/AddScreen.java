package com.example.dhktpm15a_nhom16;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddScreen extends AppCompatActivity {

    EditText txtAddName, txtAddPosition,txtAddAge, txtAddCountry;
    DataNhanVien dataNhanVien;
    NhanVien nhanVien;
    ArrayList NVList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_screen);

        dataNhanVien = new DataNhanVien(this,"nhanviendb.sqlite",null,1);

        //nút <- trong main screen
        findViewById(R.id.btnBack1).setOnClickListener(view -> {
            Intent intent = new Intent(AddScreen.this, MainScreen.class);
            startActivity(intent);
        });

        //nút thêm nhân viên
        findViewById(R.id.btnAddNV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtAddName = findViewById(R.id.txtAddName);
                txtAddPosition = findViewById(R.id.txtAddPosition);
                txtAddAge = findViewById(R.id.txtAddAge);
                txtAddCountry = findViewById(R.id.txtAddCountry);

                nhanVien = new NhanVien(txtAddName.getText().toString(),txtAddPosition.getText().toString()
                        ,Integer.parseInt(txtAddAge.getText().toString()),txtAddCountry.getText().toString());

                dataNhanVien.addNhanVien(nhanVien);
                Toast.makeText(AddScreen.this, "Thêm nhân viên thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AddScreen.this, MainScreen.class);
                startActivity(intent);
            }
        });

    }
}