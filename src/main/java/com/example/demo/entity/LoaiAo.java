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
@Table(name = "loai_ao")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoaiAo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "ma")
    @NotBlank(message = "Mã không được để chống !")
    private String ma;

    @Column(name = "ten")
    @NotBlank(message = "Tên không được để chống !")
    private String ten;
}
