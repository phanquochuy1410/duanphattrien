package com.example.demo.controller;

import com.example.demo.entity.MauSac;
import com.example.demo.repository.MauSacRepository;
import com.example.demo.service.MauSacService;
import com.example.demo.service.impl.MauSacServiceImpl;
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
public class MauSacController {
    @Autowired
    private MauSacService service = new MauSacServiceImpl();

    @Autowired
    private MauSacRepository mauSacRepository;

    @GetMapping("/mau-sac/hien-thi")
    public String hienThi(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("mauSac", new MauSac());
        int soTrang = 3;
        Page<MauSac> phanTrang = mauSacRepository.findAll(PageRequest.of(page, soTrang));
        int cuoiTrang = phanTrang.getTotalPages();

        model.addAttribute("listMauSac", phanTrang.getContent());
        model.addAttribute("soTrang", page);
        model.addAttribute("cuoiTrang", cuoiTrang);
        model.addAttribute("view", "mau-sac/mau-sac.jsp");
        return "layout";
    }

    @PostMapping("/mau-sac/add")
    public String addAo(@Valid @ModelAttribute("mauSac") MauSac mauSac, BindingResult result, Model model, @RequestParam(defaultValue = "0") int page) {
        if (result.hasErrors()) {
            int soTrang = 3;
            Page<MauSac> phanTrang = mauSacRepository.findAll(PageRequest.of(page, soTrang));
            int cuoiTrang = phanTrang.getTotalPages();

            model.addAttribute("listMauSac", phanTrang.getContent());
            model.addAttribute("soTrang", page);
            model.addAttribute("cuoiTrang", cuoiTrang);
            model.addAttribute("suss", "Mã đã tồn tại !");
            model.addAttribute("view", "mau-sac/mau-sac.jsp");
            return "layout";
        }
        if (!service.checkMa(mauSac.getMa())) {
            int soTrang = 3;
            Page<MauSac> phanTrang = mauSacRepository.findAll(PageRequest.of(page, soTrang));
            int cuoiTrang = phanTrang.getTotalPages();

            model.addAttribute("listMauSac", phanTrang.getContent());
            model.addAttribute("soTrang", page);
            model.addAttribute("cuoiTrang", cuoiTrang);
            model.addAttribute("suss", "Mã đã tồn tại !");
            model.addAttribute("view", "mau-sac/mau-sac.jsp");
            return "layout";
        }
        service.addMauSac(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("/mau-sac/view-update/{idMauSac}")
    public String viewUpdate(Model model, @PathVariable("idMauSac") UUID id) {
        model.addAttribute("mauSac", new MauSac());
        model.addAttribute("mauSac", service.getOne(id));
        model.addAttribute("view", "mau-sac/update-mau-sac.jsp");
        return "layout";
    }

    @PostMapping("/mau-sac/update")
    public String updateAo(@Valid @ModelAttribute("mauSac") MauSac mauSac, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listMauSac", service.getAll());
            return "mau-sac/update-mau-sac";
        }
        service.updateMauSac(mauSac, mauSac.getId());
        return "redirect:/mau-sac/hien-thi";
    }

}
