package com.example.demo.controller;

import com.example.demo.dto.KhachHangDTO;
import com.example.demo.service.KhachHangService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class KhachHangController {
    
    @Autowired
    private KhachHangService khachHangService;
    
    @GetMapping("/")
    public String home() {
        return "redirect:/dangky";
    }
    
    @GetMapping("/dangky")
    public String showDangKyForm(Model model) {
        model.addAttribute("khachHangDTO", new KhachHangDTO());
        return "dangky";
    }
    
    @PostMapping("/dangky")
    public String dangKy(@Valid @ModelAttribute("khachHangDTO") KhachHangDTO khachHangDTO,
                         BindingResult bindingResult,
                         Model model,
                         RedirectAttributes redirectAttributes) {
        
        // Kiểm tra validation từ annotation
        if (bindingResult.hasErrors()) {
            return "dangky";
        }
        
        // Kiểm tra validation từ service (trùng lặp, mật khẩu, tuổi, điều khoản)
        List<String> errors = khachHangService.validateDangKy(khachHangDTO);
        
        if (!errors.isEmpty()) {
            model.addAttribute("customErrors", errors);
            return "dangky";
        }
        
        // Lưu khách hàng
        try {
            khachHangService.dangKy(khachHangDTO);
            redirectAttributes.addFlashAttribute("successMessage", "Đăng ký tài khoản thành công!");
            return "redirect:/dangky";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Đã xảy ra lỗi khi đăng ký: " + e.getMessage());
            return "dangky";
        }
    }
}
