package com.example.review;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView rv;
    ArrayList<String> sno,date,pkg,price,status,code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.rv);
        sno=new ArrayList<>();
        price=new ArrayList<>();
        code=new ArrayList<>();
        sno.add("1");sno.add("2");
        code.add("hghn-86hnjb-576hnbv");code.add("bvnm-23dsc23-7689jkjk");
        price.add("40.00");price.add("789.00");
        ClipboardManager clipboardManager=(ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        myAdapter ad=new myAdapter(getApplicationContext(),clipboardManager,sno,code,price);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(ad);

    }
}