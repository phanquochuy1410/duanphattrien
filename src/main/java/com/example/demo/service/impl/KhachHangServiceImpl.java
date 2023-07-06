package com.example.demo.service.impl;

import com.example.demo.entity.KhachHang;
import com.example.demo.repository.KhachHangRepository;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public List<KhachHang> getAll() {
        return khachHangRepository.findAll();
    }

    @Override
    public void addKhachHang(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }

    @Override
    public void updateKhachHang(KhachHang khachHang, UUID id) {
        BeanUtils.copyProperties(khachHang, khachHangRepository.getReferenceById(id));
        khachHangRepository.save(khachHang);
    }

    @Override
    public KhachHang getOne(UUID id) {
        return khachHangRepository.getReferenceById(id);
    }

    @Override
    public boolean checkMa(String ma) {
        return !khachHangRepository.existsByMa(ma);
    }
}
