package com.example.demo.service;


import com.example.demo.entity.LoaiAo;

import java.util.List;
import java.util.UUID;

public interface LoaiAoService {

    List<LoaiAo> getAll();

    void addLoaiAo(LoaiAo loaiAo);

    void updateLoaiAo(LoaiAo loaiAo , UUID id);

    LoaiAo getOne(UUID id);

    boolean checkMa(String ma);
}
