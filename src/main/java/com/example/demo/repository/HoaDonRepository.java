package com.example.demo.repository;

import com.example.demo.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface HoaDonRepository extends JpaRepository<HoaDon , UUID> {

    List<HoaDon> findByTrangThai(int trangThai);

    @Query(value = "SELECT * FROM hoa_don WHERE trang_thai = 1",nativeQuery = true)
    List<HoaDon> getTrangThai(int trangThai);

    HoaDon findHoaDonById(UUID id);

    default void updateHoaDon(UUID id, int trangThai) {
        findById(id).ifPresent(hoaDon -> {
            hoaDon.setTrangThai(trangThai);
            save(hoaDon);
        });
    }
}
