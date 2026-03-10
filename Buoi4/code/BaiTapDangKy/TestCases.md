# BẢNG TEST CASES - FORM ĐĂNG KÝ TÀI KHOẢN KHÁCH HÀNG

## 1. Test Cases cho trường Mã Khách Hàng

| TC ID | Mô tả | Dữ liệu đầu vào | Kết quả mong đợi | Loại test |
|-------|-------|-----------------|------------------|-----------|
| TC_MKH_01 | Để trống mã khách hàng | (để trống) | Hiển thị lỗi: "Mã khách hàng là bắt buộc." | Negative |
| TC_MKH_02 | Nhập mã có 5 ký tự (dưới giới hạn) | ABC12 | Hiển thị lỗi: "Mã khách hàng phải từ 6 đến 10 ký tự." | Boundary |
| TC_MKH_03 | Nhập mã có 6 ký tự (giới hạn dưới) | ABC123 | Hợp lệ, không có lỗi | Boundary |
| TC_MKH_04 | Nhập mã có 8 ký tự (trong giới hạn) | ABCD1234 | Hợp lệ, không có lỗi | Positive |
| TC_MKH_05 | Nhập mã có 10 ký tự (giới hạn trên) | ABCDE12345 | Hợp lệ, không có lỗi | Boundary |
| TC_MKH_06 | Nhập mã có 11 ký tự (trên giới hạn) | ABCDEF12345 | Hiển thị lỗi: "Mã khách hàng phải từ 6 đến 10 ký tự." | Boundary |
| TC_MKH_07 | Nhập mã có ký tự đặc biệt | ABC@123 | Hiển thị lỗi: "Mã khách hàng chỉ được chứa chữ cái và số." | Negative |
| TC_MKH_08 | Nhập mã có khoảng trắng | ABC 123 | Hiển thị lỗi: "Mã khách hàng chỉ được chứa chữ cái và số." | Negative |
| TC_MKH_09 | Nhập mã có tiếng Việt có dấu | MÃKH123 | Hiển thị lỗi: "Mã khách hàng chỉ được chứa chữ cái và số." | Negative |
| TC_MKH_10 | Nhập mã đã tồn tại | KH001234 | Hiển thị lỗi: "Mã khách hàng đã tồn tại." | Negative |
| TC_MKH_11 | Nhập mã chỉ có chữ cái | ABCDEFGH | Hợp lệ, không có lỗi | Positive |
| TC_MKH_12 | Nhập mã chỉ có số | 12345678 | Hợp lệ, không có lỗi | Positive |

---

## 2. Test Cases cho trường Họ và Tên

| TC ID | Mô tả | Dữ liệu đầu vào | Kết quả mong đợi | Loại test |
|-------|-------|-----------------|------------------|-----------|
| TC_HVT_01 | Để trống họ và tên | (để trống) | Hiển thị lỗi: "Họ và tên là bắt buộc." | Negative |
| TC_HVT_02 | Nhập họ tên có 4 ký tự (dưới giới hạn) | Hùng | Hiển thị lỗi: "Họ và tên phải từ 5 đến 50 ký tự." | Boundary |
| TC_HVT_03 | Nhập họ tên có 5 ký tự (giới hạn dưới) | Hùng A | Hợp lệ, không có lỗi | Boundary |
| TC_HVT_04 | Nhập họ tên có 25 ký tự (trong giới hạn) | Nguyễn Văn An | Hợp lệ, không có lỗi | Positive |
| TC_HVT_05 | Nhập họ tên có 50 ký tự (giới hạn trên) | Nguyễn Thị Kim Anh Nguyễn Thị Kim Anh Nguyễnnnnn | Hợp lệ, không có lỗi | Boundary |
| TC_HVT_06 | Nhập họ tên có 51 ký tự (trên giới hạn) | Nguyễn Thị Kim Anh Nguyễn Thị Kim Anh Nguyễnnnnnx | Hiển thị lỗi: "Họ và tên phải từ 5 đến 50 ký tự." | Boundary |
| TC_HVT_07 | Nhập họ tên có số | Nguyễn Văn 123 | Hiển thị lỗi: "Họ và tên chỉ được chứa chữ cái và khoảng trắng." | Negative |
| TC_HVT_08 | Nhập họ tên có ký tự đặc biệt | Nguyễn@Văn | Hiển thị lỗi: "Họ và tên chỉ được chứa chữ cái và khoảng trắng." | Negative |
| TC_HVT_09 | Nhập họ tên tiếng Việt có dấu | Nguyễn Thùy Kiều | Hợp lệ, không có lỗi | Positive |
| TC_HVT_10 | Nhập họ tên có khoảng trắng ở đầu và cuối | " Nguyễn Văn An " | Hợp lệ (sau khi trim) | Positive |

