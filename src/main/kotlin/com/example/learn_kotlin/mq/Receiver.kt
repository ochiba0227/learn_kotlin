package com.example.learn_kotlin.mq

import com.example.learn_kotlin.Service.CommandExec
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component


@Component
class Receiver {
    @RabbitListener(queues = ["hello"])
    fun processMessage(content: String) {
        CommandExec().exec(content)
    }
}