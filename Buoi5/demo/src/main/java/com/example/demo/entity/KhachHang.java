package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "khach_hang")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KhachHang {
    
    @Id
    @Column(name = "ma_khach_hang", length = 10, nullable = false, unique = true)
    private String maKhachHang;
    
    @Column(name = "ho_ten", length = 50, nullable = false)
    private String hoTen;
    
    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;
    
    @Column(name = "so_dien_thoai", length = 12, nullable = false)
    private String soDienThoai;
    
    @Column(name = "dia_chi", length = 255, nullable = false)
    private String diaChi;
    
    @Column(name = "mat_khau", nullable = false)
    private String matKhau;
    
    @Column(name = "ngay_sinh")
    private LocalDate ngaySinh;
    
    @Column(name = "gioi_tinh", length = 10)
    private String gioiTinh;
}