---

## 3. Test Cases cho trường Email

| TC ID | Mô tả | Dữ liệu đầu vào | Kết quả mong đợi | Loại test |
|-------|-------|-----------------|------------------|-----------|
| TC_EMAIL_01 | Để trống email | (để trống) | Hiển thị lỗi: "Email là bắt buộc." | Negative |
| TC_EMAIL_02 | Nhập email hợp lệ | nguyenvana@email.com | Hợp lệ, không có lỗi | Positive |
| TC_EMAIL_03 | Nhập email không có @ | nguyenvanemail.com | Hiển thị lỗi: "Email không đúng định dạng." | Negative |
| TC_EMAIL_04 | Nhập email không có tên miền | nguyenvana@ | Hiển thị lỗi: "Email không đúng định dạng." | Negative |
| TC_EMAIL_05 | Nhập email không có phần mở rộng | nguyenvana@email | Hiển thị lỗi: "Email không đúng định dạng." | Negative |
| TC_EMAIL_06 | Nhập email có nhiều @ | nguyen@@email.com | Hiển thị lỗi: "Email không đúng định dạng." | Negative |
| TC_EMAIL_07 | Nhập email có khoảng trắng | nguyen vana@email.com | Hiển thị lỗi: "Email không đúng định dạng." | Negative |
| TC_EMAIL_08 | Nhập email đã tồn tại | admin@email.com | Hiển thị lỗi: "Email đã được sử dụng." | Negative |
| TC_EMAIL_09 | Nhập email với tên miền phụ | user@mail.company.com | Hợp lệ, không có lỗi | Positive |
| TC_EMAIL_10 | Nhập email viết hoa (đã tồn tại) | ADMIN@EMAIL.COM | Hiển thị lỗi: "Email đã được sử dụng." | Negative |

---

## 4. Test Cases cho trường Số điện thoại

| TC ID | Mô tả | Dữ liệu đầu vào | Kết quả mong đợi | Loại test |
|-------|-------|-----------------|------------------|-----------|
| TC_SDT_01 | Để trống số điện thoại | (để trống) | Hiển thị lỗi: "Số điện thoại là bắt buộc." | Negative |
| TC_SDT_02 | Nhập số có 9 ký tự (dưới giới hạn) | 091234567 | Hiển thị lỗi: "Số điện thoại phải từ 10 đến 12 số." | Boundary |
| TC_SDT_03 | Nhập số có 10 ký tự (giới hạn dưới) | 0912345678 | Hợp lệ, không có lỗi | Boundary |
| TC_SDT_04 | Nhập số có 11 ký tự (trong giới hạn) | 09123456789 | Hợp lệ, không có lỗi | Positive |
| TC_SDT_05 | Nhập số có 12 ký tự (giới hạn trên) | 091234567890 | Hợp lệ, không có lỗi | Boundary |
| TC_SDT_06 | Nhập số có 13 ký tự (trên giới hạn) | 0912345678901 | Hiển thị lỗi: "Số điện thoại phải từ 10 đến 12 số." | Boundary |
| TC_SDT_07 | Nhập số không bắt đầu bằng 0 | 1234567890 | Hiển thị lỗi: "Số điện thoại phải bắt đầu bằng số 0." | Negative |
| TC_SDT_08 | Nhập số có chữ cái | 091234567a | Hiển thị lỗi: "Số điện thoại chỉ được chứa chữ số." | Negative |
| TC_SDT_09 | Nhập số có ký tự đặc biệt | 0912-345-678 | Hiển thị lỗi: "Số điện thoại chỉ được chứa chữ số." | Negative |
| TC_SDT_10 | Nhập số có khoảng trắng | 0912 345 678 | Hiển thị lỗi: "Số điện thoại chỉ được chứa chữ số." | Negative |

---

## 5. Test Cases cho trường Địa chỉ

| TC ID | Mô tả | Dữ liệu đầu vào | Kết quả mong đợi | Loại test |
|-------|-------|-----------------|------------------|-----------|
| TC_DC_01 | Để trống địa chỉ | (để trống) | Hiển thị lỗi: "Địa chỉ là bắt buộc." | Negative |
| TC_DC_02 | Nhập địa chỉ hợp lệ | 123 Nguyễn Văn Linh, Quận 7, TP.HCM | Hợp lệ, không có lỗi | Positive |
| TC_DC_03 | Nhập địa chỉ 255 ký tự (giới hạn trên) | [Chuỗi 255 ký tự] | Hợp lệ, không có lỗi | Boundary |
| TC_DC_04 | Nhập địa chỉ 256 ký tự (trên giới hạn) | [Chuỗi 256 ký tự] | Hiển thị lỗi: "Địa chỉ không được vượt quá 255 ký tự." | Boundary |
| TC_DC_05 | Nhập địa chỉ 1 ký tự | A | Hợp lệ, không có lỗi | Boundary |
| TC_DC_06 | Nhập địa chỉ có số và ký tự đặc biệt | 123/45 Đường ABC, Phường XYZ | Hợp lệ, không có lỗi | Positive |

