package com.example.demo.controller;


import com.example.demo.entity.ChatLieu;
import com.example.demo.repository.ChatLieuRepository;
import com.example.demo.service.ChatLieuService;
import com.example.demo.service.impl.ChatLieuServiceImpl;
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
public class ChatLieuController {

    @Autowired
    private ChatLieuService service = new ChatLieuServiceImpl();

    @Autowired
    private ChatLieuRepository chatLieuRepository;

    @GetMapping("/chat-lieu/hien-thi")
    public String hienThi(Model model , @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("chatLieu", new ChatLieu());
        int soTrang = 3;
        Page<ChatLieu> phanTrang = chatLieuRepository.findAll(PageRequest.of(page , soTrang));
        int cuoiTrang = phanTrang.getTotalPages();

        model.addAttribute("listChatLieu" , phanTrang.getContent());
        model.addAttribute("soTrang" , page);
        model.addAttribute("cuoiTrang" , cuoiTrang);
        model.addAttribute("view","chat-lieu/chat-lieu.jsp");
        return "layout";
    }

    @PostMapping("/chat-lieu/add")
    public String addChatLieu(@Valid @ModelAttribute("chatLieu") ChatLieu chatLieu, BindingResult result , Model model ,
                        @RequestParam(defaultValue = "0") int page) {
        if (result.hasErrors()) {
            int soTrang = 3;
            Page<ChatLieu> phanTrang = chatLieuRepository.findAll(PageRequest.of(page , soTrang));
            int cuoiTrang = phanTrang.getTotalPages();

            model.addAttribute("listChatLieu" , phanTrang.getContent());
            model.addAttribute("soTrang" , page);
            model.addAttribute("cuoiTrang" , cuoiTrang);
            model.addAttribute("view","chat-lieu/chat-lieu.jsp");
            return "layout";
        }
        if (!service.checkMa(chatLieu.getMa())) {
            int soTrang = 3;
            Page<ChatLieu> phanTrang = chatLieuRepository.findAll(PageRequest.of(page , soTrang));
            int cuoiTrang = phanTrang.getTotalPages();

            model.addAttribute("listChatLieu" , phanTrang.getContent());
            model.addAttribute("soTrang" , page);
            model.addAttribute("cuoiTrang" , cuoiTrang);
            model.addAttribute("suss", "Mã đã tồn tại !");
            model.addAttribute("view","chat-lieu/chat-lieu.jsp");
            return "layout";
        }
        service.addChatLieu(chatLieu);
        model.addAttribute("successMessage" ,"Thêm thành công ! ");
        return "redirect:/chat-lieu/hien-thi";
    }

    @GetMapping("/chat-lieu/view-update/{idChatLieu}")
    public String viewUpdate(Model model, @PathVariable("idChatLieu") UUID id) {
        model.addAttribute("chatLieu", new ChatLieu());
        model.addAttribute("chatLieu", service.getOne(id));
        model.addAttribute("view","chat-lieu/update-chat-lieu.jsp");
        return "layout";
    }

    @PostMapping("/chat-lieu/update")
    public String updateChatLieu(@Valid @ModelAttribute("chatLieu") ChatLieu chatLieu, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listChatLieu", service.getAll());
            return "chat-lieu/update-chat-lieu";
        }
        service.updateChatLieu(chatLieu, chatLieu.getId());
        model.addAttribute("successMessage" ,"Sửa thành công ! ");
        return "redirect:/chat-lieu/hien-thi";
    }

}
