package com.example.demo.service;

import com.example.demo.entity.ChatLieu;
import java.util.List;
import java.util.UUID;

public interface ChatLieuService {

    List<ChatLieu> getAll();

    void addChatLieu(ChatLieu ao);

    void updateChatLieu(ChatLieu ao , UUID id);

    ChatLieu getOne(UUID id);

    boolean checkMa(String ma);
}
