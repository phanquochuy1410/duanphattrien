package com.example.demo.service;

import com.example.demo.entity.HoaDon;
import java.util.List;
import java.util.UUID;

public interface HoaDonService {

    List<HoaDon> getAll();

    void addHoaDon(HoaDon hoaDon);

    void deleteHoaDon(HoaDon hoaDon);

    void updateHoaDon(HoaDon hoaDon , UUID id);

    void updateHoaDons(UUID id , int trangThai );

    List<HoaDon> fillHoaDon(int trangThai);

    HoaDon getOne(UUID id);

}
