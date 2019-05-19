package com.example.learn_kotlin.controller

import com.example.learn_kotlin.mq.Sender
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HelloController {
    @Autowired
    lateinit var sender: Sender

    @GetMapping("/hello")
    fun hello(): String {
        sender.hello()
        return "hello"
    }
}