package com.example.demo.service;

import com.example.demo.entity.Size;

import java.util.List;
import java.util.UUID;

public interface SizeService {

    List<Size> getAll();

    void addSize(Size size);

    void updateSize(Size size , UUID id);

    Size getOne(UUID id);

    boolean checkMa(String ma);
}
