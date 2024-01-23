package com.s.insertsekolah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.s.insertsekolah.Adapter.AdapterSekolah;
import com.s.insertsekolah.Api.Api;
import com.s.insertsekolah.Api.RetroClient;
import com.s.insertsekolah.Api.model.sekolah;
import com.s.insertsekolah.Api.respon.Respon;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Report_Activity extends AppCompatActivity {

    RecyclerView Recycle;
    AdapterSekolah adapterSekolah;
    ArrayList<sekolah> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        getSupportActionBar().setTitle("Report");
        Recycle = findViewById(R.id.Recycle);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        Recycle.setLayoutManager(mLayoutManager);

        getData();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24);

    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    void getData(){

        Api api = RetroClient.getApiServices();
        Call<Respon> call = api.getDataSekolah();
        call.enqueue(new Callback<Respon>() {
            @Override
            public void onResponse(Call<Respon> call, Response<Respon> response) {

                if(response.body().getStatus()==1){

                 data = response.body().getData();
                    adapterSekolah = new AdapterSekolah(getApplicationContext(),data);
                    Recycle.setAdapter(adapterSekolah);


                }else {
                    Toast.makeText(Report_Activity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Respon> call, Throwable t) {
                Toast.makeText(Report_Activity.this, t.toString(), Toast.LENGTH_SHORT).show();

            }
        });



    }
}