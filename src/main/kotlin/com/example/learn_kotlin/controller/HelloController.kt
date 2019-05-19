package com.example.learn_kotlin.controller

import com.example.learn_kotlin.mq.Sender
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HelloController {

    @GetMapping("/hello")
    fun hello(): String {
        Sender().hello()
        return "hello"
    }
}