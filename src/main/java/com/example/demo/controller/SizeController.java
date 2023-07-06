package com.example.demo.controller;


import com.example.demo.entity.Size;
import com.example.demo.repository.SizeRepository;
import com.example.demo.service.SizeService;
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
public class SizeController {

    @Autowired
    private SizeService service = new SizeServiceImpl();

    @Autowired
    private SizeRepository sizeRepository;

    @GetMapping("/size/hien-thi")
    public String hienThi(Model model , @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("size", new Size());
        int soTrang = 3;
        Page<Size> phanTrang = sizeRepository.findAll(PageRequest.of(page , soTrang));
        int cuoiTrang = phanTrang.getTotalPages();

        model.addAttribute("listSize" , phanTrang.getContent());
        model.addAttribute("soTrang" , page);
        model.addAttribute("cuoiTrang" , cuoiTrang);
        model.addAttribute("view","size/size.jsp");
        return "layout";
    }

    @PostMapping("/size/add")
    public String addSize(@Valid @ModelAttribute("size") Size size, BindingResult result , Model model , @RequestParam(defaultValue = "0") int page) {
        if (result.hasErrors()) {
            int soTrang = 3;
            Page<Size> phanTrang = sizeRepository.findAll(PageRequest.of(page , soTrang));
            int cuoiTrang = phanTrang.getTotalPages();

            model.addAttribute("listSize" , phanTrang.getContent());
            model.addAttribute("soTrang" , page);
            model.addAttribute("cuoiTrang" , cuoiTrang);
            model.addAttribute("suss" , "Mã đã tồn tại !");
            model.addAttribute("view","size/size.jsp");
            return "layout";
        }
        if (!service.checkMa(size.getMa())){
            int soTrang = 3;
            Page<Size> phanTrang = sizeRepository.findAll(PageRequest.of(page , soTrang));
            int cuoiTrang = phanTrang.getTotalPages();

            model.addAttribute("listSize" , phanTrang.getContent());
            model.addAttribute("soTrang" , page);
            model.addAttribute("cuoiTrang" , cuoiTrang);

            model.addAttribute("suss" , "Mã đã tồn tại !");
            model.addAttribute("view","size/size.jsp");
            return "layout";
        }
        service.addSize(size);
        return "redirect:/size/hien-thi";
    }

    @GetMapping("/size/view-update/{idSize}")
    public String viewUpdate(Model model, @PathVariable("idSize") UUID id) {
        model.addAttribute("size", new Size());
        model.addAttribute("size", service.getOne(id));
        model.addAttribute("view","size/update-size.jsp");
        return "layout";
    }

    @PostMapping("/size/update")
    public String updateSize(@Valid @ModelAttribute("size") Size size, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listSize", service.getAll());
            return "size/update-size";
        }
        service.updateSize(size, size.getId());
        return "redirect:/size/hien-thi";
    }
}
