package com.metacoding.refsocket.chat;

import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatService {

    private final ChatRepository chatRepository;

    @Transactional
    public Chat save(String msg){
        Chat chat = Chat.builder().msg(msg).build();
        return chatRepository.save(chat);
    }

    public List<Chat> findAll(){
        Sort desc = Sort.by(Sort.Direction.DESC, "id");
//        Sort.by(Sort.Direction.ASC, "id");
//        Sort.by(Sort.Direction.DESC, "createdAt")
        return chatRepository.findAll(desc);
    }
}
