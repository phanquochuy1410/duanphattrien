package com.example.demo.service.impl;

import com.example.demo.entity.Size;
import com.example.demo.repository.SizeRepository;
import com.example.demo.service.SizeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SizeServiceImpl implements SizeService {

    @Autowired
    private SizeRepository sizeRepository;

    @Override
    public List<Size> getAll() {
        return sizeRepository.findAll();
    }

    @Override
    public void addSize(Size size) {
        sizeRepository.save(size);
    }

    @Override
    public void updateSize(Size size, UUID id) {
        BeanUtils.copyProperties(size , sizeRepository.getReferenceById(id));
        sizeRepository.save(size);
    }

    @Override
    public Size getOne(UUID id) {
        return sizeRepository.getReferenceById(id);
    }

    @Override
    public boolean checkMa(String ma) {
        return !sizeRepository.existsByMa(ma);
    }
}
