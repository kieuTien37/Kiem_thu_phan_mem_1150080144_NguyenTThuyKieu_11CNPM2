package com.example.demo.repository;

import com.example.demo.entity.KhachHang;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class cho KhachHangRepository
 * Sử dụng @DataJpaTest để test với embedded database
 */
@SpringBootTest
@ActiveProfiles("test")
@DisplayName("Test KhachHangRepository")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class KhachHangRepositoryTest {
    
    @Autowired
    private KhachHangRepository khachHangRepository;
    
    private KhachHang khachHang;
    
    // ==================== TEST FIXTURE ====================
    
    @BeforeEach
    void setUp() {
        // Xóa tất cả dữ liệu trước mỗi test
        khachHangRepository.deleteAll();
        
        // Tạo khách hàng mẫu
        khachHang = new KhachHang();
        khachHang.setMaKhachHang("KH000001");
        khachHang.setHoTen("Nguyễn Văn An");
        khachHang.setEmail("nguyenvanan@email.com");
        khachHang.setSoDienThoai("0912345678");
        khachHang.setDiaChi("123 Đường ABC, Quận 1, TP.HCM");
        khachHang.setMatKhau("password123");
        khachHang.setNgaySinh(LocalDate.of(2000, 1, 1));
        khachHang.setGioiTinh("Nam");
    }
    
    @AfterEach
    void tearDown() {
        khachHangRepository.deleteAll();
    }
    
    // ==================== TEST SAVE ====================
    
    @Nested
    @DisplayName("Test Lưu Khách Hàng")
    class SaveTest {
        
        @Test
        @Order(1)
        @DisplayName("TC58: Lưu khách hàng thành công")
        void testSave_ThanhCong() {
            KhachHang saved = khachHangRepository.save(khachHang);
            
            assertNotNull(saved);
            assertEquals("KH000001", saved.getMaKhachHang());
            assertEquals("Nguyễn Văn An", saved.getHoTen());
        }
        
        @Test
        @Order(2)
        @DisplayName("TC59: Lưu khách hàng với tất cả thông tin")
        void testSave_TatCaThongTin() {
            KhachHang saved = khachHangRepository.save(khachHang);
            
            assertEquals("nguyenvanan@email.com", saved.getEmail());
            assertEquals("0912345678", saved.getSoDienThoai());
            assertEquals("123 Đường ABC, Quận 1, TP.HCM", saved.getDiaChi());
            assertEquals(LocalDate.of(2000, 1, 1), saved.getNgaySinh());
            assertEquals("Nam", saved.getGioiTinh());
        }
    }
    
    // ==================== TEST FIND ====================
    
    @Nested
    @DisplayName("Test Tìm Kiếm Khách Hàng")
    class FindTest {
        
        @Test
        @Order(1)
        @DisplayName("TC60: Tìm khách hàng theo mã - tìm thấy")
        void testFindByMaKhachHang_TimThay() {
            khachHangRepository.save(khachHang);
            
            Optional<KhachHang> found = khachHangRepository.findByMaKhachHang("KH000001");
            
            assertTrue(found.isPresent());
            assertEquals("Nguyễn Văn An", found.get().getHoTen());
        }
        
        @Test
        @Order(2)
        @DisplayName("TC61: Tìm khách hàng theo mã - không tìm thấy")
        void testFindByMaKhachHang_KhongTimThay() {
            Optional<KhachHang> found = khachHangRepository.findByMaKhachHang("KH999999");
            
            assertTrue(found.isEmpty());
        }
        
        @Test
        @Order(3)
        @DisplayName("TC62: Tìm khách hàng theo email - tìm thấy")
        void testFindByEmail_TimThay() {
            khachHangRepository.save(khachHang);
            
            Optional<KhachHang> found = khachHangRepository.findByEmail("nguyenvanan@email.com");
            
            assertTrue(found.isPresent());
            assertEquals("KH000001", found.get().getMaKhachHang());
        }
        
        @Test
        @Order(4)
        @DisplayName("TC63: Tìm khách hàng theo email - không tìm thấy")
        void testFindByEmail_KhongTimThay() {
            Optional<KhachHang> found = khachHangRepository.findByEmail("notfound@email.com");
            
            assertTrue(found.isEmpty());
        }
    }
    
    // ==================== TEST EXISTS ====================
    
    @Nested
    @DisplayName("Test Kiểm Tra Tồn Tại")
    class ExistsTest {
        
        @Test
        @Order(1)
        @DisplayName("TC64: Kiểm tra mã khách hàng tồn tại - true")
        void testExistsByMaKhachHang_True() {
            khachHangRepository.save(khachHang);
            
            boolean exists = khachHangRepository.existsByMaKhachHang("KH000001");
            
            assertTrue(exists);
        }
        
        @Test
        @Order(2)
        @DisplayName("TC65: Kiểm tra mã khách hàng tồn tại - false")
        void testExistsByMaKhachHang_False() {
            boolean exists = khachHangRepository.existsByMaKhachHang("KH999999");
            
            assertFalse(exists);
        }
        
        @Test
        @Order(3)
        @DisplayName("TC66: Kiểm tra email tồn tại - true")
        void testExistsByEmail_True() {
            khachHangRepository.save(khachHang);
            
            boolean exists = khachHangRepository.existsByEmail("nguyenvanan@email.com");
            
            assertTrue(exists);
        }
        
        @Test
        @Order(4)
        @DisplayName("TC67: Kiểm tra email tồn tại - false")
        void testExistsByEmail_False() {
            boolean exists = khachHangRepository.existsByEmail("notfound@email.com");
            
            assertFalse(exists);
        }
    }
    
    // ==================== TEST DELETE ====================
    
    @Nested
    @DisplayName("Test Xóa Khách Hàng")
    class DeleteTest {
        
        @Test
        @Order(1)
        @DisplayName("TC68: Xóa khách hàng thành công")
        void testDelete_ThanhCong() {
            khachHangRepository.save(khachHang);
            assertTrue(khachHangRepository.existsByMaKhachHang("KH000001"));
            
            khachHangRepository.deleteById("KH000001");
            
            assertFalse(khachHangRepository.existsByMaKhachHang("KH000001"));
        }
    }
}
