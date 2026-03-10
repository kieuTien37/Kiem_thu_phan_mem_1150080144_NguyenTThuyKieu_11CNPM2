# BẢNG TEST CASE - FORM ĐĂNG KÝ TÀI KHOẢN KHÁCH HÀNG

## Thông tin chung
- **Ngày tạo:** 27/01/2026
- **Người tạo:** Sinh viên
- **Môn học:** Kiểm thử phần mềm - Buổi 5
- **Mục tiêu:** Kiểm thử chức năng form đăng ký tài khoản khách hàng

---

## 1. TEST CASE CHO TRƯỜNG MÃ KHÁCH HÀNG

| STT | Test Case ID | Mô tả Test Case | Dữ liệu đầu vào | Kết quả mong đợi | Loại Test |
|-----|--------------|-----------------|-----------------|------------------|-----------|
| 1 | TC_MKH_01 | Mã khách hàng hợp lệ - 6 ký tự | "KH0001" | Pass - Không có lỗi | Positive |
| 2 | TC_MKH_02 | Mã khách hàng hợp lệ - 10 ký tự | "KH00000001" | Pass - Không có lỗi | Positive |
| 3 | TC_MKH_03 | Mã khách hàng hợp lệ - 8 ký tự | "KH000001" | Pass - Không có lỗi | Positive |
| 4 | TC_MKH_04 | Mã khách hàng rỗng | "" | Fail - "Mã khách hàng không được để trống" | Negative |
| 5 | TC_MKH_05 | Mã khách hàng null | null | Fail - "Mã khách hàng không được để trống" | Negative |
| 6 | TC_MKH_06 | Mã khách hàng ít hơn 6 ký tự | "KH001" | Fail - "Mã khách hàng phải từ 6 đến 10 ký tự" | Boundary |
| 7 | TC_MKH_07 | Mã khách hàng nhiều hơn 10 ký tự | "KH000000001" | Fail - "Mã khách hàng phải từ 6 đến 10 ký tự" | Boundary |
| 8 | TC_MKH_08 | Mã khách hàng chứa ký tự đặc biệt @ | "KH@0001" | Fail - "Mã khách hàng chỉ được chứa chữ cái và số" | Negative |
| 9 | TC_MKH_09 | Mã khách hàng chứa ký tự đặc biệt # | "KH#0001" | Fail - "Mã khách hàng chỉ được chứa chữ cái và số" | Negative |
| 10 | TC_MKH_10 | Mã khách hàng chứa khoảng trắng | "KH 00001" | Fail - "Mã khách hàng chỉ được chứa chữ cái và số" | Negative |
| 11 | TC_MKH_11 | Mã khách hàng đã tồn tại | "KH000001" (đã có trong DB) | Fail - "Mã khách hàng đã tồn tại trong hệ thống" | Negative |

---

## 2. TEST CASE CHO TRƯỜNG HỌ VÀ TÊN

| STT | Test Case ID | Mô tả Test Case | Dữ liệu đầu vào | Kết quả mong đợi | Loại Test |
|-----|--------------|-----------------|-----------------|------------------|-----------|
| 12 | TC_HT_01 | Họ tên hợp lệ - tiếng Việt có dấu | "Nguyễn Văn An" | Pass - Không có lỗi | Positive |
| 13 | TC_HT_02 | Họ tên hợp lệ - 5 ký tự | "An Lê" | Pass - Không có lỗi | Boundary |
| 14 | TC_HT_03 | Họ tên hợp lệ - 50 ký tự | "Nguyễn Thị Bích Ngọc Hồng Phương Anh Thảo Duy Nam" | Pass - Không có lỗi | Boundary |
| 15 | TC_HT_04 | Họ tên rỗng | "" | Fail - "Họ và tên không được để trống" | Negative |
| 16 | TC_HT_05 | Họ tên null | null | Fail - "Họ và tên không được để trống" | Negative |
| 17 | TC_HT_06 | Họ tên ít hơn 5 ký tự | "An L" | Fail - "Họ và tên phải từ 5 đến 50 ký tự" | Boundary |
| 18 | TC_HT_07 | Họ tên nhiều hơn 50 ký tự | "Nguyễn Thị Bích Ngọc Hồng Phương Anh Thảo Duy Nam Khang" | Fail - "Họ và tên phải từ 5 đến 50 ký tự" | Boundary |
| 19 | TC_HT_08 | Họ tên chứa số | "Nguyễn Văn An123" | Fail - "Họ và tên chỉ được chứa chữ cái và khoảng trắng" | Negative |
| 20 | TC_HT_09 | Họ tên chứa ký tự đặc biệt | "Nguyễn Văn An@#$" | Fail - "Họ và tên chỉ được chứa chữ cái và khoảng trắng" | Negative |

