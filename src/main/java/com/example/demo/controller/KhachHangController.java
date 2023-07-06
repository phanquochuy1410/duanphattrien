package com.example.demo.controller;

import com.example.demo.entity.KhachHang;
import com.example.demo.repository.KhachHangRepository;
import com.example.demo.service.KhachHangService;
import com.example.demo.service.impl.KhachHangServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class KhachHangController {

    @Autowired
    private KhachHangService service = new KhachHangServiceImpl();

    @Autowired
    private KhachHangRepository repository;

    @GetMapping("/khach-hang/hien-thi")
    public String hienThi(Model model , @RequestParam(defaultValue = "0") int page){
        model.addAttribute("khachHang" , new KhachHang());
        int soTrang = 3;
        Page<KhachHang> phanTrang = repository.findAll(PageRequest.of(page , soTrang));
        int cuoiTrang = phanTrang.getTotalPages();

        model.addAttribute("listKhachHang" , phanTrang.getContent());
        model.addAttribute("soTrang" , page);
        model.addAttribute("cuoiTrang" , cuoiTrang);
        model.addAttribute("view","khach-hang/khach-hang.jsp");
        return "layout";
    }

    @PostMapping("/khach-hang/add")
    public String addNhanVien(@Valid @ModelAttribute("khachHang") KhachHang khachHang , BindingResult result , Model model
            , @RequestParam(defaultValue = "0") int page){
        if (result.hasErrors()){
            int soTrang = 3;
            Page<KhachHang> phanTrang = repository.findAll(PageRequest.of(page , soTrang));
            int cuoiTrang = phanTrang.getTotalPages();

            model.addAttribute("listKhachHang" , phanTrang.getContent());
            model.addAttribute("soTrang" , page);
            model.addAttribute("cuoiTrang" , cuoiTrang);
            model.addAttribute("view","khach-hang/khach-hang.jsp");
            return "layout";
        }
        if (!service.checkMa(khachHang.getMa())) {
            int soTrang = 3;
            Page<KhachHang> phanTrang = repository.findAll(PageRequest.of(page , soTrang));
            int cuoiTrang = phanTrang.getTotalPages();

            model.addAttribute("listKhachHang" , phanTrang.getContent());
            model.addAttribute("soTrang" , page);
            model.addAttribute("cuoiTrang" , cuoiTrang);
            model.addAttribute("suss", "Mã đã tồn tại !");
            model.addAttribute("view","khach-hang/khach-hang.jsp");
            return "layout";
        }
        service.addKhachHang(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("/khach-hang/view-update/{idNhanVien}")
    public String viewUpdate(Model model , @PathVariable("idNhanVien") UUID id){
        model.addAttribute("khachHang" , new KhachHang());
        model.addAttribute("khachHang" , service.getOne(id));
        model.addAttribute("view","khach-hang/update-khach-hang.jsp");
        return "layout";
    }

    @PostMapping("/khach-hang/update")
    public String updateNhanVien(@Valid @ModelAttribute("khachHang") KhachHang khachHang , BindingResult result , Model model
            , @RequestParam(defaultValue = "0") int page){
        if (result.hasErrors()){
            int soTrang = 3;
            Page<KhachHang> phanTrang = repository.findAll(PageRequest.of(page , soTrang));
            int cuoiTrang = phanTrang.getTotalPages();

            model.addAttribute("listKhachHang" , phanTrang.getContent());
            model.addAttribute("soTrang" , page);
            model.addAttribute("cuoiTrang" , cuoiTrang);
            return "khach-hang/update-khach-hang";
        }
        service.updateKhachHang(khachHang , khachHang.getId());
        return "redirect:/khach-hang/hien-thi";
    }
}
