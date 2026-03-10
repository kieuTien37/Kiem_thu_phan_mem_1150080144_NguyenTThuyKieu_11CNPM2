package com.example.demo.service;

import com.example.demo.dto.KhachHangDTO;
import com.example.demo.entity.KhachHang;
import com.example.demo.repository.KhachHangRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Test class cho KhachHangService
 * Sử dụng Test Fixture với @BeforeAll, @BeforeEach, @AfterEach, @AfterAll
 * Sử dụng Mockito để mock Repository
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Test KhachHangService")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class KhachHangServiceTest {
    
    @Mock
    private KhachHangRepository khachHangRepository;
    
    @InjectMocks
    private KhachHangService khachHangService;
    
    private KhachHangDTO validDTO;
    
    // ==================== TEST FIXTURE ====================
    
    @BeforeAll
    static void setUpAll() {
        System.out.println("=== BẮT ĐẦU TEST SUITE SERVICE ===");
    }
    
    @BeforeEach
    void setUp() {
        // Tạo DTO hợp lệ làm baseline
        validDTO = new KhachHangDTO();
        validDTO.setMaKhachHang("KH000001");
        validDTO.setHoTen("Nguyễn Văn An");
        validDTO.setEmail("nguyenvanan@email.com");
        validDTO.setSoDienThoai("0912345678");
        validDTO.setDiaChi("123 Đường ABC, Quận 1, TP.HCM");
        validDTO.setMatKhau("password123");
        validDTO.setXacNhanMatKhau("password123");
        validDTO.setNgaySinh(LocalDate.of(2000, 1, 1));
        validDTO.setGioiTinh("Nam");
        validDTO.setDongYDieuKhoan(true);
    }
    
    @AfterEach
    void tearDown() {
        validDTO = null;
    }
    
    @AfterAll
    static void tearDownAll() {
        System.out.println("=== KẾT THÚC TEST SUITE SERVICE ===");
    }
    
    // ==================== TEST VALIDATE ĐĂNG KÝ ====================
    
    @Nested
    @DisplayName("Test Validate Đăng Ký")
    class ValidateDangKyTest {
        
        @Test
        @Order(1)
        @DisplayName("TC40: Validate thành công với dữ liệu hợp lệ")
        void testValidate_ThanhCong() {
            when(khachHangRepository.existsByMaKhachHang(anyString())).thenReturn(false);
            when(khachHangRepository.existsByEmail(anyString())).thenReturn(false);
            
            List<String> errors = khachHangService.validateDangKy(validDTO);
            
            assertTrue(errors.isEmpty());
        }
        
        @Test
        @Order(2)
        @DisplayName("TC41: Validate thất bại - Mã khách hàng đã tồn tại")
        void testValidate_MaKhachHang_DaTonTai() {
            when(khachHangRepository.existsByMaKhachHang(anyString())).thenReturn(true);
            when(khachHangRepository.existsByEmail(anyString())).thenReturn(false);
            
            List<String> errors = khachHangService.validateDangKy(validDTO);
            
            assertTrue(errors.contains("Mã khách hàng đã tồn tại trong hệ thống"));
        }
        
        @Test
        @Order(3)
        @DisplayName("TC42: Validate thất bại - Email đã được sử dụng")
        void testValidate_Email_DaTonTai() {
            when(khachHangRepository.existsByMaKhachHang(anyString())).thenReturn(false);
            when(khachHangRepository.existsByEmail(anyString())).thenReturn(true);
            
            List<String> errors = khachHangService.validateDangKy(validDTO);
            
            assertTrue(errors.contains("Email đã được sử dụng"));
        }
        
        @Test
        @Order(4)
        @DisplayName("TC43: Validate thất bại - Mật khẩu xác nhận không khớp")
        void testValidate_MatKhau_KhongKhop() {
            when(khachHangRepository.existsByMaKhachHang(anyString())).thenReturn(false);
            when(khachHangRepository.existsByEmail(anyString())).thenReturn(false);
            
            validDTO.setXacNhanMatKhau("password456");
            List<String> errors = khachHangService.validateDangKy(validDTO);
            
            assertTrue(errors.contains("Mật khẩu xác nhận không khớp"));
        }
        
        @Test
        @Order(5)
        @DisplayName("TC44: Validate thất bại - Người dùng chưa đủ 18 tuổi")
        void testValidate_NgaySinh_Chua18Tuoi() {
            when(khachHangRepository.existsByMaKhachHang(anyString())).thenReturn(false);
            when(khachHangRepository.existsByEmail(anyString())).thenReturn(false);
            
            validDTO.setNgaySinh(LocalDate.now().minusYears(17));
            List<String> errors = khachHangService.validateDangKy(validDTO);
            
            assertTrue(errors.contains("Người dùng phải đủ 18 tuổi"));
        }
        
        @Test
        @Order(6)
        @DisplayName("TC45: Validate thành công - Người dùng đúng 18 tuổi")
        void testValidate_NgaySinh_Dung18Tuoi() {
            when(khachHangRepository.existsByMaKhachHang(anyString())).thenReturn(false);
            when(khachHangRepository.existsByEmail(anyString())).thenReturn(false);
            
            validDTO.setNgaySinh(LocalDate.now().minusYears(18));
            List<String> errors = khachHangService.validateDangKy(validDTO);
            
            assertFalse(errors.contains("Người dùng phải đủ 18 tuổi"));
        }
        
        @Test
        @Order(7)
        @DisplayName("TC46: Validate thất bại - Không đồng ý điều khoản")
        void testValidate_DieuKhoan_KhongDongY() {
            when(khachHangRepository.existsByMaKhachHang(anyString())).thenReturn(false);
            when(khachHangRepository.existsByEmail(anyString())).thenReturn(false);
            
            validDTO.setDongYDieuKhoan(false);
            List<String> errors = khachHangService.validateDangKy(validDTO);
            
            assertTrue(errors.contains("Bạn phải đồng ý với điều khoản dịch vụ"));
        }
        
        @Test
        @Order(8)
        @DisplayName("TC47: Validate thất bại - Nhiều lỗi cùng lúc")
        void testValidate_NhieuLoi() {
            when(khachHangRepository.existsByMaKhachHang(anyString())).thenReturn(true);
            when(khachHangRepository.existsByEmail(anyString())).thenReturn(true);
            
            validDTO.setXacNhanMatKhau("password456");
            validDTO.setDongYDieuKhoan(false);
            validDTO.setNgaySinh(LocalDate.now().minusYears(17));
            
            List<String> errors = khachHangService.validateDangKy(validDTO);
            
            assertEquals(5, errors.size());
        }
        
        @Test
        @Order(9)
        @DisplayName("TC48: Validate thành công - Ngày sinh null (không bắt buộc)")
        void testValidate_NgaySinh_Null() {
            when(khachHangRepository.existsByMaKhachHang(anyString())).thenReturn(false);
            when(khachHangRepository.existsByEmail(anyString())).thenReturn(false);
            
            validDTO.setNgaySinh(null);
            List<String> errors = khachHangService.validateDangKy(validDTO);
            
            assertFalse(errors.contains("Người dùng phải đủ 18 tuổi"));
        }
    }
    
    // ==================== TEST ĐĂNG KÝ ====================
    
    @Nested
    @DisplayName("Test Đăng Ký Khách Hàng")
    class DangKyTest {
        
        @Test
        @Order(1)
        @DisplayName("TC49: Đăng ký thành công")
        void testDangKy_ThanhCong() {
            KhachHang savedKhachHang = new KhachHang();
            savedKhachHang.setMaKhachHang("KH000001");
            savedKhachHang.setHoTen("Nguyễn Văn An");
            savedKhachHang.setEmail("nguyenvanan@email.com");
            
            when(khachHangRepository.save(any(KhachHang.class))).thenReturn(savedKhachHang);
            
            KhachHang result = khachHangService.dangKy(validDTO);
            
            assertNotNull(result);
            assertEquals("KH000001", result.getMaKhachHang());
            verify(khachHangRepository, times(1)).save(any(KhachHang.class));
        }
        
        @Test
        @Order(2)
        @DisplayName("TC50: Đăng ký với giới tính Nam")
        void testDangKy_GioiTinh_Nam() {
            KhachHang savedKhachHang = new KhachHang();
            savedKhachHang.setGioiTinh("Nam");
            
            when(khachHangRepository.save(any(KhachHang.class))).thenReturn(savedKhachHang);
            
            validDTO.setGioiTinh("Nam");
            KhachHang result = khachHangService.dangKy(validDTO);
            
            assertEquals("Nam", result.getGioiTinh());
        }
        
        @Test
        @Order(3)
        @DisplayName("TC51: Đăng ký với giới tính Nữ")
        void testDangKy_GioiTinh_Nu() {
            KhachHang savedKhachHang = new KhachHang();
            savedKhachHang.setGioiTinh("Nữ");
            
            when(khachHangRepository.save(any(KhachHang.class))).thenReturn(savedKhachHang);
            
            validDTO.setGioiTinh("Nữ");
            KhachHang result = khachHangService.dangKy(validDTO);
            
            assertEquals("Nữ", result.getGioiTinh());
        }
        
        @Test
        @Order(4)
        @DisplayName("TC52: Đăng ký với giới tính Khác")
        void testDangKy_GioiTinh_Khac() {
            KhachHang savedKhachHang = new KhachHang();
            savedKhachHang.setGioiTinh("Khác");
            
            when(khachHangRepository.save(any(KhachHang.class))).thenReturn(savedKhachHang);
            
            validDTO.setGioiTinh("Khác");
            KhachHang result = khachHangService.dangKy(validDTO);
            
            assertEquals("Khác", result.getGioiTinh());
        }
        
        @Test
        @Order(5)
        @DisplayName("TC53: Đăng ký không chọn giới tính")
        void testDangKy_GioiTinh_Null() {
            KhachHang savedKhachHang = new KhachHang();
            savedKhachHang.setGioiTinh(null);
            
            when(khachHangRepository.save(any(KhachHang.class))).thenReturn(savedKhachHang);
            
            validDTO.setGioiTinh(null);
            KhachHang result = khachHangService.dangKy(validDTO);
            
            assertNull(result.getGioiTinh());
        }
    }
    
    // ==================== TEST EXISTS ====================
    
    @Nested
    @DisplayName("Test Kiểm Tra Tồn Tại")
    class ExistsTest {
        
        @Test
        @Order(1)
        @DisplayName("TC54: Kiểm tra mã khách hàng tồn tại")
        void testExistsByMaKhachHang_True() {
            when(khachHangRepository.existsByMaKhachHang("KH000001")).thenReturn(true);
            
            boolean result = khachHangService.existsByMaKhachHang("KH000001");
            
            assertTrue(result);
        }
        
        @Test
        @Order(2)
        @DisplayName("TC55: Kiểm tra mã khách hàng không tồn tại")
        void testExistsByMaKhachHang_False() {
            when(khachHangRepository.existsByMaKhachHang("KH999999")).thenReturn(false);
            
            boolean result = khachHangService.existsByMaKhachHang("KH999999");
            
            assertFalse(result);
        }
        
        @Test
        @Order(3)
        @DisplayName("TC56: Kiểm tra email tồn tại")
        void testExistsByEmail_True() {
            when(khachHangRepository.existsByEmail("nguyenvanan@email.com")).thenReturn(true);
            
            boolean result = khachHangService.existsByEmail("nguyenvanan@email.com");
            
            assertTrue(result);
        }
        
        @Test
        @Order(4)
        @DisplayName("TC57: Kiểm tra email không tồn tại")
        void testExistsByEmail_False() {
            when(khachHangRepository.existsByEmail("newemail@email.com")).thenReturn(false);
            
            boolean result = khachHangService.existsByEmail("newemail@email.com");
            
            assertFalse(result);
        }
    }
}