---

## 3. TEST CASE CHO TRƯỜNG EMAIL

| STT | Test Case ID | Mô tả Test Case | Dữ liệu đầu vào | Kết quả mong đợi | Loại Test |
|-----|--------------|-----------------|-----------------|------------------|-----------|
| 21 | TC_EM_01 | Email hợp lệ | "nguyenvana@email.com" | Pass - Không có lỗi | Positive |
| 22 | TC_EM_02 | Email hợp lệ với subdomain | "nguyenvana@mail.email.com" | Pass - Không có lỗi | Positive |
| 23 | TC_EM_03 | Email rỗng | "" | Fail - "Email không được để trống" | Negative |
| 24 | TC_EM_04 | Email null | null | Fail - "Email không được để trống" | Negative |
| 25 | TC_EM_05 | Email thiếu @ | "nguyenvana.email.com" | Fail - "Email không đúng định dạng" | Negative |
| 26 | TC_EM_06 | Email thiếu domain | "nguyenvana@" | Fail - "Email không đúng định dạng" | Negative |
| 27 | TC_EM_07 | Email thiếu username | "@email.com" | Fail - "Email không đúng định dạng" | Negative |
| 28 | TC_EM_08 | Email thiếu .com | "nguyenvana@email" | Fail - "Email không đúng định dạng" | Negative |
| 29 | TC_EM_09 | Email đã tồn tại | "nguyenvana@email.com" (đã có trong DB) | Fail - "Email đã được sử dụng" | Negative |

---

## 4. TEST CASE CHO TRƯỜNG SỐ ĐIỆN THOẠI

| STT | Test Case ID | Mô tả Test Case | Dữ liệu đầu vào | Kết quả mong đợi | Loại Test |
|-----|--------------|-----------------|-----------------|------------------|-----------|
| 30 | TC_SDT_01 | Số điện thoại hợp lệ - 10 số | "0912345678" | Pass - Không có lỗi | Positive |
| 31 | TC_SDT_02 | Số điện thoại hợp lệ - 11 số | "09123456789" | Pass - Không có lỗi | Positive |
| 32 | TC_SDT_03 | Số điện thoại hợp lệ - 12 số | "091234567890" | Pass - Không có lỗi | Boundary |
| 33 | TC_SDT_04 | Số điện thoại rỗng | "" | Fail - "Số điện thoại không được để trống" | Negative |
| 34 | TC_SDT_05 | Số điện thoại null | null | Fail - "Số điện thoại không được để trống" | Negative |
| 35 | TC_SDT_06 | Số điện thoại ít hơn 10 số | "091234567" | Fail - "Số điện thoại phải từ 10 đến 12 ký tự" | Boundary |
| 36 | TC_SDT_07 | Số điện thoại nhiều hơn 12 số | "0912345678901" | Fail - "Số điện thoại phải từ 10 đến 12 ký tự" | Boundary |
| 37 | TC_SDT_08 | Số điện thoại không bắt đầu bằng 0 | "1912345678" | Fail - "Số điện thoại phải bắt đầu bằng số 0" | Negative |
| 38 | TC_SDT_09 | Số điện thoại chứa chữ cái | "091234567a" | Fail - "Số điện thoại chỉ được chứa số" | Negative |
| 39 | TC_SDT_10 | Số điện thoại chứa ký tự đặc biệt | "091-234-567" | Fail - "Số điện thoại chỉ được chứa số" | Negative |

---

## 5. TEST CASE CHO TRƯỜNG ĐỊA CHỈ

