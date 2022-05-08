package com.example.dhktpm15a_nhom16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;

public class MainScreen extends AppCompatActivity {

    DataNhanVien dataNhanVien;
    ListView lvNhanVien;
    NhanVienAdapter adapter;
    ArrayList<NhanVien> NVList;
    ArrayList idList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        dataNhanVien = new DataNhanVien(this,"nhanviendb.sqlite",null,1);

        lvNhanVien = findViewById(R.id.listview);

        NVList = new ArrayList();
        idList = new ArrayList();

        getNVList();

        adapter = new NhanVienAdapter(this, R.layout.nhanvien_listview,NVList);
        lvNhanVien.setAdapter(adapter);


        //nút + trong main screen
        findViewById(R.id.btnAdd).setOnClickListener(view -> {
            Intent intent = new Intent(MainScreen.this, AddScreen.class);
            startActivity(intent);
        });

    }
    //Lấy nhân viên từ sqlite
    private ArrayList getNVList(){
        NVList.clear();
        for (Iterator iterator = dataNhanVien.getAll().iterator(); iterator.hasNext(); ) {
            NhanVien nhanVien = (NhanVien) iterator.next();
            NVList.add(nhanVien);
        }
        return NVList;
    }
}
