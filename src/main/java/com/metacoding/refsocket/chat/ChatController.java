package com.metacoding.refsocket.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ChatController {
    private final ChatService chatService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("models",chatService.findAll());
        return "index";
    }

    @GetMapping("/save-form")
    public String saveForm() {
        return "save-form";
    }

    @GetMapping("/api")
    public ResponseEntity<?> api(){
        List<Chat> models = chatService.findAll();
        return ResponseEntity.ok(models);
    }

    @PostMapping("/chat")
    public String chat(String msg) {
        chatService.save(msg);
        return "redirect:/";
    }


}