| STT | Test Case ID | Mô tả Test Case | Dữ liệu đầu vào | Kết quả mong đợi | Loại Test |
|-----|--------------|-----------------|-----------------|------------------|-----------|
| 40 | TC_DC_01 | Địa chỉ hợp lệ | "123 Đường ABC, Phường XYZ, Quận 1, TP.HCM" | Pass - Không có lỗi | Positive |
| 41 | TC_DC_02 | Địa chỉ rỗng | "" | Fail - "Địa chỉ không được để trống" | Negative |
| 42 | TC_DC_03 | Địa chỉ null | null | Fail - "Địa chỉ không được để trống" | Negative |
| 43 | TC_DC_04 | Địa chỉ đúng 255 ký tự | 255 ký tự "A" | Pass - Không có lỗi | Boundary |
| 44 | TC_DC_05 | Địa chỉ vượt quá 255 ký tự | 256 ký tự "A" | Fail - "Địa chỉ không được vượt quá 255 ký tự" | Boundary |

---

## 6. TEST CASE CHO TRƯỜNG MẬT KHẨU

| STT | Test Case ID | Mô tả Test Case | Dữ liệu đầu vào | Kết quả mong đợi | Loại Test |
|-----|--------------|-----------------|-----------------|------------------|-----------|
| 45 | TC_MK_01 | Mật khẩu hợp lệ - 8 ký tự | "12345678" | Pass - Không có lỗi | Boundary |
| 46 | TC_MK_02 | Mật khẩu hợp lệ - nhiều hơn 8 ký tự | "password123456" | Pass - Không có lỗi | Positive |
| 47 | TC_MK_03 | Mật khẩu rỗng | "" | Fail - "Mật khẩu không được để trống" | Negative |
| 48 | TC_MK_04 | Mật khẩu null | null | Fail - "Mật khẩu không được để trống" | Negative |
| 49 | TC_MK_05 | Mật khẩu ít hơn 8 ký tự | "1234567" | Fail - "Mật khẩu phải có ít nhất 8 ký tự" | Boundary |
| 50 | TC_MK_06 | Mật khẩu chỉ chứa số | "12345678" | Pass - Không có lỗi | Positive |
| 51 | TC_MK_07 | Mật khẩu chứa chữ và số | "Pass1234" | Pass - Không có lỗi | Positive |

---

## 7. TEST CASE CHO TRƯỜNG XÁC NHẬN MẬT KHẨU

| STT | Test Case ID | Mô tả Test Case | Dữ liệu đầu vào | Kết quả mong đợi | Loại Test |
|-----|--------------|-----------------|-----------------|------------------|-----------|
| 52 | TC_XNMK_01 | Xác nhận mật khẩu khớp | MK: "password123", XNMK: "password123" | Pass - Không có lỗi | Positive |
| 53 | TC_XNMK_02 | Xác nhận mật khẩu rỗng | "" | Fail - "Xác nhận mật khẩu không được để trống" | Negative |
| 54 | TC_XNMK_03 | Xác nhận mật khẩu không khớp | MK: "password123", XNMK: "password456" | Fail - "Mật khẩu xác nhận không khớp" | Negative |
| 55 | TC_XNMK_04 | Xác nhận mật khẩu khác chữ hoa/thường | MK: "Password123", XNMK: "password123" | Fail - "Mật khẩu xác nhận không khớp" | Negative |

---

## 8. TEST CASE CHO TRƯỜNG NGÀY SINH

| STT | Test Case ID | Mô tả Test Case | Dữ liệu đầu vào | Kết quả mong đợi | Loại Test |
|-----|--------------|-----------------|-----------------|------------------|-----------|
| 56 | TC_NS_01 | Ngày sinh hợp lệ - đủ 18 tuổi | 01/01/2008 (ngày hiện tại 27/01/2026) | Pass - Không có lỗi | Positive |
| 57 | TC_NS_02 | Ngày sinh hợp lệ - trên 18 tuổi | 01/01/2000 | Pass - Không có lỗi | Positive |
| 58 | TC_NS_03 | Ngày sinh null (không bắt buộc) | null | Pass - Không có lỗi | Positive |
| 59 | TC_NS_04 | Ngày sinh chưa đủ 18 tuổi | 01/01/2010 (16 tuổi) | Fail - "Người dùng phải đủ 18 tuổi" | Negative |
| 60 | TC_NS_05 | Ngày sinh - thiếu 1 ngày đủ 18 tuổi | 28/01/2008 (17 tuổi 364 ngày) | Fail - "Người dùng phải đủ 18 tuổi" | Boundary |

