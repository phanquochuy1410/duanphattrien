package com.example.demo.service;

import com.example.demo.entity.KhachHang;

import java.util.List;
import java.util.UUID;

public interface KhachHangService  {

    List<KhachHang> getAll();

    void addKhachHang(KhachHang khachHang);

    void updateKhachHang(KhachHang khachHang , UUID id);

    KhachHang getOne(UUID id);

    boolean checkMa(String ma);
}
