package com.example.fe_quanlygiaidau.layout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fe_quanlygiaidau.R;
import com.example.fe_quanlygiaidau.adapter.BangXepHang1Adapter;
import com.example.fe_quanlygiaidau.adapter.TranDau1Adapter;
import com.example.fe_quanlygiaidau.api.ApiService;
import com.example.fe_quanlygiaidau.model.BangDau;
import com.example.fe_quanlygiaidau.model.DoiBong;
import com.example.fe_quanlygiaidau.model.DoiBongGiaiDau;
import com.example.fe_quanlygiaidau.model.Giaidau;
import com.example.fe_quanlygiaidau.model.KetQuaTranDau;
import com.example.fe_quanlygiaidau.model.SanVanDong;
import com.example.fe_quanlygiaidau.model.TranDau;
import com.example.fe_quanlygiaidau.model.VongDau;
import com.example.fe_quanlygiaidau.modeladapter.BangXepHangModelAdapter;
import com.example.fe_quanlygiaidau.modeladapter.DoiBongModelAdapter;
import com.example.fe_quanlygiaidau.modeladapter.TranDauModelAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChiTietGiaidauActivity extends AppCompatActivity {
    private int apiCallCount = 0;
    private final int TOTAL_API_CALLS = 7;

    private List<VongDau> listVongDau;
    private List<TranDau> listTranDau;
    private List<SanVanDong> listSanVanDong;
    private List<TranDauModelAdapter> listTranDauGiai;
    private List<DoiBong> listDoiBong;
    private List<KetQuaTranDau> listKetQuaTrauDau;
    private List<BangXepHangModelAdapter> listBangXepHang;
    private List<DoiBongGiaiDau> listDoiBongGiaiDau;
    private List<BangDau> listBangDau;
    private TranDau1Adapter tranDau1Adapter;
    private BangXepHang1Adapter bangXepHang1Adapter;

    private TextView tvTenGiaiDau,tvMotaGiaiDau,tvTenToChucGiaiDau,tvThoiGianBatDau,tvThoiGianKetThuc,tvGioiTinhGiaiDau;
    private RecyclerView rvTranBong,rvBangXepHang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chi_tiet_giaidau);
        tvTenGiaiDau=findViewById(R.id.tvTenGiaiDau);
        tvMotaGiaiDau=findViewById(R.id.tvMotaGiaiDau);
        tvTenToChucGiaiDau=findViewById(R.id.tvTenToChucGiaiDau);
        tvThoiGianBatDau=findViewById(R.id.tvThoiGianBatDau);
        tvThoiGianKetThuc=findViewById(R.id.tvThoiGianKetThuc);
        tvGioiTinhGiaiDau=findViewById(R.id.tvGioiTinhGiaiDau);
        rvBangXepHang = findViewById(R.id.rvBangXepHang);
        rvTranBong=findViewById(R.id.rvTranBong);
        Intent intent =getIntent();
        Bundle bundle = intent.getBundleExtra("chitietgiaidau");
        Giaidau giaidau = (Giaidau) bundle.getSerializable("giaidau");
        setUpCard(giaidau);
        callApi(giaidau);


        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(ChiTietGiaidauActivity.this);
        rvTranBong.setLayoutManager(linearLayoutManager1);

        DividerItemDecoration itemDecoration1 = new DividerItemDecoration(ChiTietGiaidauActivity.this,DividerItemDecoration.VERTICAL);
        rvTranBong.addItemDecoration(itemDecoration1);
        tranDau1Adapter = new TranDau1Adapter(listTranDauGiai);
        rvTranBong.setAdapter(tranDau1Adapter);

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(ChiTietGiaidauActivity.this,LinearLayoutManager.HORIZONTAL,false);
        rvBangXepHang.setLayoutManager(linearLayoutManager2);

        DividerItemDecoration itemDecoration2 = new DividerItemDecoration(ChiTietGiaidauActivity.this,DividerItemDecoration.VERTICAL);
        rvBangXepHang.addItemDecoration(itemDecoration2);
        bangXepHang1Adapter = new BangXepHang1Adapter(listBangXepHang);
        rvBangXepHang.setAdapter(bangXepHang1Adapter);
    }



    private void setUpCard(Giaidau giaidau){

        tvTenGiaiDau.setText(giaidau.getTenGiaiDau() != null ?
                giaidau.getTenGiaiDau() : "Chưa có tên giải đấu");

        tvMotaGiaiDau.setText("Mô tả :" +(giaidau.getMoTa() != null && !giaidau.getMoTa().isEmpty() ?
                giaidau.getMoTa() : "Chưa có mô tả"));

        tvTenToChucGiaiDau.setText("Tổ chức: " +
                (giaidau.getTenToChuc() != null ? giaidau.getTenToChuc() : "Chưa xác định"));

        tvGioiTinhGiaiDau.setText("Giải dành cho : " +
                (giaidau.getGioiTinh() != null ? giaidau.getGioiTinh() : "Chưa xác định"));

        String formattedStartDate = formatDate(String.valueOf(giaidau.getNgayBatdau()));
        tvThoiGianBatDau.setText("Ngày bắt đầu: " + formattedStartDate);

        String formattedEndDate = formatDate(String.valueOf(giaidau.getNgayKetThuc()));
        tvThoiGianKetThuc.setText("Ngày kết thúc: " + formattedEndDate);
    }

    private void callApi(Giaidau giaidau){
        listTranDau = new ArrayList<>();
        listSanVanDong = new ArrayList<>();
        listVongDau = new ArrayList<>();
        listDoiBong = new ArrayList<>();
        listKetQuaTrauDau = new ArrayList<>();
        listDoiBongGiaiDau = new ArrayList<>();
        listBangDau = new ArrayList<>();
        ApiService.apiService.getListTranDau().enqueue(new Callback<List<TranDau>>() {
            @Override
            public void onResponse(Call<List<TranDau>> call, Response<List<TranDau>> response) {
                listTranDau=response.body();
                checkAndSetupRecyclerView(giaidau);
                Toast.makeText(ChiTietGiaidauActivity.this, "Length :"+listTranDau.size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<TranDau>> call, Throwable t) {
                Log.e("ApiError", "Failed to fetch TranDau: " + t.getMessage(), t);
                Toast.makeText(ChiTietGiaidauActivity.this, "Fail api trandau: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        ApiService.apiService.getListSanVanDong().enqueue(new Callback<List<SanVanDong>>() {
            @Override
            public void onResponse(Call<List<SanVanDong>> call, Response<List<SanVanDong>> response) {
                listSanVanDong=response.body();
                checkAndSetupRecyclerView(giaidau);
            }

            @Override
            public void onFailure(Call<List<SanVanDong>> call, Throwable t) {
                Toast.makeText(ChiTietGiaidauActivity.this, "Fail api svd", Toast.LENGTH_SHORT).show();
            }
        });
        ApiService.apiService.getListVongDau().enqueue(new Callback<List<VongDau>>() {
            @Override
            public void onResponse(Call<List<VongDau>> call, Response<List<VongDau>> response) {
                listVongDau=response.body();
                checkAndSetupRecyclerView(giaidau);
            }

            @Override
            public void onFailure(Call<List<VongDau>> call, Throwable t) {
                Toast.makeText(ChiTietGiaidauActivity.this, "Fail api vong dau", Toast.LENGTH_SHORT).show();
            }
        });
        ApiService.apiService.getListDoiBong().enqueue(new Callback<List<DoiBong>>() {
            @Override
            public void onResponse(Call<List<DoiBong>> call, Response<List<DoiBong>> response) {
                listDoiBong=response.body();
                checkAndSetupRecyclerView(giaidau);
            }

            @Override
            public void onFailure(Call<List<DoiBong>> call, Throwable t) {
                Toast.makeText(ChiTietGiaidauActivity.this, "Fail api doibong", Toast.LENGTH_SHORT).show();
            }
        });
        ApiService.apiService.getListKetQuaTranDau().enqueue(new Callback<List<KetQuaTranDau>>() {
            @Override
            public void onResponse(Call<List<KetQuaTranDau>> call, Response<List<KetQuaTranDau>> response) {
                listKetQuaTrauDau=response.body();
                checkAndSetupRecyclerView(giaidau);
            }

            @Override
            public void onFailure(Call<List<KetQuaTranDau>> call, Throwable t) {
                Toast.makeText(ChiTietGiaidauActivity.this, "Fail api ketqua", Toast.LENGTH_SHORT).show();
            }
        });
        ApiService.apiService.getListBangDau().enqueue(new Callback<List<BangDau>>() {
            @Override
            public void onResponse(Call<List<BangDau>> call, Response<List<BangDau>> response) {
                listBangDau=response.body();
                checkAndSetupRecyclerView(giaidau);
            }

            @Override
            public void onFailure(Call<List<BangDau>> call, Throwable t) {
                Toast.makeText(ChiTietGiaidauActivity.this, "Fail api bangdau", Toast.LENGTH_SHORT).show();
            }
        });
        ApiService.apiService.getListDoiBongGiaiDau().enqueue(new Callback<List<DoiBongGiaiDau>>() {
            @Override
            public void onResponse(Call<List<DoiBongGiaiDau>> call, Response<List<DoiBongGiaiDau>> response) {
                listDoiBongGiaiDau=response.body();
                checkAndSetupRecyclerView(giaidau);
            }

            @Override
            public void onFailure(Call<List<DoiBongGiaiDau>> call, Throwable t) {
                Toast.makeText(ChiTietGiaidauActivity.this, "Fail api doibonggiaidau", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void checkAndSetupRecyclerView(Giaidau giaidau) {
        apiCallCount++;
        if (apiCallCount == TOTAL_API_CALLS) {
            setuprvTrandau(giaidau);
            setuprvBangXepHang(giaidau);
            tranDau1Adapter = new TranDau1Adapter(listTranDauGiai);
            rvTranBong.setAdapter(tranDau1Adapter);
            bangXepHang1Adapter = new BangXepHang1Adapter(listBangXepHang);
            rvBangXepHang.setAdapter(bangXepHang1Adapter);
        }
    }


    public void setuprvTrandau(Giaidau giaidau){

        if(listTranDau==null || listTranDau.isEmpty()) return;
        List<TranDau> listtd = new ArrayList<>();
        for (TranDau tranDau:listTranDau){
            if(tranDau.getMaGiaiDau().equals(giaidau.getMaGiaidau())){
                listtd.add(tranDau);
            }
        }
        listTranDauGiai= new ArrayList<>();
        for(TranDau trandau : listtd){
            TranDauModelAdapter trandau1 = new TranDauModelAdapter();
            trandau1.setTyso("VS");
            trandau1.setGio(String.valueOf(trandau.getGioDienRa()));
            trandau1.setNgay(formatDate(String.valueOf(trandau.getNgayDienRa())));
            for(VongDau vd:listVongDau){
                if(vd.getMaVongDau().equals(trandau.getMaVongDau())){
                    trandau1.setVongdau(vd.getTenVong());
                    break;
                }
            }
            for(SanVanDong vd:listSanVanDong){
                if(vd.getMaSan().equals(trandau.getSanVanDong())){
                    trandau1.setSanvandong("Sân vận động: "+vd.getTen_san());
                    break;
                }
            }
            for(KetQuaTranDau vd:listKetQuaTrauDau){
                if(vd.getMaTranDau().equals(trandau.getMaTranDau())){
                    trandau1.setTyso(vd.getSoBanDoi1()+"-"+vd.getSoBanDoi2());
                    break;
                }
            }
            for(DoiBong db :listDoiBong){
                if(db.getMaDoiBong().equals(trandau.getMaDoi1())){
                    trandau1.setHinhAnhDoi1(db.getLogo());
                    trandau1.setTenDoi1(db.getTenDoiBong());
                }
                if(db.getMaDoiBong().equals(trandau.getMaDoi2())){
                    trandau1.setHinhAnhDoi2(db.getLogo());
                    trandau1.setTenDoi2(db.getTenDoiBong());
                }
            }
            listTranDauGiai.add(trandau1);
        }
    }

    private void setuprvBangXepHang(Giaidau giaidau) {
        listBangXepHang = new ArrayList<>();

        // Kiểm tra dữ liệu đầu vào
        if (listBangDau == null || listDoiBongGiaiDau == null || listDoiBong == null ||
                listTranDau == null || listKetQuaTrauDau == null) {
            Toast.makeText(ChiTietGiaidauActivity.this, "Dữ liệu không hợp lệ", Toast.LENGTH_SHORT).show();
            return;
        }

        for (BangDau bangdau : listBangDau) {
            if (bangdau.getMaGiaiDau().equals(giaidau.getMaGiaidau())) {
                List<DoiBongModelAdapter> list = new ArrayList<>();

                for (DoiBongGiaiDau doibonggiaidau : listDoiBongGiaiDau) {
                    if (doibonggiaidau.getMabangDau() != null &&
                            !doibonggiaidau.getMabangDau().isEmpty() &&
                            doibonggiaidau.getMabangDau().equals(bangdau.getMaBangDau())) {

                        int sotrandau = 0, sotranthang = 0, sotranthua = 0, sotranhoa = 0, sodiem = 0, hieuso = 0;
                        String tendoibong = "", madoibong = "";
                        sodiem=doibonggiaidau.getDiemVongLoai();

                        // Tìm tên đội bóng
                        for (DoiBong doibong : listDoiBong) {
                            if (doibong.getMaDoiBong().equals(doibonggiaidau.getMaDoiBong())) {
                                tendoibong = doibonggiaidau.getTenDoiBong();
                                madoibong = doibong.getMaDoiBong();
                                break;
                            }
                        }

                        // Tính toán số liệu
                        for (TranDau trandau : listTranDau) {
                            if (trandau.getMaDoi1().equals(madoibong) || trandau.getMaDoi2().equals(madoibong)) {
                                for (KetQuaTranDau ketqua : listKetQuaTrauDau) {
                                    if (ketqua.getMaTranDau().equals(trandau.getMaTranDau())) {
                                        ++sotrandau;
                                        if (ketqua.getSoBanDoi1() == ketqua.getSoBanDoi2()) {
                                            ++sotranhoa;
                                        } else if (trandau.getMaDoi1().equals(madoibong) &&
                                                ketqua.getSoBanDoi1() > ketqua.getSoBanDoi2() ||
                                                trandau.getMaDoi2().equals(madoibong) &&
                                                        ketqua.getSoBanDoi2() > ketqua.getSoBanDoi1()) {
                                            ++sotranthang;
                                            hieuso += (trandau.getMaDoi1().equals(madoibong) ?
                                                    ketqua.getSoBanDoi1() - ketqua.getSoBanDoi2() :
                                                    ketqua.getSoBanDoi2() - ketqua.getSoBanDoi1());
                                        } else {
                                            ++sotranthua;
                                            hieuso += (trandau.getMaDoi1().equals(madoibong) ?
                                                    ketqua.getSoBanDoi1() - ketqua.getSoBanDoi2() :
                                                    ketqua.getSoBanDoi2() - ketqua.getSoBanDoi1());
                                        }
                                    }
                                }
                            }
                        }
                        list.add(new DoiBongModelAdapter(0, tendoibong, sotrandau, sotranthang, sotranhoa, sotranthua, hieuso, sodiem));
                    }
                }

                Collections.sort(list, (a, b) -> {
                    if (b.getDiem() != a.getDiem()) {
                        return b.getDiem() - a.getDiem();
                    }
                    return b.getDiem() - a.getDiem();
                });

                for (int i = 0; i < list.size(); i++) {
                    list.get(i).setStt(i + 1);
                }

                listBangXepHang.add(new BangXepHangModelAdapter(bangdau.getTenBangDau(), list));
                Log.d("DEBUG", "Số đội bóng trong bảng " + bangdau.getTenBangDau() + ": " + list.size());
            }
        }
    }

    private String formatDate(String dateString) {
        if (dateString == null || dateString.isEmpty()) {
            return "Chưa xác định";
        }
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            Date date = inputFormat.parse(dateString);

            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            return outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return dateString;
        }
    }
    private String formatDate2(String dateString) {
        if (dateString == null || dateString.isEmpty()) {
            return "Chưa xác định";
        }
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date date = inputFormat.parse(dateString);

            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            return outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return dateString;
        }
    }
}