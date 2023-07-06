package com.example.demo.service;

import com.example.demo.entity.ChiTietAo;
import com.example.demo.entity.HoaDon;

import java.util.UUID;

public interface BanHangService {

    void updateSoLuong(ChiTietAo chiTietAo, UUID id);

    void updateHoaDon(HoaDon hoaDon, UUID id);


}
