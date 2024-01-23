package com.s.insertsekolah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.s.insertsekolah.databinding.ActivityDetailBinding;
import com.s.insertsekolah.databinding.ActivityRegisterBinding;

public class Detail_Activity extends AppCompatActivity {


    private ActivityDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        getSupportActionBar().setTitle("Detail Sekolah");


        binding.Nama.setText(getIntent().getStringExtra("nama"));
        binding.tipesekolah.setText(getIntent().getStringExtra("tipe"));
        binding.Alamat.setText(getIntent().getStringExtra("alamat"));
        binding.provinsi.setText(getIntent().getStringExtra("provinsi"));
        binding.kota.setText(getIntent().getStringExtra("kota"));
        binding.poskode.setText(getIntent().getStringExtra("pos"));
        binding.email.setText(getIntent().getStringExtra("email"));
        binding.Nohp.setText(getIntent().getStringExtra("telpon"));
        binding.facebook.setText(getIntent().getStringExtra("facebook"));
        binding.jumlah.setText(getIntent().getStringExtra("jumlah"));


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
}