package com.example.demo.service.impl;

import com.example.demo.entity.HoaDon;
import com.example.demo.entity.HoaDonChiTiet;
import com.example.demo.repository.HoaDonRepository;
import com.example.demo.service.HoaDonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class HoaDonServiceImpl implements HoaDonService {

    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Override
    public List<HoaDon> getAll() {
        return hoaDonRepository.findAll();
    }

    @Override
    public void addHoaDon(HoaDon hoaDon) {
        String maHD = zenMa();
        LocalDate ngayTao = LocalDate.now();
        HoaDon hoaDons = new HoaDon(maHD, ngayTao, 1);
        hoaDonRepository.save(hoaDons);
    }

    @Override
    public void deleteHoaDon(HoaDon hoaDon) {
        hoaDonRepository.delete(hoaDon);
    }

    @Override
    public void updateHoaDon(HoaDon hoaDon, UUID id) {
        LocalDate localDate = LocalDate.now();
        HoaDon hoaDons = new HoaDon();
        hoaDons.setId(hoaDon.getId());
        hoaDons.setMa(hoaDon.getMa());
        if (hoaDon.getIdKhachHang() == null){
            hoaDons.getIdKhachHang();
        }else{
            hoaDons.setIdKhachHang(hoaDon.getIdKhachHang());
        }
        hoaDons.setNgayTao(localDate);
        hoaDons.setIdNhanVien(hoaDon.getIdNhanVien());
        hoaDons.setTrangThai(0);
        hoaDonRepository.save(hoaDons);
    }

    @Override
    public void updateHoaDons(UUID id , int trangThai ) {
        hoaDonRepository.updateHoaDon(id , trangThai);
    }

    @Override
    public List<HoaDon> fillHoaDon(int trangThai) {
        return hoaDonRepository.findByTrangThai(trangThai);
    }

    @Override
    public HoaDon getOne(UUID id) {
        return hoaDonRepository.getReferenceById(id);
    }

    private String zenMa() {
        String ma = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 5);
        return "HD-" + ma;
    }
}