---

## 6. Test Cases cho trường Mật khẩu

| TC ID | Mô tả | Dữ liệu đầu vào | Kết quả mong đợi | Loại test |
|-------|-------|-----------------|------------------|-----------|
| TC_MK_01 | Để trống mật khẩu | (để trống) | Hiển thị lỗi: "Mật khẩu là bắt buộc." | Negative |
| TC_MK_02 | Nhập mật khẩu 7 ký tự (dưới giới hạn) | Pass123 | Hiển thị lỗi: "Mật khẩu phải có ít nhất 8 ký tự." | Boundary |
| TC_MK_03 | Nhập mật khẩu 8 ký tự (giới hạn dưới) | Pass1234 | Hợp lệ, không có lỗi | Boundary |
| TC_MK_04 | Nhập mật khẩu 20 ký tự | Password123456789012 | Hợp lệ, không có lỗi | Positive |
| TC_MK_05 | Nhập mật khẩu có ký tự đặc biệt | P@ssw0rd! | Hợp lệ, không có lỗi | Positive |
| TC_MK_06 | Nhập mật khẩu chỉ có số | 12345678 | Hợp lệ, không có lỗi | Positive |
| TC_MK_07 | Nhập mật khẩu chỉ có chữ | abcdefgh | Hợp lệ, không có lỗi | Positive |
| TC_MK_08 | Nhập mật khẩu có khoảng trắng | Pass 1234 | Hợp lệ, không có lỗi | Positive |

---

## 7. Test Cases cho trường Xác nhận Mật khẩu

| TC ID | Mô tả | Mật khẩu | Xác nhận MK | Kết quả mong đợi | Loại test |
|-------|-------|----------|-------------|------------------|-----------|
| TC_XNMK_01 | Để trống xác nhận mật khẩu | Pass1234 | (để trống) | Hiển thị lỗi: "Xác nhận mật khẩu là bắt buộc." | Negative |
| TC_XNMK_02 | Xác nhận mật khẩu khớp | Pass1234 | Pass1234 | Hợp lệ, không có lỗi | Positive |
| TC_XNMK_03 | Xác nhận mật khẩu không khớp | Pass1234 | Pass12345 | Hiển thị lỗi: "Mật khẩu xác nhận không khớp." | Negative |
| TC_XNMK_04 | Xác nhận mật khẩu khác chữ hoa/thường | Pass1234 | pass1234 | Hiển thị lỗi: "Mật khẩu xác nhận không khớp." | Negative |
| TC_XNMK_05 | Xác nhận mật khẩu có thêm khoảng trắng | Pass1234 | Pass1234  | Hiển thị lỗi: "Mật khẩu xác nhận không khớp." | Negative |

---

## 8. Test Cases cho trường Ngày sinh

| TC ID | Mô tả | Dữ liệu đầu vào | Kết quả mong đợi | Loại test |
|-------|-------|-----------------|------------------|-----------|
| TC_NS_01 | Để trống ngày sinh | (để trống) | Hợp lệ (không bắt buộc) | Positive |
| TC_NS_02 | Nhập ngày sinh đủ 18 tuổi | 27/01/2008 | Hợp lệ, không có lỗi | Boundary |
| TC_NS_03 | Nhập ngày sinh dưới 18 tuổi | 28/01/2008 | Hiển thị lỗi: "Bạn phải đủ 18 tuổi để đăng ký." | Boundary |
| TC_NS_04 | Nhập ngày sinh 30 tuổi | 27/01/1996 | Hợp lệ, không có lỗi | Positive |
| TC_NS_05 | Nhập ngày sinh 17 tuổi | 27/01/2009 | Hiển thị lỗi: "Bạn phải đủ 18 tuổi để đăng ký." | Negative |
| TC_NS_06 | Nhập ngày sinh trong tương lai | 27/01/2030 | Hiển thị lỗi: "Bạn phải đủ 18 tuổi để đăng ký." | Negative |

---

## 9. Test Cases cho trường Giới tính

| TC ID | Mô tả | Dữ liệu đầu vào | Kết quả mong đợi | Loại test |
|-------|-------|-----------------|------------------|-----------|
| TC_GT_01 | Không chọn giới tính | (không chọn) | Hợp lệ (không bắt buộc) | Positive |
| TC_GT_02 | Chọn giới tính Nam | Nam | Hợp lệ, không có lỗi | Positive |
| TC_GT_03 | Chọn giới tính Nữ | Nữ | Hợp lệ, không có lỗi | Positive |
| TC_GT_04 | Chọn giới tính Khác | Khác | Hợp lệ, không có lỗi | Positive |

