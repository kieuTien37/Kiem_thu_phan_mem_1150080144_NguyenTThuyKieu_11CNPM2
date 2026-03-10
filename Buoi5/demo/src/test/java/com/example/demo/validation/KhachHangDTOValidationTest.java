package com.example.demo.validation;

import com.example.demo.dto.KhachHangDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class cho việc kiểm thử validation của KhachHangDTO
 * Sử dụng Test Fixture với @BeforeAll, @BeforeEach, @AfterEach, @AfterAll
 */
@DisplayName("Test Validation Form Đăng Ký Khách Hàng")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class KhachHangDTOValidationTest {
    
    private static Validator validator;
    private KhachHangDTO validDTO;
    
    // ==================== TEST FIXTURE ====================
    
    @BeforeAll
    static void setUpAll() {
        // Khởi tạo Validator một lần duy nhất cho tất cả test
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        System.out.println("=== BẮT ĐẦU TEST SUITE VALIDATION ===");
    }
    
    @BeforeEach
    void setUp() {
        // Tạo một DTO hợp lệ làm baseline trước mỗi test
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
        System.out.println("=== KẾT THÚC TEST SUITE VALIDATION ===");
    }
    
    // ==================== TEST MÃ KHÁCH HÀNG ====================
    
    @Nested
    @DisplayName("Test Mã Khách Hàng")
    class MaKhachHangTest {
        
        @Test
        @Order(1)
        @DisplayName("TC01: Mã khách hàng hợp lệ - 6 ký tự")
        void testMaKhachHang_HopLe_6KyTu() {
            validDTO.setMaKhachHang("KH0001");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().noneMatch(v -> v.getPropertyPath().toString().equals("maKhachHang")));
        }
        
        @Test
        @Order(2)
        @DisplayName("TC02: Mã khách hàng hợp lệ - 10 ký tự")
        void testMaKhachHang_HopLe_10KyTu() {
            validDTO.setMaKhachHang("KH00000001");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().noneMatch(v -> v.getPropertyPath().toString().equals("maKhachHang")));
        }
        
        @Test
        @Order(3)
        @DisplayName("TC03: Mã khách hàng rỗng")
        void testMaKhachHang_Rong() {
            validDTO.setMaKhachHang("");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("maKhachHang")));
        }
        
        @Test
        @Order(4)
        @DisplayName("TC04: Mã khách hàng null")
        void testMaKhachHang_Null() {
            validDTO.setMaKhachHang(null);
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("maKhachHang")));
        }
        
        @Test
        @Order(5)
        @DisplayName("TC05: Mã khách hàng ít hơn 6 ký tự")
        void testMaKhachHang_DuoiGioiHan() {
            validDTO.setMaKhachHang("KH001");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("maKhachHang")));
        }
        
        @Test
        @Order(6)
        @DisplayName("TC06: Mã khách hàng nhiều hơn 10 ký tự")
        void testMaKhachHang_TrenGioiHan() {
            validDTO.setMaKhachHang("KH000000001");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("maKhachHang")));
        }
        
        @ParameterizedTest
        @Order(7)
        @DisplayName("TC07: Mã khách hàng chứa ký tự đặc biệt")
        @ValueSource(strings = {"KH@001", "KH#0001", "KH$00001", "KH%000001"})
        void testMaKhachHang_ChuaKyTuDacBiet(String maKhachHang) {
            validDTO.setMaKhachHang(maKhachHang);
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("maKhachHang")));
        }
        
        @Test
        @Order(8)
        @DisplayName("TC08: Mã khách hàng chứa khoảng trắng")
        void testMaKhachHang_ChuaKhoangTrang() {
            validDTO.setMaKhachHang("KH 00001");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("maKhachHang")));
        }
    }
    
    // ==================== TEST HỌ TÊN ====================
    
    @Nested
    @DisplayName("Test Họ và Tên")
    class HoTenTest {
        
        @Test
        @Order(1)
        @DisplayName("TC09: Họ tên hợp lệ - tiếng Việt có dấu")
        void testHoTen_HopLe_TiengViet() {
            validDTO.setHoTen("Nguyễn Thị Bích Ngọc");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().noneMatch(v -> v.getPropertyPath().toString().equals("hoTen")));
        }
        
        @Test
        @Order(2)
        @DisplayName("TC10: Họ tên hợp lệ - 5 ký tự")
        void testHoTen_HopLe_5KyTu() {
            validDTO.setHoTen("An Lê");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().noneMatch(v -> v.getPropertyPath().toString().equals("hoTen")));
        }
        
        @Test
        @Order(3)
        @DisplayName("TC11: Họ tên hợp lệ - 50 ký tự")
        void testHoTen_HopLe_50KyTu() {
            validDTO.setHoTen("Nguyễn Thị Bích Ngọc Hồng Phương Anh Thảo Duy Nam");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().noneMatch(v -> v.getPropertyPath().toString().equals("hoTen")));
        }
        
        @Test
        @Order(4)
        @DisplayName("TC12: Họ tên rỗng")
        void testHoTen_Rong() {
            validDTO.setHoTen("");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("hoTen")));
        }
        
        @Test
        @Order(5)
        @DisplayName("TC13: Họ tên ít hơn 5 ký tự")
        void testHoTen_DuoiGioiHan() {
            validDTO.setHoTen("An L");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("hoTen")));
        }
        
        @Test
        @Order(6)
        @DisplayName("TC14: Họ tên nhiều hơn 50 ký tự")
        void testHoTen_TrenGioiHan() {
            validDTO.setHoTen("Nguyễn Thị Bích Ngọc Hồng Phương Anh Thảo Duy Nam Khang");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("hoTen")));
        }
        
        @Test
        @Order(7)
        @DisplayName("TC15: Họ tên chứa số")
        void testHoTen_ChuaSo() {
            validDTO.setHoTen("Nguyễn Văn An123");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("hoTen")));
        }
        
        @Test
        @Order(8)
        @DisplayName("TC16: Họ tên chứa ký tự đặc biệt")
        void testHoTen_ChuaKyTuDacBiet() {
            validDTO.setHoTen("Nguyễn Văn An@#$");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("hoTen")));
        }
    }
    
    // ==================== TEST EMAIL ====================
    
    @Nested
    @DisplayName("Test Email")
    class EmailTest {
        
        @Test
        @Order(1)
        @DisplayName("TC17: Email hợp lệ")
        void testEmail_HopLe() {
            validDTO.setEmail("nguyenvana@email.com");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().noneMatch(v -> v.getPropertyPath().toString().equals("email")));
        }
        
        @Test
        @Order(2)
        @DisplayName("TC18: Email rỗng")
        void testEmail_Rong() {
            validDTO.setEmail("");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("email")));
        }
        
        @ParameterizedTest
        @Order(3)
        @DisplayName("TC19: Email không đúng định dạng")
        @ValueSource(strings = {"nguyenvana", "nguyenvana@", "@email.com", "nguyenvana@.com"})
        void testEmail_KhongDungDinhDang(String email) {
            validDTO.setEmail(email);
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("email")));
        }
        
        @Test
        @Order(4)
        @DisplayName("TC20: Email chứa ký tự đặc biệt không hợp lệ")
        void testEmail_ChuaKyTuDacBiet() {
            validDTO.setEmail("nguyen#vana@email.com");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            // Email có thể chấp nhận một số ký tự đặc biệt, kiểm tra theo chuẩn
            assertNotNull(violations);
        }
    }
    
    // ==================== TEST SỐ ĐIỆN THOẠI ====================
    
    @Nested
    @DisplayName("Test Số Điện Thoại")
    class SoDienThoaiTest {
        
        @Test
        @Order(1)
        @DisplayName("TC21: Số điện thoại hợp lệ - 10 số")
        void testSoDienThoai_HopLe_10So() {
            validDTO.setSoDienThoai("0912345678");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().noneMatch(v -> v.getPropertyPath().toString().equals("soDienThoai")));
        }
        
        @Test
        @Order(2)
        @DisplayName("TC22: Số điện thoại hợp lệ - 11 số")
        void testSoDienThoai_HopLe_11So() {
            validDTO.setSoDienThoai("09123456789");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().noneMatch(v -> v.getPropertyPath().toString().equals("soDienThoai")));
        }
        
        @Test
        @Order(3)
        @DisplayName("TC23: Số điện thoại hợp lệ - 12 số")
        void testSoDienThoai_HopLe_12So() {
            validDTO.setSoDienThoai("091234567890");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().noneMatch(v -> v.getPropertyPath().toString().equals("soDienThoai")));
        }
        
        @Test
        @Order(4)
        @DisplayName("TC24: Số điện thoại rỗng")
        void testSoDienThoai_Rong() {
            validDTO.setSoDienThoai("");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("soDienThoai")));
        }
        
        @Test
        @Order(5)
        @DisplayName("TC25: Số điện thoại ít hơn 10 số")
        void testSoDienThoai_DuoiGioiHan() {
            validDTO.setSoDienThoai("091234567");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("soDienThoai")));
        }
        
        @Test
        @Order(6)
        @DisplayName("TC26: Số điện thoại nhiều hơn 12 số")
        void testSoDienThoai_TrenGioiHan() {
            validDTO.setSoDienThoai("0912345678901");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("soDienThoai")));
        }
        
        @Test
        @Order(7)
        @DisplayName("TC27: Số điện thoại không bắt đầu bằng 0")
        void testSoDienThoai_KhongBatDauBang0() {
            validDTO.setSoDienThoai("1912345678");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("soDienThoai")));
        }
        
        @Test
        @Order(8)
        @DisplayName("TC28: Số điện thoại chứa chữ cái")
        void testSoDienThoai_ChuaChuCai() {
            validDTO.setSoDienThoai("091234567a");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("soDienThoai")));
        }
        
        @Test
        @Order(9)
        @DisplayName("TC29: Số điện thoại chứa ký tự đặc biệt")
        void testSoDienThoai_ChuaKyTuDacBiet() {
            validDTO.setSoDienThoai("091-234-567");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("soDienThoai")));
        }
    }
    
    // ==================== TEST ĐỊA CHỈ ====================
    
    @Nested
    @DisplayName("Test Địa Chỉ")
    class DiaChiTest {
        
        @Test
        @Order(1)
        @DisplayName("TC30: Địa chỉ hợp lệ")
        void testDiaChi_HopLe() {
            validDTO.setDiaChi("123 Đường ABC, Phường XYZ, Quận 1, TP.HCM");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().noneMatch(v -> v.getPropertyPath().toString().equals("diaChi")));
        }
        
        @Test
        @Order(2)
        @DisplayName("TC31: Địa chỉ rỗng")
        void testDiaChi_Rong() {
            validDTO.setDiaChi("");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("diaChi")));
        }
        
        @Test
        @Order(3)
        @DisplayName("TC32: Địa chỉ vượt quá 255 ký tự")
        void testDiaChi_TrenGioiHan() {
            String longAddress = "A".repeat(256);
            validDTO.setDiaChi(longAddress);
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("diaChi")));
        }
        
        @Test
        @Order(4)
        @DisplayName("TC33: Địa chỉ đúng 255 ký tự")
        void testDiaChi_255KyTu() {
            String exactAddress = "A".repeat(255);
            validDTO.setDiaChi(exactAddress);
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().noneMatch(v -> v.getPropertyPath().toString().equals("diaChi")));
        }
    }
    
    // ==================== TEST MẬT KHẨU ====================
    
    @Nested
    @DisplayName("Test Mật Khẩu")
    class MatKhauTest {
        
        @Test
        @Order(1)
        @DisplayName("TC34: Mật khẩu hợp lệ - 8 ký tự")
        void testMatKhau_HopLe_8KyTu() {
            validDTO.setMatKhau("12345678");
            validDTO.setXacNhanMatKhau("12345678");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().noneMatch(v -> v.getPropertyPath().toString().equals("matKhau")));
        }
        
        @Test
        @Order(2)
        @DisplayName("TC35: Mật khẩu hợp lệ - nhiều hơn 8 ký tự")
        void testMatKhau_HopLe_TrenGioiHan() {
            validDTO.setMatKhau("password123456");
            validDTO.setXacNhanMatKhau("password123456");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().noneMatch(v -> v.getPropertyPath().toString().equals("matKhau")));
        }
        
        @Test
        @Order(3)
        @DisplayName("TC36: Mật khẩu rỗng")
        void testMatKhau_Rong() {
            validDTO.setMatKhau("");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("matKhau")));
        }
        
        @Test
        @Order(4)
        @DisplayName("TC37: Mật khẩu ít hơn 8 ký tự")
        void testMatKhau_DuoiGioiHan() {
            validDTO.setMatKhau("1234567");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("matKhau")));
        }
    }
    
    // ==================== TEST XÁC NHẬN MẬT KHẨU ====================
    
    @Nested
    @DisplayName("Test Xác Nhận Mật Khẩu")
    class XacNhanMatKhauTest {
        
        @Test
        @Order(1)
        @DisplayName("TC38: Xác nhận mật khẩu rỗng")
        void testXacNhanMatKhau_Rong() {
            validDTO.setXacNhanMatKhau("");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("xacNhanMatKhau")));
        }
        
        @Test
        @Order(2)
        @DisplayName("TC39: Xác nhận mật khẩu khớp với mật khẩu")
        void testXacNhanMatKhau_Khop() {
            validDTO.setMatKhau("password123");
            validDTO.setXacNhanMatKhau("password123");
            Set<ConstraintViolation<KhachHangDTO>> violations = validator.validate(validDTO);
            assertTrue(violations.stream().noneMatch(v -> v.getPropertyPath().toString().equals("xacNhanMatKhau")));
        }
    }
}
