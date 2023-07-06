package com.example.demo.controller;

import com.example.demo.entity.NhanVien;
import com.example.demo.repository.NhanVienRepository;
import com.example.demo.service.NhanVienService;
import com.example.demo.service.impl.NhanVienServiceImpl;
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
public class NhanVienController {
    @Autowired
    private NhanVienService service = new NhanVienServiceImpl();

    @Autowired
    private NhanVienRepository repository;

    @GetMapping("/nhan-vien/hien-thi")
    public String hienThi(Model model , @RequestParam(defaultValue = "0") int page){
        model.addAttribute("nhanVien" , new NhanVien());
        return phanTrang(page , model);
    }

    @PostMapping("/nhan-vien/add")
    public String addNhanVien(@Valid @ModelAttribute("nhanVien") NhanVien nhanVien , BindingResult result , Model model
            , @RequestParam(defaultValue = "0") int page){
        if (result.hasErrors()){
            return phanTrang(page , model);
        }
        if (!service.checkMa(nhanVien.getMa())){
            model.addAttribute("suss","Mã nhân viên đã tồn tại !");
            return phanTrang(page , model);
        }
        if (!service.checkEmail(nhanVien.getEmail())){
            model.addAttribute("sus","Email nhân viên đã tồn tại !");
            return phanTrang(page , model);
        }
        if (service.checkNgaySinh(nhanVien.getNgaySinh())){
            model.addAttribute("suse","Ngày sinh phải nhỏ hơn ngày hiên tại !");
            return phanTrang(page , model);
        }
        service.addNhanVien(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

    String phanTrang(@RequestParam(defaultValue = "0") int page , Model model){
        int soTrang = 3;
        Page<NhanVien> phanTrang = repository.findAll(PageRequest.of(page , soTrang));
        int cuoiTrang = phanTrang.getTotalPages();

        model.addAttribute("listNhanVien" , phanTrang.getContent());
        model.addAttribute("soTrang" , page);
        model.addAttribute("cuoiTrang" , cuoiTrang);
        model.addAttribute("view","nhan-vien/nhan-vienn.jsp");
        return "layout";
    }

    @GetMapping("/nhan-vien/view-update/{idNhanVien}")
    public String viewUpdate(Model model , @PathVariable("idNhanVien") UUID id){
        model.addAttribute("nhanVien" , new NhanVien());
        model.addAttribute("nhanVien" , service.getOne(id));
        model.addAttribute("view","nhan-vien/update-nhan-vien.jsp");
        return "layout";
    }

    @PostMapping("/nhan-vien/update")
    public String updateNhanVien(@Valid @ModelAttribute("nhanVien") NhanVien nhanVien , BindingResult result , Model model
            , @RequestParam(defaultValue = "0") int page){
        if (result.hasErrors()){
            return "nhan-vien/update-nhan-vien";
        }
        service.updateNhanVien(nhanVien , nhanVien.getId());
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("/nhan-vien/search")
    public String search(Model model ,@RequestParam("tenSearch") String ten){
        model.addAttribute("nhanVien", new NhanVien());
        model.addAttribute("listNhanVien" , service.search(ten));
        model.addAttribute("view" , "nhan-vien/nhan-vienn.jsp");
        return "layout";
    }
}