---

## 10. Test Cases cho trường Điều khoản dịch vụ

| TC ID | Mô tả | Dữ liệu đầu vào | Kết quả mong đợi | Loại test |
|-------|-------|-----------------|------------------|-----------|
| TC_DK_01 | Không tích chọn điều khoản | (không tích) | Hiển thị lỗi: "Bạn phải đồng ý với điều khoản dịch vụ." | Negative |
| TC_DK_02 | Tích chọn điều khoản | (đã tích) | Hợp lệ, không có lỗi | Positive |
| TC_DK_03 | Tích rồi bỏ tích điều khoản | (bỏ tích) | Hiển thị lỗi: "Bạn phải đồng ý với điều khoản dịch vụ." | Negative |

---

## 11. Test Cases cho nút Đăng ký

| TC ID | Mô tả | Điều kiện | Kết quả mong đợi | Loại test |
|-------|-------|-----------|------------------|-----------|
| TC_DKY_01 | Đăng ký với tất cả dữ liệu hợp lệ | Tất cả trường hợp lệ | Hiển thị thông báo "Đăng ký tài khoản thành công!" | Positive |
| TC_DKY_02 | Đăng ký với một trường không hợp lệ | Mã KH để trống | Form không submit, hiển thị lỗi tương ứng | Negative |
| TC_DKY_03 | Đăng ký với nhiều trường không hợp lệ | MKH, Email, SDT để trống | Form không submit, hiển thị tất cả lỗi | Negative |
| TC_DKY_04 | Đăng ký không tích điều khoản | Điều khoản chưa tích | Form không submit, hiển thị lỗi điều khoản | Negative |

---

## 12. Test Cases cho nút Nhập lại

| TC ID | Mô tả | Điều kiện | Kết quả mong đợi | Loại test |
|-------|-------|-----------|------------------|-----------|
| TC_NL_01 | Nhấn Nhập lại khi form trống | Form trống | Form vẫn trống | Positive |
| TC_NL_02 | Nhấn Nhập lại khi đã nhập dữ liệu | Form có dữ liệu | Xóa toàn bộ dữ liệu, form trở về trạng thái mặc định | Positive |
| TC_NL_03 | Nhấn Nhập lại khi có lỗi hiển thị | Form có lỗi | Xóa dữ liệu và xóa tất cả thông báo lỗi | Positive |
| TC_NL_04 | Nhấn Nhập lại khi checkbox đã tích | Điều khoản đã tích | Bỏ tích checkbox | Positive |
| TC_NL_05 | Nhấn Nhập lại khi radio đã chọn | Giới tính đã chọn | Bỏ chọn radio | Positive |

---

## 13. Test Cases tích hợp (Integration Tests)

| TC ID | Mô tả | Dữ liệu đầu vào | Kết quả mong đợi | Loại test |
|-------|-------|-----------------|------------------|-----------|
| TC_INT_01 | Đăng ký thành công với tất cả trường bắt buộc | MKH: ABC12345, Tên: Nguyễn Văn A, Email: test123@gmail.com, SDT: 0901234567, Địa chỉ: 123 ABC, MK: Password123, XNMK: Password123, Điều khoản: Đã tích | Đăng ký thành công | Positive |
| TC_INT_02 | Đăng ký thành công với tất cả trường (bao gồm không bắt buộc) | Như TC_INT_01 + Ngày sinh: 01/01/2000, Giới tính: Nam | Đăng ký thành công | Positive |
| TC_INT_03 | Đăng ký với email đã tồn tại | Email: admin@email.com, các trường khác hợp lệ | Hiển thị lỗi email đã tồn tại | Negative |
| TC_INT_04 | Đăng ký với mã KH đã tồn tại | MKH: KH001234, các trường khác hợp lệ | Hiển thị lỗi mã KH đã tồn tại | Negative |
| TC_INT_05 | Thay đổi mật khẩu sau khi nhập xác nhận | Nhập XNMK trước, sau đó thay đổi MK | Hiển thị lỗi mật khẩu không khớp | Negative |

---

## Tổng hợp

| Loại | Số lượng |
|------|----------|
| Positive Tests | 35 |
| Negative Tests | 32 |
| Boundary Tests | 16 |
| **Tổng cộng** | **83** |

---

*Lưu ý: Các test case trên được thiết kế dựa trên kỹ thuật phân tích giá trị biên (Boundary Value Analysis) và phân vùng tương đương (Equivalence Partitioning).*
