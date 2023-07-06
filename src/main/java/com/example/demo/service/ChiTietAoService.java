package com.example.demo.service;

import com.example.demo.entity.ChiTietAo;

import java.util.List;
import java.util.UUID;

public interface ChiTietAoService {

    List<ChiTietAo> getAll();

    void addChiTiet(ChiTietAo chiTietAo);

    void updateChiTiet(ChiTietAo chiTietAo , UUID id);

    ChiTietAo getOne(UUID id);

    List<ChiTietAo> searchAo(String tenAo);


}
