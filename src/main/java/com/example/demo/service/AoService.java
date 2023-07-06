package com.example.demo.service;

import com.example.demo.entity.Ao;

import java.util.List;
import java.util.UUID;

public interface AoService {
    List<Ao> getAll();

    void addAo(Ao ao);

    void updateAo(Ao ao , UUID id);

    Ao getOne(UUID id);

    boolean checkMa(String ma);
}
