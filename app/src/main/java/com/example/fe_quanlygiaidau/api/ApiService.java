package com.example.fe_quanlygiaidau.api;

import com.example.fe_quanlygiaidau.model.BangDau;
import com.example.fe_quanlygiaidau.model.BangXepHangVongLoai;
import com.example.fe_quanlygiaidau.model.CauThu;
import com.example.fe_quanlygiaidau.model.CauThuGiaiDau;
import com.example.fe_quanlygiaidau.model.DoiBong;
import com.example.fe_quanlygiaidau.model.Giaidau;
import com.example.fe_quanlygiaidau.model.KetQuaTranDau;
import com.example.fe_quanlygiaidau.model.TranDau;
import com.example.fe_quanlygiaidau.model.TrongTai;
import com.example.fe_quanlygiaidau.model.ViTriCauThu;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiService {

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd")
            .create();
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://192.168.1.22:4002/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @GET("giai_dau")
    Call<List<Giaidau>> getListGiaiDau();

    @GET("bang_dau")
    Call<List<BangDau>> getListBangDau();

    @GET("cau_thu")
    Call<List<CauThu>> getListCauThu();

    @GET("cau_thu_giai_dau")
    Call<List<CauThuGiaiDau>> getListCauThuGiaiDau();

    @GET("doi_bong")
    Call<List<DoiBong>> getListDoiBong();

    @GET("ket_qua_tran_dau")
    Call<List<KetQuaTranDau>> getListKetQuaTranDau();

    @GET("tran_dau")
    Call<List<TranDau>> getListTranDau();

    @GET("trong_tai")
    Call<List<TrongTai>> getListTrongTai();

    @GET("vi_tri_cau_thu")
    Call<List<ViTriCauThu>> getListViTriCauThu();

    @GET("xep_hang_vong_loai")
    Call<List<BangXepHangVongLoai>> getListXepHangVongLoai();
}
