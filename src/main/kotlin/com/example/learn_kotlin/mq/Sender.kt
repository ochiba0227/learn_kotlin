package com.example.learn_kotlin.mq

import com.rabbitmq.client.ConnectionFactory
import org.springframework.stereotype.Component


@Component
class Sender{
    companion object {
        const val QUEUE_NAME = "hello"
    }

    fun hello(){
        val factory = ConnectionFactory()
        factory.host = "localhost"
        val connection = factory.newConnection()
        val channel = connection.createChannel()

        channel.queueDeclare(Sender.QUEUE_NAME, false, false, false, null)
        val message = "Hello World!"
        channel.basicPublish("", Sender.QUEUE_NAME, null, message.toByteArray(charset("UTF-8")))
        println(" [x] Sent '$message'")

        channel.close()
        connection.close()
    }
}