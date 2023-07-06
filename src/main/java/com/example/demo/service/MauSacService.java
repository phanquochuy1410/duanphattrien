package com.example.demo.service;


import com.example.demo.entity.MauSac;

import java.util.List;
import java.util.UUID;

public interface MauSacService {

    List<MauSac> getAll();

    void addMauSac(MauSac mauSac);

    void updateMauSac(MauSac mauSac , UUID id);

    MauSac getOne(UUID id);

    boolean checkMa(String ma);
}