---

## 9. TEST CASE CHO TRƯỜNG GIỚI TÍNH

| STT | Test Case ID | Mô tả Test Case | Dữ liệu đầu vào | Kết quả mong đợi | Loại Test |
|-----|--------------|-----------------|-----------------|------------------|-----------|
| 61 | TC_GT_01 | Chọn giới tính Nam | "Nam" | Pass - Không có lỗi | Positive |
| 62 | TC_GT_02 | Chọn giới tính Nữ | "Nữ" | Pass - Không có lỗi | Positive |
| 63 | TC_GT_03 | Chọn giới tính Khác | "Khác" | Pass - Không có lỗi | Positive |
| 64 | TC_GT_04 | Không chọn giới tính (không bắt buộc) | null | Pass - Không có lỗi | Positive |

---

## 10. TEST CASE CHO ĐIỀU KHOẢN DỊCH VỤ

| STT | Test Case ID | Mô tả Test Case | Dữ liệu đầu vào | Kết quả mong đợi | Loại Test |
|-----|--------------|-----------------|-----------------|------------------|-----------|
| 65 | TC_DK_01 | Đồng ý điều khoản | true | Pass - Không có lỗi | Positive |
| 66 | TC_DK_02 | Không đồng ý điều khoản | false | Fail - "Bạn phải đồng ý với điều khoản dịch vụ" | Negative |

---

## 11. TEST CASE CHO CHỨC NĂNG ĐĂNG KÝ

| STT | Test Case ID | Mô tả Test Case | Dữ liệu đầu vào | Kết quả mong đợi | Loại Test |
|-----|--------------|-----------------|-----------------|------------------|-----------|
| 67 | TC_DK_FUNC_01 | Đăng ký thành công với tất cả thông tin hợp lệ | Tất cả trường hợp lệ | Pass - "Đăng ký tài khoản thành công!" | Positive |
| 68 | TC_DK_FUNC_02 | Đăng ký thất bại - có 1 lỗi validation | 1 trường không hợp lệ | Fail - Hiển thị thông báo lỗi tương ứng | Negative |
| 69 | TC_DK_FUNC_03 | Đăng ký thất bại - nhiều lỗi validation | Nhiều trường không hợp lệ | Fail - Hiển thị tất cả thông báo lỗi | Negative |

---

## 12. TEST CASE CHO CHỨC NĂNG NHẬP LẠI

| STT | Test Case ID | Mô tả Test Case | Dữ liệu đầu vào | Kết quả mong đợi | Loại Test |
|-----|--------------|-----------------|-----------------|------------------|-----------|
| 70 | TC_NL_01 | Nhấn nút Nhập lại - xóa tất cả dữ liệu | Form đã điền dữ liệu | Pass - Tất cả trường trở về trạng thái mặc định | Positive |

---

## TỔNG KẾT

| Loại Test | Số lượng |
|-----------|----------|
| Positive Test | 25 |
| Negative Test | 35 |
| Boundary Test | 10 |
| **Tổng cộng** | **70** |

---

## GHI CHÚ

1. **Positive Test**: Kiểm tra với dữ liệu hợp lệ, mong đợi kết quả thành công
2. **Negative Test**: Kiểm tra với dữ liệu không hợp lệ, mong đợi hệ thống báo lỗi
3. **Boundary Test**: Kiểm tra giá trị biên (min, max, min-1, max+1)

---

## HƯỚNG DẪN CHẠY TEST

```bash
# Chạy tất cả test
./mvnw test

# Chạy test suite
./mvnw test -Dtest=KhachHangTestSuite

# Chạy test validation
./mvnw test -Dtest=KhachHangDTOValidationTest

# Chạy test service
./mvnw test -Dtest=KhachHangServiceTest

# Chạy test repository
./mvnw test -Dtest=KhachHangRepositoryTest
```
