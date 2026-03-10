// Danh sách mã khách hàng và email đã tồn tại (giả lập database)
const existingCustomerIds = ['KH001234', 'KH567890', 'ABC12345'];
const existingEmails = ['admin@email.com', 'test@email.com', 'user@gmail.com'];

// Lấy các phần tử DOM
const form = document.getElementById('registrationForm');
const btnNhapLai = document.getElementById('btnNhapLai');

// Các trường input
const fields = {
    maKhachHang: document.getElementById('maKhachHang'),
    hoVaTen: document.getElementById('hoVaTen'),
    email: document.getElementById('email'),
    soDienThoai: document.getElementById('soDienThoai'),
    diaChi: document.getElementById('diaChi'),
    matKhau: document.getElementById('matKhau'),
    xacNhanMatKhau: document.getElementById('xacNhanMatKhau'),
    ngaySinh: document.getElementById('ngaySinh'),
    dieuKhoan: document.getElementById('dieuKhoan')
};

// Các phần tử hiển thị lỗi
const errorElements = {
    maKhachHang: document.getElementById('maKhachHangError'),
    hoVaTen: document.getElementById('hoVaTenError'),
    email: document.getElementById('emailError'),
    soDienThoai: document.getElementById('soDienThoaiError'),
    diaChi: document.getElementById('diaChiError'),
    matKhau: document.getElementById('matKhauError'),
    xacNhanMatKhau: document.getElementById('xacNhanMatKhauError'),
    ngaySinh: document.getElementById('ngaySinhError'),
    dieuKhoan: document.getElementById('dieuKhoanError')
};

// ===== CÁC HÀM VALIDATION =====

// 1. Validate Mã Khách Hàng
function validateMaKhachHang() {
    const value = fields.maKhachHang.value.trim();
    const alphanumericRegex = /^[a-zA-Z0-9]+$/;
    
    if (!value) {
        return showError('maKhachHang', 'Mã khách hàng là bắt buộc.');
    }
    if (value.length < 6 || value.length > 10) {
        return showError('maKhachHang', 'Mã khách hàng phải từ 6 đến 10 ký tự.');
    }
    if (!alphanumericRegex.test(value)) {
        return showError('maKhachHang', 'Mã khách hàng chỉ được chứa chữ cái và số.');
    }
    if (existingCustomerIds.includes(value)) {
        return showError('maKhachHang', 'Mã khách hàng đã tồn tại.');
    }
    
    return showSuccess('maKhachHang');
}

// 2. Validate Họ và Tên
function validateHoVaTen() {
    const value = fields.hoVaTen.value.trim();
    // Cho phép chữ cái tiếng Việt, khoảng trắng
    const vietnameseNameRegex = /^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\s]+$/;
    
    if (!value) {
        return showError('hoVaTen', 'Họ và tên là bắt buộc.');
    }
    if (value.length < 5 || value.length > 50) {
        return showError('hoVaTen', 'Họ và tên phải từ 5 đến 50 ký tự.');
    }
    if (!vietnameseNameRegex.test(value)) {
        return showError('hoVaTen', 'Họ và tên chỉ được chứa chữ cái và khoảng trắng.');
    }
    
    return showSuccess('hoVaTen');
}

// 3. Validate Email
function validateEmail() {
    const value = fields.email.value.trim();
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    
    if (!value) {
        return showError('email', 'Email là bắt buộc.');
    }
    if (!emailRegex.test(value)) {
        return showError('email', 'Email không đúng định dạng.');
    }
    if (existingEmails.includes(value.toLowerCase())) {
        return showError('email', 'Email đã được sử dụng.');
    }
    
    return showSuccess('email');
}

// 4. Validate Số điện thoại
function validateSoDienThoai() {
    const value = fields.soDienThoai.value.trim();
    const phoneRegex = /^0[0-9]{9,11}$/;
    
    if (!value) {
        return showError('soDienThoai', 'Số điện thoại là bắt buộc.');
    }
    if (!/^[0-9]+$/.test(value)) {
        return showError('soDienThoai', 'Số điện thoại chỉ được chứa chữ số.');
    }
    if (value.length < 10 || value.length > 12) {
        return showError('soDienThoai', 'Số điện thoại phải từ 10 đến 12 số.');
    }
    if (!value.startsWith('0')) {
        return showError('soDienThoai', 'Số điện thoại phải bắt đầu bằng số 0.');
    }
    
    return showSuccess('soDienThoai');
}

// 5. Validate Địa chỉ
function validateDiaChi() {
    const value = fields.diaChi.value.trim();
    
    if (!value) {
        return showError('diaChi', 'Địa chỉ là bắt buộc.');
    }
    if (value.length > 255) {
        return showError('diaChi', 'Địa chỉ không được vượt quá 255 ký tự.');
    }
    
    return showSuccess('diaChi');
}

