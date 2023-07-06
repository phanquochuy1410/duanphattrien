package com.example.demo.service.impl;

import com.example.demo.entity.HoaDonChiTiet;
import com.example.demo.repository.HoaDonChiTietRepository;
import com.example.demo.service.HoaDonChiTietService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {

    @Autowired
    private HoaDonChiTietRepository hoaDonChiTietRepository;

    @Override
    public List<HoaDonChiTiet> getAll() {
        return hoaDonChiTietRepository.findAll();
    }

    @Override
    public void addHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet) {
        hoaDonChiTietRepository.save(hoaDonChiTiet);
    }

    @Override
    public void updateHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet, UUID id) {
        BeanUtils.copyProperties(hoaDonChiTiet, hoaDonChiTietRepository.getReferenceById(id));
        hoaDonChiTietRepository.save(hoaDonChiTiet);
    }

    @Override
    public void deleteSanPham(HoaDonChiTiet hoaDonChiTiet) {
        hoaDonChiTietRepository.delete(hoaDonChiTiet);
    }

    @Override
    public boolean checkMa(UUID idChiTiet) {
        return !hoaDonChiTietRepository.existsByIdChiTietAo_Id(idChiTiet);
    }

    @Override
    public void deleteHoaDon(HoaDonChiTiet hoaDonChiTiet) {
        hoaDonChiTietRepository.deleteAll();
    }

    @Override
    public boolean checkIdSanPham(UUID idChiTiet, UUID idHoaDon) {
        return !hoaDonChiTietRepository.existsByIdChiTietAo_IdAndIdHoaDon_Id(idChiTiet, idHoaDon);
    }

    @Override
    public List<HoaDonChiTiet> loadTable(UUID id) {
        return hoaDonChiTietRepository.findByIdHoaDon_Id(id);
    }
}
