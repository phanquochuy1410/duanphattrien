package com.example.demo.controller;

import com.example.demo.entity.LoaiAo;
import com.example.demo.repository.LoaiAoRepository;
import com.example.demo.service.LoaiAoService;
import com.example.demo.service.impl.LoaiAoServiceImpl;
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
public class LoaiAoController {

    @Autowired
    private LoaiAoService service = new LoaiAoServiceImpl();

    @Autowired
    private LoaiAoRepository loaiAoRepository;

    @GetMapping("/loai-ao/hien-thi")
    public String hienThi(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("loaiAo", new LoaiAo());
        int soTrang = 3;
        Page<LoaiAo> phanTrang = loaiAoRepository.findAll(PageRequest.of(page, soTrang));
        int cuoiTrang = phanTrang.getTotalPages();

        model.addAttribute("listLoaiAo", phanTrang.getContent());
        model.addAttribute("soTrang", page);
        model.addAttribute("cuoiTrang", cuoiTrang);
        model.addAttribute("view", "loai-ao/loai-ao.jsp");

        return "layout";
    }

    @PostMapping("/loai-ao/add")
    public String addAo(@Valid @ModelAttribute("loaiAo") LoaiAo loaiAo, BindingResult result, Model model, @RequestParam(defaultValue = "0") int page) {
        if (result.hasErrors()) {
            int soTrang = 3;
            Page<LoaiAo> phanTrang = loaiAoRepository.findAll(PageRequest.of(page, soTrang));
            int cuoiTrang = phanTrang.getTotalPages();

            model.addAttribute("listLoaiAo", phanTrang.getContent());
            model.addAttribute("soTrang", page);
            model.addAttribute("cuoiTrang", cuoiTrang);
            model.addAttribute("view", "loai-ao/loai-ao.jsp");

            return "layout";
        }
        if (!service.checkMa(loaiAo.getMa())) {
            int soTrang = 3;
            Page<LoaiAo> phanTrang = loaiAoRepository.findAll(PageRequest.of(page, soTrang));
            int cuoiTrang = phanTrang.getTotalPages();

            model.addAttribute("listLoaiAo", phanTrang.getContent());
            model.addAttribute("soTrang", page);
            model.addAttribute("cuoiTrang", cuoiTrang);
            model.addAttribute("suss", "Mã đã tồn tại !");
            model.addAttribute("view", "loai-ao/loai-ao.jsp");

            return "layout";
        }
        service.addLoaiAo(loaiAo);
        return "redirect:/loai-ao/hien-thi";
    }

    @GetMapping("/loai-ao/view-update/{idLoaiAo}")
    public String viewUpdate(Model model, @PathVariable("idLoaiAo") UUID id) {
        model.addAttribute("loaiAo", new LoaiAo());
        model.addAttribute("loaiAo", service.getOne(id));
        model.addAttribute("view", "loai-ao/update-loai-ao.jsp");
        return "layout";
    }

    @PostMapping("/loai-ao/update")
    public String updateAo(@Valid @ModelAttribute("loaiAo") LoaiAo loaiAo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listLoaiAo", service.getAll());
            return "loai-ao/update-loai-ao";
        }
        service.updateLoaiAo(loaiAo, loaiAo.getId());
        return "redirect:/loai-ao/hien-thi";
    }
}
