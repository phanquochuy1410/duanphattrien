package com.example.demo.service;

import com.example.demo.entity.NhanVien;

import java.util.UUID;

public interface Login {

    NhanVien login(String email , int matKhau);
}
