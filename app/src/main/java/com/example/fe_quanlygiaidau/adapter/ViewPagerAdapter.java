package com.example.fe_quanlygiaidau.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.fe_quanlygiaidau.activity.Fragment_ket_qua;
import com.example.fe_quanlygiaidau.activity.Fragment_trang_chu;
import com.example.fe_quanlygiaidau.activity.Fragment_lich_thi_dau;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm, @NonNull Lifecycle lifecycle) {
        super(fm, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new Fragment_trang_chu();
            case 1:
                return new Fragment_lich_thi_dau();
            case 2:
                return new Fragment_ket_qua(); // Thay bằng Fragment cho "Quản lý cầu thủ"
            case 3:
                return new Fragment(); // Thay bằng Fragment cho "Quản lý kết quả"
            default:
                return new Fragment_lich_thi_dau();
        }
    }

    @Override
    public int getItemCount() {
        return 4; // 4 tab: Home, Quản lý trận đấu, Quản lý cầu thủ, Quản lý kết quả
    }
}