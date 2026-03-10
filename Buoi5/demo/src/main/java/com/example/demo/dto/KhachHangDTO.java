package com.example.demo.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KhachHangDTO {
    
    @NotBlank(message = "Mã khách hàng không được để trống")
    @Size(min = 6, max = 10, message = "Mã khách hàng phải từ 6 đến 10 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Mã khách hàng chỉ được chứa chữ cái và số")
    private String maKhachHang;
    
    @NotBlank(message = "Họ và tên không được để trống")
    @Size(min = 5, max = 50, message = "Họ và tên phải từ 5 đến 50 ký tự")
    @Pattern(regexp = "^[\\p{L}\\s]+$", message = "Họ và tên chỉ được chứa chữ cái và khoảng trắng")
    private String hoTen;
    
    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;
    
    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "^0[0-9]{9,11}$", message = "Số điện thoại phải bắt đầu bằng số 0, chỉ chứa số và có độ dài từ 10 đến 12 ký tự")
    private String soDienThoai;
    
    @NotBlank(message = "Địa chỉ không được để trống")
    @Size(max = 255, message = "Địa chỉ không được vượt quá 255 ký tự")
    private String diaChi;
    
    @NotBlank(message = "Mật khẩu không được để trống")
    @Size(min = 8, message = "Mật khẩu phải có ít nhất 8 ký tự")
    private String matKhau;
    
    @NotBlank(message = "Xác nhận mật khẩu không được để trống")
    private String xacNhanMatKhau;
    
    private LocalDate ngaySinh;
    
    private String gioiTinh;
    
    private boolean dongYDieuKhoan;
}
