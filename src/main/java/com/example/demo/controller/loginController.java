package com.example.demo.controller;

import com.example.demo.entity.NhanVien;
import com.example.demo.repository.NhanVienRepository;
import com.example.demo.service.Login;
import com.example.demo.service.NhanVienService;
import com.example.demo.service.impl.LoginImpl;
import com.example.demo.service.impl.NhanVienServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;


@Controller
public class loginController {

    @Autowired
    private NhanVienRepository repository;

    @Autowired
    private NhanVienService nhanVienService = new NhanVienServiceImpl();

    @Autowired
    private Login loginService = new LoginImpl();

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/trang-chu")
    public String layout(Model model , @RequestParam("email") String email , @RequestParam("matKhau") int matKhau){
        NhanVien nhanVien = loginService.login(email , matKhau );
        if (nhanVien != null){
            model.addAttribute("suss","Đăng nhập thành công !");
            return "layout";
        }else{
            model.addAttribute("err","Email hoặc mật khẩu không chính xác !");
        }
        return "login";
    }
}
