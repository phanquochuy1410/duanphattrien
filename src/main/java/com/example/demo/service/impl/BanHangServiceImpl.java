package com.example.demo.service.impl;

import com.example.demo.entity.ChiTietAo;
import com.example.demo.entity.HoaDon;
import com.example.demo.entity.HoaDonChiTiet;
import com.example.demo.repository.ChiTietAoRepository;
import com.example.demo.repository.HoaDonChiTietRepository;
import com.example.demo.repository.HoaDonRepository;
import com.example.demo.service.BanHangService;
import com.example.demo.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BanHangServiceImpl implements BanHangService {

    @Autowired
    private ChiTietAoRepository chiTietAoRepository;

    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private HoaDonChiTietRepository hoaDonChiTietRepository;

    @Override
    public void updateSoLuong(ChiTietAo chiTietAo, UUID id) {
        ChiTietAo chiTietAos = chiTietAoRepository.getReferenceById(id);
        int soLuongMoi = chiTietAoRepository.findChiTietAoById(chiTietAos.getId()).getSoLuong() - hoaDonChiTietRepository.findByIdChiTietAo_Id(chiTietAos.getId()).getSoLuong();
        chiTietAos.setIdAo(chiTietAo.getIdAo());
        chiTietAos.setIdChatLieu(chiTietAo.getIdChatLieu());
        chiTietAos.setIdLoaiAo(chiTietAo.getIdLoaiAo());
        chiTietAos.setIdMauSac(chiTietAo.getIdMauSac());
        chiTietAos.setIdSize(chiTietAo.getIdSize());
        chiTietAos.setId(chiTietAo.getId());
        chiTietAos.setGia(chiTietAo.getGia());
        chiTietAos.setAnh(chiTietAo.getAnh());
        chiTietAos.setSoLuong(soLuongMoi);
        chiTietAoRepository.save(chiTietAos);
    }

    @Override
    public void updateHoaDon(HoaDon hoaDon, UUID id) {
        HoaDon hoaDons = new HoaDon();
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
        UUID idHoaDon = hoaDonRepository.findHoaDonById(hoaDonChiTiet.getIdHoaDon().getId()).getId();
        hoaDons.setId(idHoaDon);
        hoaDons.setTrangThai(0);
        hoaDonRepository.save(hoaDons);
    }
}
