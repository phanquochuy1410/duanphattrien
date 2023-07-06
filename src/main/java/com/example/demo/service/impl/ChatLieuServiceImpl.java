package com.example.demo.service.impl;

import com.example.demo.entity.ChatLieu;
import com.example.demo.repository.ChatLieuRepository;
import com.example.demo.service.ChatLieuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChatLieuServiceImpl implements ChatLieuService {

    @Autowired
    private ChatLieuRepository chatLieuRepository;

    @Override
    public List<ChatLieu> getAll() {
        return chatLieuRepository.findAll();
    }

    @Override
    public void addChatLieu(ChatLieu chatLieu) {
        chatLieuRepository.save(chatLieu);
    }

    @Override
    public void updateChatLieu(ChatLieu chatLieu, UUID id) {
        BeanUtils.copyProperties(chatLieu, chatLieuRepository.getReferenceById(id));
        chatLieuRepository.save(chatLieu);
    }

    @Override
    public ChatLieu getOne(UUID id) {
        return chatLieuRepository.getReferenceById(id);
    }

    @Override
    public boolean checkMa(String ma) {
        return !chatLieuRepository.existsByMa(ma);
    }
}
