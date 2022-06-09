package com.lydone

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.lydone.plugins.*

fun main() {
    embeddedServer(Netty, port = System.getenv("PORT").toInt()) {
        configureRouting()
        configureSerialization()
    }.start(wait = true)
}
