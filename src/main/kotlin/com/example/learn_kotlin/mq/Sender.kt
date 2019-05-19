package com.example.learn_kotlin.mq

import org.springframework.amqp.core.Queue
import org.springframework.stereotype.Component
import org.springframework.amqp.rabbit.core.RabbitTemplate

@Component
class Sender(
    val template: RabbitTemplate,
    val queue: Queue
){
    fun hello(){
        var message = "Hello World!"
        template.convertAndSend(queue.name, message)
        println(" [x] Sent '$message'")
    }
}