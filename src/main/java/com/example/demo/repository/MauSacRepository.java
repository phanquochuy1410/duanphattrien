package com.example.demo.repository;

import com.example.demo.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MauSacRepository extends JpaRepository<MauSac , UUID> {

    boolean existsByMa(String ma);
}
