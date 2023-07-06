package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "khach_hang")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class KhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "ma")
    @NotBlank(message = "Mã không được để chống !")
    private String ma;

    @Column(name = "ho_va_ten")
    @NotBlank(message = "Họ và tên không được để chống !")
    private String hoVaTen;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    @Column(name = "sdt")
    @NotBlank(message = "Số điện thoại không được để chống !")
    private String sdt;

    @Column(name = "dia_chi")
    @NotBlank(message = "Địa chỉ không được để chống !")
    private String diaChi;

    @Column(name = "trang_thai")
    private Integer trangThai;
}
