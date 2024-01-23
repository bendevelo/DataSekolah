package com.s.insertsekolah.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.s.insertsekolah.Api.model.sekolah;
import com.s.insertsekolah.Detail_Activity;
import com.s.insertsekolah.databinding.ListSekolahBinding;

import java.util.ArrayList;

public class AdapterSekolah extends RecyclerView.Adapter<AdapterSekolah.ViewHolder> {



    Context context;
    ArrayList<sekolah> data;

    public AdapterSekolah(Context context, ArrayList<sekolah> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ListSekolahBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        sekolah dataSekolah = data.get(position);
        holder.listSekolahBinding.Nama.setText(dataSekolah.getNama());
        holder.listSekolahBinding.Alamat.setText(dataSekolah.getAlamat());
        holder.listSekolahBinding.Nohp.setText(dataSekolah.getTelphone());
        holder.listSekolahBinding.Lin.setOnClickListener(view -> {
            Intent intent = new Intent(context, Detail_Activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("nama",dataSekolah.getNama());
            intent.putExtra("tipe",dataSekolah.getTipe());
            intent.putExtra("alamat",dataSekolah.getAlamat());
            intent.putExtra("pos",dataSekolah.getPos());
            intent.putExtra("provinsi",dataSekolah.getProvinsi());
            intent.putExtra("kota",dataSekolah.getKota());
            intent.putExtra("email",dataSekolah.getEmail());
            intent.putExtra("telpon",dataSekolah.getTelphone());
            intent.putExtra("facebook",dataSekolah.getFacebook());
            intent.putExtra("jumlah",dataSekolah.getJumlah());
            context.startActivity(intent);

        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ListSekolahBinding listSekolahBinding;

        public ViewHolder( ListSekolahBinding itemView) {
            super(itemView.getRoot());
            listSekolahBinding = itemView;
        }
    }
}
