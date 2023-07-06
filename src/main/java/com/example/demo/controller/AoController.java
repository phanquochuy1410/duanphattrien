package com.example.demo.controller;

import com.example.demo.entity.Ao;
import com.example.demo.entity.ChatLieu;
import com.example.demo.repository.AoRepository;
import com.example.demo.service.AoService;
import com.example.demo.service.impl.AoServiceImpl;
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
public class AoController {

    @Autowired
    private AoService service = new AoServiceImpl();

    @Autowired
    private AoRepository aoRepository;

    @GetMapping("/ao/hien-thi")
    public String hienThi(Model model , @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("ao", new Ao());
        int soTrang = 3;
        Page<Ao> phanTrang = aoRepository.findAll(PageRequest.of(page , soTrang));
        int cuoiTrang = phanTrang.getTotalPages();

        model.addAttribute("listAo" , phanTrang.getContent());
        model.addAttribute("soTrang" , page);
        model.addAttribute("cuoiTrang" , cuoiTrang);
        model.addAttribute("view","ao/ao.jsp");
        return "layout";
    }

    @PostMapping("/ao/add")
    public String addAo(@Valid @ModelAttribute("ao") Ao aoo, BindingResult result , Model model , @RequestParam(defaultValue = "0") int page) {
        if (result.hasErrors()) {
            int soTrang = 3;
            Page<Ao> phanTrang = aoRepository.findAll(PageRequest.of(page , soTrang));
            int cuoiTrang = phanTrang.getTotalPages();

            model.addAttribute("listAo" , phanTrang.getContent());
            model.addAttribute("soTrang" , page);
            model.addAttribute("cuoiTrang" , cuoiTrang);
            model.addAttribute("view","ao/ao.jsp");
            return "layout";
        }
        if (!service.checkMa(aoo.getMa())) {
            int soTrang = 3;
            Page<Ao> phanTrang = aoRepository.findAll(PageRequest.of(page , soTrang));
            int cuoiTrang = phanTrang.getTotalPages();

            model.addAttribute("listAo" , phanTrang.getContent());
            model.addAttribute("soTrang" , page);
            model.addAttribute("cuoiTrang" , cuoiTrang);
            model.addAttribute("suss", "Mã đã tồn tại");
            model.addAttribute("view","ao/ao.jsp");
            return "layout";
        }
        service.addAo(aoo);
        model.addAttribute("successMessage" ,"Thêm thành công ! ");
        model.addAttribute("view","ao/ao.jsp");
        return "redirect:/ao/hien-thi";
    }

    @GetMapping("/ao/view-update/{idAo}")
    public String viewUpdate(Model model, @PathVariable("idAo") UUID id) {
        model.addAttribute("ao", new Ao());
        model.addAttribute("ao", service.getOne(id));
        model.addAttribute("view","ao/update-ao.jsp");
        return "layout";
    }

    @PostMapping("/ao/update")
    public String updateAo(@Valid @ModelAttribute("ao") Ao ao, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listAo", service.getAll());
            model.addAttribute("view","ao/update-ao.jsp");
            return "layout";
        }
        service.updateAo(ao, ao.getId());
        model.addAttribute("successMessage" ,"Sửa thành công ! ");
        model.addAttribute("view","ao/ao.jsp");
        return "redirect:/ao/hien-thi";
    }
}
