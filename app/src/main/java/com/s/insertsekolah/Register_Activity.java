package com.s.insertsekolah;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.s.insertsekolah.Api.Api;
import com.s.insertsekolah.Api.RetroClient;
import com.s.insertsekolah.Api.model.sekolah;
import com.s.insertsekolah.Api.respon.Respon;
import com.s.insertsekolah.Api.respon.ResponString;
import com.s.insertsekolah.Api.util.InputFilterMinMax;
import com.s.insertsekolah.databinding.ActivityRegisterBinding;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register_Activity extends AppCompatActivity {

    private ActivityRegisterBinding binding;

    String[] tipe;
    List<ResponString.Data> dataTipe;
    List<ResponString.Data> dataProvinsi;

    List<ResponString.Data> dataKota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        getSupportActionBar().setTitle("Register Sekolah");

       getTipe();
       getProvinsi();

        binding.jumlahsiswa.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "100")});

       binding.save.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               if(binding.tipesekolah.getText().toString().isEmpty() || binding.namasekolah.getText().toString().isEmpty() ||
               binding.alamatRegis.getText().toString().isEmpty() || binding.kodepos.getText().toString().isEmpty() || binding.provinsi.getText().toString().isEmpty() || binding.kota.getText().toString().isEmpty()
                       || binding.telp.getText().toString().isEmpty() || binding.email.getText().toString().isEmpty() || binding.jumlahsiswa.getText().toString().isEmpty()
               ){

                   Toast.makeText(getApplicationContext(), "Kolom tidak ada yang boleh kosong", Toast.LENGTH_LONG).show();
               } else if(!isValidEmail( binding.email.getText().toString())) {
                   Toast.makeText(getApplicationContext(), "Alamat Email Tidak valid", Toast.LENGTH_LONG).show();
               }else {


                   RequestBody tipe = RequestBody.create(MediaType.parse("text/plain"), binding.tipesekolah.getText().toString());
                   RequestBody nama = RequestBody.create(MediaType.parse("text/plain"), binding.namasekolah.getText().toString());
                   RequestBody alamat = RequestBody.create(MediaType.parse("text/plain"), binding.alamatRegis.getText().toString());
                   RequestBody pos = RequestBody.create(MediaType.parse("text/plain"), binding.kodepos.getText().toString());
                   RequestBody provinsi = RequestBody.create(MediaType.parse("text/plain"), binding.provinsi.getText().toString());
                   RequestBody kota = RequestBody.create(MediaType.parse("text/plain"), binding.kota.getText().toString());
                   RequestBody telp = RequestBody.create(MediaType.parse("text/plain"), binding.telp.getText().toString());
                   RequestBody email = RequestBody.create(MediaType.parse("text/plain"), binding.email.getText().toString());
                   RequestBody facebook = RequestBody.create(MediaType.parse("text/plain"), binding.facebook.getText().toString());
                   RequestBody jumlah = RequestBody.create(MediaType.parse("text/plain"), binding.jumlahsiswa.getText().toString());

                   Api api = RetroClient.getApiServices();
                   Call<Respon> call = api.registerSekolah(tipe,nama,alamat,pos,provinsi,kota,telp,email,facebook,jumlah);
                   call.enqueue(new Callback<Respon>() {
                       @Override
                       public void onResponse(Call<Respon> call, Response<Respon> response) {
                           if(response.body().getStatus()==1){
                               Toast.makeText(getApplicationContext(), "Berhasil Menambahkan DATA", Toast.LENGTH_LONG).show();

                           }else {
                               Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                           }

                       }

                       @Override
                       public void onFailure(Call<Respon> call, Throwable t) {
                           Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                       }
                   });

               }

           }
       });



        binding.provinsi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();

                getKota(dataProvinsi.get(i).getId());


            }
        });

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

    void getTipe(){
        Api api = RetroClient.getApiServices();
        Call<ResponString> call = api.getTipeSekolah();
        call.enqueue(new Callback<ResponString>() {
            @Override
            public void onResponse(Call<ResponString> call, Response<ResponString> response) {

                dataTipe = response.body().getData();
                tipe = new String[dataTipe.size()];
                for (int i = 0; i < dataTipe.size(); i++) {
                    tipe[i] = dataTipe.get(i).getName();
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.select_dialog_singlechoice, tipe);

                binding.tipesekolah.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ResponString> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                System.out.println("erornya" + t);

            }


        });

    }

    void getProvinsi(){
        Api api = RetroClient.getApiServices();
        Call<ResponString> call = api.getProvinsi();
        call.enqueue(new Callback<ResponString>() {
            @Override
            public void onResponse(Call<ResponString> call, Response<ResponString> response) {

                dataProvinsi = response.body().getData();
                tipe = new String[dataProvinsi.size()];
                for (int i = 0; i < dataProvinsi.size(); i++) {
                    tipe[i] = dataProvinsi.get(i).getName();
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.select_dialog_singlechoice, tipe);

                binding.provinsi.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ResponString> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                System.out.println("erornya" + t);

            }


        });

    }

    void getKota(String ID){
        Api api = RetroClient.getApiServices();
        Call<ResponString> call = api.getKotabyID(ID);
        call.enqueue(new Callback<ResponString>() {
            @Override
            public void onResponse(Call<ResponString> call, Response<ResponString> response) {

                dataKota = response.body().getData();
                tipe = new String[dataKota.size()];
                for (int i = 0; i < dataKota.size(); i++) {
                    tipe[i] = dataKota.get(i).getNama();
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.select_dialog_singlechoice, tipe);

                binding.kota.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ResponString> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                System.out.println("erornya" + t);

            }


        });

    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}