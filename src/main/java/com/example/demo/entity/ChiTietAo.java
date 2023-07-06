package com.example.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "chi_tiet_ao")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ChiTietAo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "so_luong")
    @NotNull(message = "Số lượng chống")
//    @Min(value = 0 , message = "Số lượng lớn hơn 0")
    private Integer soLuong;

    @Column(name = "gia")
    @NotNull(message = "Gía không được để chống")
    private Float gia;

    @Column(name = "trangThai")
    private Integer trangThai;

    @Column(name = "anh")
    private String anh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ao" , referencedColumnName = "id")
    private Ao idAo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mau_sac" , referencedColumnName = "id")
    private MauSac idMauSac;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_size" , referencedColumnName = "id")
    private Size idSize;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Loai_ao" , referencedColumnName = "id")
    private LoaiAo idLoaiAo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_chat_lieu" , referencedColumnName = "id")
    private ChatLieu idChatLieu;

    public double tongTien(){
        return this.getGia() * this.getSoLuong();
    }
}
