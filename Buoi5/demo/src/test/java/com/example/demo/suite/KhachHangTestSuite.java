package com.example.demo.suite;

import com.example.demo.service.KhachHangServiceTest;
import com.example.demo.validation.KhachHangDTOValidationTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

/**
 * Test Suite tổng hợp tất cả các test case cho Form Đăng Ký Khách Hàng
 * Bao gồm:
 * - KhachHangDTOValidationTest: Test validation annotation
 * - KhachHangServiceTest: Test business logic
 */
@Suite
@SuiteDisplayName("Test Suite Đăng Ký Khách Hàng")
@SelectClasses({
    KhachHangDTOValidationTest.class,
    KhachHangServiceTest.class
})
public class KhachHangTestSuite {
    // Test Suite này tự động chạy tất cả các test class đã chọn
}
