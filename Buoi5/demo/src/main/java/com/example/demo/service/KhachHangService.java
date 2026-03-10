package com.example.demo.service;

import com.example.demo.dto.KhachHangDTO;
import com.example.demo.entity.KhachHang;
import com.example.demo.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
public class KhachHangService {
    
    @Autowired
    private KhachHangRepository khachHangRepository;
    
    /**
     * Validate dữ liệu đăng ký khách hàng
     * @param dto KhachHangDTO cần validate
     * @return Danh sách lỗi nếu có
     */
    public List<String> validateDangKy(KhachHangDTO dto) {
        List<String> errors = new ArrayList<>();
        
        // Kiểm tra mã khách hàng trùng lặp
        if (dto.getMaKhachHang() != null && !dto.getMaKhachHang().isEmpty()) {
            if (khachHangRepository.existsByMaKhachHang(dto.getMaKhachHang())) {
                errors.add("Mã khách hàng đã tồn tại trong hệ thống");
            }
        }
        
        // Kiểm tra email trùng lặp
        if (dto.getEmail() != null && !dto.getEmail().isEmpty()) {
            if (khachHangRepository.existsByEmail(dto.getEmail())) {
                errors.add("Email đã được sử dụng");
            }
        }
        
        // Kiểm tra xác nhận mật khẩu
        if (dto.getMatKhau() != null && dto.getXacNhanMatKhau() != null) {
            if (!dto.getMatKhau().equals(dto.getXacNhanMatKhau())) {
                errors.add("Mật khẩu xác nhận không khớp");
            }
        }
        
        // Kiểm tra ngày sinh (nếu có) - phải đủ 18 tuổi
        if (dto.getNgaySinh() != null) {
            LocalDate today = LocalDate.now();
            int age = Period.between(dto.getNgaySinh(), today).getYears();
            if (age < 18) {
                errors.add("Người dùng phải đủ 18 tuổi");
            }
        }
        
        // Kiểm tra đồng ý điều khoản
        if (!dto.isDongYDieuKhoan()) {
            errors.add("Bạn phải đồng ý với điều khoản dịch vụ");
        }
        
        return errors;
    }
    
    /**
     * Đăng ký khách hàng mới
     * @param dto KhachHangDTO chứa thông tin đăng ký
     * @return KhachHang đã được lưu
     */
    public KhachHang dangKy(KhachHangDTO dto) {
        KhachHang khachHang = new KhachHang();
        khachHang.setMaKhachHang(dto.getMaKhachHang());
        khachHang.setHoTen(dto.getHoTen());
        khachHang.setEmail(dto.getEmail());
        khachHang.setSoDienThoai(dto.getSoDienThoai());
        khachHang.setDiaChi(dto.getDiaChi());
        khachHang.setMatKhau(dto.getMatKhau()); // Trong thực tế nên mã hóa mật khẩu
        khachHang.setNgaySinh(dto.getNgaySinh());
        khachHang.setGioiTinh(dto.getGioiTinh());
        
        return khachHangRepository.save(khachHang);
    }
    
    /**
     * Kiểm tra mã khách hàng đã tồn tại
     */
    public boolean existsByMaKhachHang(String maKhachHang) {
        return khachHangRepository.existsByMaKhachHang(maKhachHang);
    }
    
    /**
     * Kiểm tra email đã tồn tại
     */
    public boolean existsByEmail(String email) {
        return khachHangRepository.existsByEmail(email);
    }
}
