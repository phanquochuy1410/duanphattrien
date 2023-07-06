package com.example.demo.repository;

import com.example.demo.entity.Ao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AoRepository extends JpaRepository<Ao , UUID> {

    boolean existsByMa(String ma);
}
