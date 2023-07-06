package com.example.demo.repository;
import com.example.demo.entity.HoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet , UUID> {

    HoaDonChiTiet findByIdChiTietAo_Id(UUID id);

    boolean existsByIdChiTietAo_Id(UUID idChiTiet);

    @Query("SELECT SUM(hdct.gia * hdct.soLuong) FROM HoaDonChiTiet hdct WHERE hdct.idHoaDon.id = ?1 ")
    float tongTien(UUID id);

    boolean existsByIdChiTietAo_IdAndIdHoaDon_Id(UUID idChiTiet , UUID idHoaDon);

    List<HoaDonChiTiet> findByIdHoaDon_Id(UUID id);

}
