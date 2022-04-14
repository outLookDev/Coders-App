package com.gidzero.coders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.hardware.lights.LightsManager;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class CoderActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CodeAdapter codeAdapter;
    List<CodersModel> codersModels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coder);

        recyclerView =findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView.setHasFixedSize(true);


        codersModels=new ArrayList<>();
        codersModels.add(new CodersModel(R.drawable.code,"12","21"));
        codersModels.add(new CodersModel(R.drawable.code,"23","32"));
        codersModels.add(new CodersModel(R.drawable.code,"43","34"));
        codersModels.add(new CodersModel(R.drawable.code,"24","42"));
        codersModels.add(new CodersModel(R.drawable.code,"25","52"));
        codersModels.add(new CodersModel(R.drawable.code,"26","62"));
        codersModels.add(new CodersModel(R.drawable.code,"27","72"));

        codeAdapter =new CodeAdapter(codersModels,this);
        recyclerView.setAdapter(codeAdapter);
    }
}