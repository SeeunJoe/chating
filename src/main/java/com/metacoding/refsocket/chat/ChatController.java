package com.metacoding.refsocket.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class ChatController {
    private final ChatService chatService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("models",chatService.findAll());
        return "index";
    }

    @PostMapping("/chat")
    public String chat(String msg) {
        chatService.save(msg);
        return "redirect:/";
    }

    @GetMapping("/save-form")
    public String saveForm() {
        return "save-form";
    }

}