// 6. Validate Mật khẩu
function validateMatKhau() {
    const value = fields.matKhau.value;
    
    if (!value) {
        return showError('matKhau', 'Mật khẩu là bắt buộc.');
    }
    if (value.length < 8) {
        return showError('matKhau', 'Mật khẩu phải có ít nhất 8 ký tự.');
    }
    
    return showSuccess('matKhau');
}

// 7. Validate Xác nhận Mật khẩu
function validateXacNhanMatKhau() {
    const value = fields.xacNhanMatKhau.value;
    const matKhau = fields.matKhau.value;
    
    if (!value) {
        return showError('xacNhanMatKhau', 'Xác nhận mật khẩu là bắt buộc.');
    }
    if (value !== matKhau) {
        return showError('xacNhanMatKhau', 'Mật khẩu xác nhận không khớp.');
    }
    
    return showSuccess('xacNhanMatKhau');
}

// 8. Validate Ngày sinh (không bắt buộc, nhưng nếu nhập phải đủ 18 tuổi)
function validateNgaySinh() {
    const value = fields.ngaySinh.value;
    
    if (!value) {
        // Không bắt buộc, nên không có lỗi
        clearError('ngaySinh');
        return true;
    }
    
    const birthDate = new Date(value);
    const today = new Date();
    
    // Tính tuổi
    let age = today.getFullYear() - birthDate.getFullYear();
    const monthDiff = today.getMonth() - birthDate.getMonth();
    
    if (monthDiff < 0 || (monthDiff === 0 && today.getDate() < birthDate.getDate())) {
        age--;
    }
    
    if (age < 18) {
        return showError('ngaySinh', 'Bạn phải đủ 18 tuổi để đăng ký.');
    }
    
    return showSuccess('ngaySinh');
}

// 10. Validate Điều khoản dịch vụ
function validateDieuKhoan() {
    if (!fields.dieuKhoan.checked) {
        return showError('dieuKhoan', 'Bạn phải đồng ý với điều khoản dịch vụ.');
    }
    
    clearError('dieuKhoan');
    return true;
}

// ===== CÁC HÀM HỖ TRỢ =====

function showError(fieldName, message) {
    errorElements[fieldName].textContent = message;
    if (fields[fieldName].type !== 'checkbox') {
        fields[fieldName].classList.add('error');
        fields[fieldName].classList.remove('success');
    }
    return false;
}

function showSuccess(fieldName) {
    errorElements[fieldName].textContent = '';
    if (fields[fieldName].type !== 'checkbox' && fields[fieldName].type !== 'date') {
        fields[fieldName].classList.add('success');
        fields[fieldName].classList.remove('error');
    } else {
        fields[fieldName].classList.remove('error');
    }
    return true;
}

function clearError(fieldName) {
    errorElements[fieldName].textContent = '';
    fields[fieldName].classList.remove('error', 'success');
}

// Validate toàn bộ form
function validateForm() {
    const results = [
        validateMaKhachHang(),
        validateHoVaTen(),
        validateEmail(),
        validateSoDienThoai(),
        validateDiaChi(),
        validateMatKhau(),
        validateXacNhanMatKhau(),
        validateNgaySinh(),
        validateDieuKhoan()
    ];
    
    return results.every(result => result === true);
}

// Reset form
function resetForm() {
    form.reset();
    
    // Xóa tất cả thông báo lỗi và class
    Object.keys(errorElements).forEach(key => {
        errorElements[key].textContent = '';
    });
    
    Object.keys(fields).forEach(key => {
        if (fields[key].type !== 'checkbox' && fields[key].type !== 'radio') {
            fields[key].classList.remove('error', 'success');
        }
    });
}

// ===== EVENT LISTENERS =====

// Sự kiện submit form
form.addEventListener('submit', function(e) {
    e.preventDefault();
    
    if (validateForm()) {
        alert('Đăng ký tài khoản thành công!');
        resetForm();
    }
});

// Sự kiện nút Nhập lại
btnNhapLai.addEventListener('click', resetForm);

// Validate realtime khi người dùng nhập
fields.maKhachHang.addEventListener('blur', validateMaKhachHang);
fields.hoVaTen.addEventListener('blur', validateHoVaTen);
fields.email.addEventListener('blur', validateEmail);
fields.soDienThoai.addEventListener('blur', validateSoDienThoai);
fields.diaChi.addEventListener('blur', validateDiaChi);
fields.matKhau.addEventListener('blur', validateMatKhau);
fields.xacNhanMatKhau.addEventListener('blur', validateXacNhanMatKhau);
fields.ngaySinh.addEventListener('blur', validateNgaySinh);
fields.dieuKhoan.addEventListener('change', validateDieuKhoan);

// Validate mật khẩu xác nhận khi mật khẩu thay đổi
fields.matKhau.addEventListener('input', function() {
    if (fields.xacNhanMatKhau.value) {
        validateXacNhanMatKhau();
    }
});
