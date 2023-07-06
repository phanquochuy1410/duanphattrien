package com.example.demo.service;

import com.example.demo.entity.NhanVien;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface NhanVienService {

    List<NhanVien> getAll();

    void addNhanVien(NhanVien nhanVien);

    void updateNhanVien(NhanVien nhanVien , UUID id);

    NhanVien getOne(UUID id);

    List<NhanVien> search(String ten);

    boolean checkMa(String ma);

    boolean checkEmail(String email);

    boolean checkNgaySinh(LocalDate ngaySinh);

}
