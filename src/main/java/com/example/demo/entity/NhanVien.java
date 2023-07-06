package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "nhan_vien")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "ma")
    @NotBlank(message = "Mã không được để chống")
    private String ma;

    @Column(name = "ho_va_ten")
    @NotBlank(message = "Tên không được để chống")
    private String hoVaTen;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    @Column(name = "ngay_sinh")
    private LocalDate ngaySinh;

    @Column(name = "email")
    @NotBlank(message = "Email không được để chống")
    private String email;

    @Column(name = "sdt")
    @NotBlank(message = "Số điện thoại không được để chống")
    private String sdt;

    @Column(name = "dia_chi")
    @NotBlank(message = "Địa chỉ không được để chống")
    private String diaChi;

    @Column(name = "mat_khau")
    @NotNull(message = "Mật khẩu không được để chống")
    private Integer matKhau;

    @Column(name = "chuc_vu")
    private Integer chucVu;

    @Column(name = "trang_thai")
    private Integer trangThai;

}
