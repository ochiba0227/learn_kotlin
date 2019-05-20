package com.example.learn_kotlin.controller

import com.example.learn_kotlin.mq.Sender
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class HelloController {
    @Autowired
    lateinit var sender: Sender

    @GetMapping("/hello")
    fun hello(): String {
//        sender.hello()
        return "hello"
    }

    @GetMapping("/command")
    fun command(@RequestParam(name = "name", required = true) name: String, model: Model): String {
        sender.command(name)
        model.addAttribute("name", name);
        return "result"
    }
}