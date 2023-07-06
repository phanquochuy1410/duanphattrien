package com.example.demo.controller;

import com.example.demo.entity.ChiTietAo;
import com.example.demo.repository.ChiTietAoRepository;
import com.example.demo.service.AoService;
import com.example.demo.service.ChatLieuService;
import com.example.demo.service.ChiTietAoService;
import com.example.demo.service.LoaiAoService;
import com.example.demo.service.MauSacService;
import com.example.demo.service.SizeService;
import com.example.demo.service.impl.AoServiceImpl;
import com.example.demo.service.impl.ChatLieuServiceImpl;
import com.example.demo.service.impl.ChiTietAoServiceImpl;
import com.example.demo.service.impl.LoaiAoServiceImpl;
import com.example.demo.service.impl.MauSacServiceImpl;
import com.example.demo.service.impl.SizeServiceImpl;
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
public class ChiTietAoController {

    @Autowired
    private ChiTietAoService chiTietAoService = new ChiTietAoServiceImpl();

    @Autowired
    private AoService aoService = new AoServiceImpl();

    @Autowired
    private MauSacService mauSacService = new MauSacServiceImpl();

    @Autowired
    private SizeService sizeService = new SizeServiceImpl();

    @Autowired
    private LoaiAoService loaiAoService = new LoaiAoServiceImpl();

    @Autowired
    private ChatLieuService chatLieuService = new ChatLieuServiceImpl();

    @Autowired
    private ChiTietAoRepository repository;

    public String phanTrang(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("chiTietAo", new ChiTietAo());
        model.addAttribute("ao", aoService.getAll());
        model.addAttribute("mauSac", mauSacService.getAll());
        model.addAttribute("sizes", sizeService.getAll());
        model.addAttribute("loaiAo", loaiAoService.getAll());
        model.addAttribute("chatLieu", chatLieuService.getAll());

        int soTrang = 5;
        Page<ChiTietAo> phanTrang = repository.findAll(PageRequest.of(page, soTrang));
        int cuoiTrang = phanTrang.getTotalPages();

        model.addAttribute("listChiTietAo", phanTrang.getContent());
        model.addAttribute("soTrang", page);
        model.addAttribute("cuoiTrang", cuoiTrang);
        model.addAttribute("view", "chi-tiet-ao/chi-tiet-ao.jsp");
        return "layout";
    }

    @GetMapping("/chi-tiet-ao/hien-thi")
    public String hienThi(Model model, @RequestParam(defaultValue = "0") int page) {
        return phanTrang(model, page);
    }

    @PostMapping("/chi-tiet-ao/add")
    public String addChiTiet(@Valid @ModelAttribute("chiTietAo") ChiTietAo chiTietAo, BindingResult result, Model model
            , @RequestParam(defaultValue = "0") int page) {
        if (result.hasErrors()) {
            return phanTrang(model, page);
        }
        chiTietAoService.addChiTiet(chiTietAo);
        return "redirect:/chi-tiet-ao/hien-thi";
    }

    @GetMapping("/chi-tiet-ao/view-update/{idChiTiet}")
    public String viewUpdate(Model model, @PathVariable("idChiTiet") UUID id) {

        model.addAttribute("chiTietAo", new ChiTietAo());
        model.addAttribute("ao", aoService.getAll());
        model.addAttribute("mauSac", mauSacService.getAll());
        model.addAttribute("sizes", sizeService.getAll());
        model.addAttribute("loaiAo", loaiAoService.getAll());
        model.addAttribute("chatLieu", chatLieuService.getAll());

        model.addAttribute("chiTietAo", chiTietAoService.getOne(id));
        model.addAttribute("view", "chi-tiet-ao/update-chi-tiet-ao.jsp");
        return "layout";
    }

    @PostMapping("/chi-tiet-ao/update")
    public String updateChiTiet(@Valid @ModelAttribute("chiTietAo") ChiTietAo chiTietAo, BindingResult result, Model model
            , @RequestParam(defaultValue = "0") int page) {
        if (result.hasErrors()) {

            model.addAttribute("ao", aoService.getAll());
            model.addAttribute("mauSac", mauSacService.getAll());
            model.addAttribute("sizes", sizeService.getAll());
            model.addAttribute("loaiAo", loaiAoService.getAll());
            model.addAttribute("chatLieu", chatLieuService.getAll());

            int soTrang = 5;
            Page<ChiTietAo> phanTrang = repository.findAll(PageRequest.of(page, soTrang));
            int cuoiTrang = phanTrang.getTotalPages();

            model.addAttribute("listChiTietAo", phanTrang.getContent());
            model.addAttribute("soTrang", page);
            model.addAttribute("cuoiTrang", cuoiTrang);
            return "chi-tiet-ao/update-chi-tiet-ao";
        }
        chiTietAoService.updateChiTiet(chiTietAo, chiTietAo.getId());
        return "redirect:/chi-tiet-ao/hien-thi";
    }

}
