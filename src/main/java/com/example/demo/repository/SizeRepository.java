package com.example.demo.repository;

import com.example.demo.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SizeRepository extends JpaRepository<Size , UUID> {

    boolean existsByMa(String ma);
}
