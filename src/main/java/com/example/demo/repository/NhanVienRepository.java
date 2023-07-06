package com.example.demo.repository;

import com.example.demo.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien , UUID> {

    @Query( value = "SELECT * FROM nhan_vien WHERE ho_va_ten like %:ten%" , nativeQuery = true )
    List<NhanVien> searchNhanVien(@Param("ten") String ten);

    NhanVien findByEmail(String email);

    boolean existsByMa(String ma);

    boolean existsByEmail(String email);
}
