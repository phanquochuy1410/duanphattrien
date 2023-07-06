package com.example.demo.service.impl;

import com.example.demo.entity.Ao;
import com.example.demo.repository.AoRepository;
import com.example.demo.service.AoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AoServiceImpl implements AoService {

    @Autowired
    private AoRepository aoRepository;

    @Override
    public List<Ao> getAll() {
        return aoRepository.findAll();
    }

    @Override
    public void addAo(Ao ao) {
        aoRepository.save(ao);
    }

    @Override
    public void updateAo(Ao ao, UUID id) {
        BeanUtils.copyProperties(ao, aoRepository.getReferenceById(id));
        aoRepository.save(ao);
    }

    @Override
    public Ao getOne(UUID id) {
        return aoRepository.getReferenceById(id);
    }

    @Override
    public boolean checkMa(String ma) {
        return !aoRepository.existsByMa(ma);
    }
}
