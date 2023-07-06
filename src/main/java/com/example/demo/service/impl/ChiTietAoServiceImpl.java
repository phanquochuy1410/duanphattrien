package com.example.demo.service.impl;

import com.example.demo.entity.ChiTietAo;
import com.example.demo.repository.ChiTietAoRepository;
import com.example.demo.service.ChiTietAoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChiTietAoServiceImpl implements ChiTietAoService {

    @Autowired
    private ChiTietAoRepository chiTietAoRepository;
    @Override
    public List<ChiTietAo> getAll() {
        return chiTietAoRepository.findAll();
    }

    @Override
    public void addChiTiet(ChiTietAo chiTietAo) {
        chiTietAoRepository.save(chiTietAo);
    }

    @Override
    public void updateChiTiet(ChiTietAo chiTietAo, UUID id) {
        BeanUtils.copyProperties(chiTietAo , chiTietAoRepository.getReferenceById(id));
        chiTietAoRepository.save(chiTietAo);
    }

    @Override
    public ChiTietAo getOne(UUID id) {
        return chiTietAoRepository.getReferenceById(id);
    }

    @Override
    public List<ChiTietAo> searchAo(String tenAo) {
        return chiTietAoRepository.searchAo(tenAo);
    }

}
