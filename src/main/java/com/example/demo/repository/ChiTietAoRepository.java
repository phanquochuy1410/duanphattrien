package com.example.demo.repository;

import com.example.demo.entity.ChiTietAo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChiTietAoRepository extends JpaRepository<ChiTietAo , UUID> {

    @Query("SELECT ct FROM ChiTietAo ct JOIN ct.idAo a WHERE a.ten = :tenAo")
    List<ChiTietAo> searchAo(@Param("tenAo") String tenAo);

    ChiTietAo findChiTietAoById(UUID id);


}
