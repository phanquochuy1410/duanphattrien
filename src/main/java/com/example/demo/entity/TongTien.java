package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class TongTien {

    private List<HoaDonChiTiet> items = new ArrayList<>();

    public double tongTien(){
        double tong = 0;
        for (HoaDonChiTiet x : items){
            tong += x.getGia() * x.getSoLuong();
        }
        return tong;
    }
}
