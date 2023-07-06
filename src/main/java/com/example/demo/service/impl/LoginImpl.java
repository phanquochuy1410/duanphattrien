package com.example.demo.service.impl;

import com.example.demo.entity.NhanVien;
import com.example.demo.repository.NhanVienRepository;
import com.example.demo.service.Login;
import com.example.demo.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoginImpl implements Login {

    @Autowired
    private NhanVienService nhanVienService = new NhanVienServiceImpl();

    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Override
    public NhanVien login(String email, int matKhau) {
        NhanVien nhanVien = nhanVienRepository.findByEmail(email);
        if (nhanVien != null && nhanVien.getMatKhau().equals(matKhau)){
            return nhanVien;
        }
        return null;
    }
}
