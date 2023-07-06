package com.example.demo.repository;

import com.example.demo.entity.LoaiAo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoaiAoRepository extends JpaRepository<LoaiAo , UUID> {

    boolean existsByMa(String ma);
}
