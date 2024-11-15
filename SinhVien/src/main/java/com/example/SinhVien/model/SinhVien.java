package com.example.SinhVien.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "SinhVien")
public class SinhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ma;
    @Column
    private String ten;
    @Column
    private Integer tuoi;
    @Column(name = "dia_chi")
    private String diaChi;
    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;
}
