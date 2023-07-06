package com.example.demo.service.impl;

import com.example.demo.entity.NhanVien;
import com.example.demo.repository.NhanVienRepository;
import com.example.demo.service.NhanVienService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Override
    public List<NhanVien> getAll() {
        return nhanVienRepository.findAll();
    }

    @Override
    public void addNhanVien(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    @Override
    public void updateNhanVien(NhanVien nhanVien, UUID id) {
        BeanUtils.copyProperties(nhanVien , nhanVienRepository.getReferenceById(id));
        nhanVienRepository.save(nhanVien);
    }

    @Override
    public NhanVien getOne(UUID id) {
        return nhanVienRepository.getReferenceById(id);
    }

    @Override
    public List<NhanVien> search(String ten) {
        return nhanVienRepository.searchNhanVien(ten);
    }

    @Override
    public boolean checkMa(String ma) {
        return !nhanVienRepository.existsByMa(ma);
    }

    @Override
    public boolean checkEmail(String email) {
        return !nhanVienRepository.existsByEmail(email);
    }

    @Override
    public boolean checkNgaySinh(LocalDate ngaySinh) {
        LocalDate localDate = LocalDate.now();
        return localDate.isBefore(ngaySinh);
    }

}
