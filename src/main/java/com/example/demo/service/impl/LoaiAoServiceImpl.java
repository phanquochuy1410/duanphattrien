package com.example.demo.service.impl;

import com.example.demo.entity.LoaiAo;
import com.example.demo.repository.LoaiAoRepository;
import com.example.demo.service.LoaiAoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LoaiAoServiceImpl implements LoaiAoService {

    @Autowired
    private LoaiAoRepository loaiAoRepository;

    @Override
    public List<LoaiAo> getAll() {
        return loaiAoRepository.findAll();
    }

    @Override
    public void addLoaiAo(LoaiAo loaiAo) {
        loaiAoRepository.save(loaiAo);
    }

    @Override
    public void updateLoaiAo(LoaiAo loaiAo, UUID id) {
        BeanUtils.copyProperties(loaiAo , loaiAoRepository.getReferenceById(id));
        loaiAoRepository.save(loaiAo);
    }

    @Override
    public LoaiAo getOne(UUID id) {
        return loaiAoRepository.getReferenceById(id);
    }

    @Override
    public boolean checkMa(String ma) {
        return !loaiAoRepository.existsByMa(ma);
    }
}
