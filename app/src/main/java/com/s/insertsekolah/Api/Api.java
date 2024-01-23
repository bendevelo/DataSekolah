package com.s.insertsekolah.Api;

import com.s.insertsekolah.Api.model.sekolah;
import com.s.insertsekolah.Api.respon.Respon;
import com.s.insertsekolah.Api.respon.ResponString;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface Api {

    @GET("tipe")
    Call<ResponString> getTipeSekolah();

    @GET("provinsi")
    Call<ResponString> getProvinsi();

    @GET("provinsi/{id}")
    Call<ResponString> getKotabyID(@Path("id") String id);


    @GET("sekolah")
    Call<Respon> getDataSekolah();

    @Multipart
    @POST("sekolah")
    Call<Respon> registerSekolah(@Part("tipe") RequestBody tipe,
            @Part("nama") RequestBody nama,
            @Part("alamat") RequestBody alamat,
            @Part("pos") RequestBody pos,
            @Part("provinsi") RequestBody provinsi,
            @Part("kota") RequestBody kota,
            @Part("telphone") RequestBody telphone,
            @Part("email") RequestBody email,
            @Part("facebook") RequestBody facebook,
            @Part("jumlah") RequestBody jumlah);


   }
