package com.example.dhktpm15a_nhom16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class UpdateScreen extends AppCompatActivity {

    DataNhanVien dataNhanVien;
    EditText txtUpdateName,txtUpdatePosition,txtUpdateAge,txtUpdateCountry;
    ArrayList<NhanVien> NVList;
    NhanVien nhanVienMoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_screen);

        dataNhanVien = new DataNhanVien(this,"nhanviendb.sqlite",null,1);

        txtUpdateName = findViewById(R.id.txtUpdateName);
        txtUpdatePosition = findViewById(R.id.txtUpdatePosition);
        txtUpdateAge = findViewById(R.id.txtUpdateAge);
        txtUpdateCountry = findViewById(R.id.txtUpdateCountry);

        NVList = new ArrayList<>();

        //nút <- trong main screen
        findViewById(R.id.btnBack2).setOnClickListener(view -> {
            Intent intent = new Intent(UpdateScreen.this, MainScreen.class);
            startActivity(intent);
        });

        Intent intent = getIntent();
        int id = intent.getIntExtra("id",-1);

        NhanVien nhanVien = dataNhanVien.getNVById(id);

        txtUpdateName.setText(nhanVien.getName());
        txtUpdatePosition.setText(nhanVien.getPosition());
        txtUpdateAge.setText(nhanVien.getAge()+"");
        txtUpdateCountry.setText(nhanVien.getCountry());

        findViewById(R.id.btnRemove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataNhanVien.removeNhanVien(id);
                getNVList();
                Toast.makeText(UpdateScreen.this, "Xóa nhân viên thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UpdateScreen.this, MainScreen.class);
                startActivity(intent);
            }
        });



        findViewById(R.id.btnUpdate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                txtUpdateName.setText(nhanVien.getName());
//                txtUpdatePosition.setText(nhanVien.getPosition());
//                txtUpdateAge.setText(nhanVien.getAge()+"");
//                txtUpdateCountry.setText(nhanVien.getCountry());
//                txtUpdateName = findViewById(R.id.txtUpdateName);
//                txtUpdatePosition = findViewById(R.id.txtUpdatePosition);
//                txtUpdateAge = findViewById(R.id.txtUpdateAge);
//                txtUpdateCountry = findViewById(R.id.txtUpdateCountry);

                System.out.println("_---------------------------"+txtUpdatePosition.getText().toString());

                nhanVienMoi = new NhanVien(id,txtUpdateName.getText().toString(),txtUpdatePosition.getText().toString()
                                ,Integer.parseInt(txtUpdateAge.getText().toString()),txtUpdateCountry.getText().toString());
                dataNhanVien.updateNhanVien(nhanVienMoi);
                //getNVList();
                Toast.makeText(UpdateScreen.this, "Cập nhật nhân viên thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UpdateScreen.this, MainScreen.class);
                startActivity(intent);
            }
        });

    }
    private ArrayList getNVList(){
        NVList.clear();
        for (Iterator iterator = dataNhanVien.getAll().iterator(); iterator.hasNext(); ) {
            NhanVien nhanVien = (NhanVien) iterator.next();
            NVList.add(nhanVien);
        }
        return NVList;
    }
}