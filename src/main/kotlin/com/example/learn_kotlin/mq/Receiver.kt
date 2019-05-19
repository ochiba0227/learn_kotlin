package com.example.learn_kotlin.mq

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component


@Component
class Receiver {
    @RabbitListener(queues = ["hello"])
    fun processMessage(content: String) {
        println(content)
    }
}