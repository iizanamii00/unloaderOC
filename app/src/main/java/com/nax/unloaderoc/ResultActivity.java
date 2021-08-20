package com.nax.unloaderoc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.nax.unloaderoc.models.ResultItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ResultRecyclerAdapter adapter;
    private TextView total;
    String CPU, GPU, mobo, PSU, RAM, SSD, HDD, Case;
    double cpuPrice, gpuPrice, moboPrice, PSUPrice, RAMPrice, SSDPrice, HDDPrice, CasePrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        SharedPreferences sp = getSharedPreferences("myFile", MODE_PRIVATE);
        boolean flag = sp.getBoolean("emailFlag", false);

        CPU = getIntent().getStringExtra("CPU");
        GPU = getIntent().getStringExtra("GPU");
        mobo = getIntent().getStringExtra("Mobo");
        PSU = getIntent().getStringExtra("PSU");
        RAM = getIntent().getStringExtra("RAM");
        SSD = getIntent().getStringExtra("SSD");
        HDD = getIntent().getStringExtra("HDD");
        Case = getIntent().getStringExtra("Case");

        cpuPrice = getIntent().getDoubleExtra("CPU Price", 0);
        gpuPrice = getIntent().getDoubleExtra("GPU Price", 0);
        moboPrice = getIntent().getDoubleExtra("Mobo Price", 0);
        PSUPrice = getIntent().getDoubleExtra("PSU Price", 0);
        RAMPrice = getIntent().getDoubleExtra("RAM Price", 0);
        SSDPrice = getIntent().getDoubleExtra("SSD Price", 0);
        HDDPrice = getIntent().getDoubleExtra("HDD Price", 0);
        CasePrice = getIntent().getDoubleExtra("Case Price", 0);

        double tots = cpuPrice + gpuPrice + moboPrice + PSUPrice + RAMPrice + SSDPrice + HDDPrice + CasePrice;

        recyclerView = findViewById(R.id.recycler);
        adapter = new ResultRecyclerAdapter(this, getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        total = findViewById(R.id.total);
        total.setText("Total: Rs. " + tots);

        if (flag) {
            String id = sp.getString("emailID", "");
            Intent email = new Intent(Intent.ACTION_SEND);
            email.putExtra(Intent.EXTRA_EMAIL, new String[]{ id});
            email.putExtra(Intent.EXTRA_SUBJECT, "PC Parts that you selected!");
            email.putExtra(Intent.EXTRA_TEXT, "" + CPU + ", Rs. " + cpuPrice + "\n" + GPU + ", Rs. " + gpuPrice + "\n" + mobo + ", Rs. " + moboPrice + "\n" + PSU + ", Rs. " + PSUPrice
                    + "\n" + RAM + ", Rs. " + RAMPrice  + "\n" + SSD + ", Rs. " + SSDPrice + "\n" + HDD + ", Rs. " + HDDPrice + "\n" + Case + ", Rs. " + CasePrice);

            email.setType("message/rfc822");

            startActivity(Intent.createChooser(email, "Choose an Email client :"));
        }
    }

    public List<ResultItem> getData() {
        List<ResultItem> data = new ArrayList<>();
        int[] icons = {R.drawable.cpu, R.drawable.gpu, R.drawable.mobo, R.drawable.psu, R.drawable.ram, R.drawable.ssd, R.drawable.hdd, R.drawable.cases};
        String[] names = {CPU, GPU, mobo, PSU, RAM, SSD, HDD, Case};
        double[] prices = {cpuPrice, gpuPrice, moboPrice, PSUPrice, RAMPrice, SSDPrice, HDDPrice, CasePrice};
        for (int i = 0; i < icons.length; i++) {
            ResultItem current = new ResultItem();
            current.setIconid(icons[i]);
            current.setPrice(prices[i]);
            current.setName(names[i]);
            data.add(current);
        }
        return data;
    }
}