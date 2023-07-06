package com.example.demo.service;

import com.example.demo.entity.HoaDonChiTiet;
import java.util.List;
import java.util.UUID;


public interface HoaDonChiTietService {

    List<HoaDonChiTiet> getAll();

    void addHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet);

    void updateHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet, UUID id );

    void deleteSanPham(HoaDonChiTiet hoaDonChiTiet);

    boolean checkMa(UUID idChiTiet);

    void deleteHoaDon(HoaDonChiTiet hoaDonChiTiet);

    boolean checkIdSanPham(UUID idChiTiet , UUID idHoaDon);

    List<HoaDonChiTiet> loadTable(UUID id);

}
