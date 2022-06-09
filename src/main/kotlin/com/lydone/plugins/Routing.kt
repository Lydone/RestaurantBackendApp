package com.lydone.plugins

import com.lydone.storage.RuntimeStorage
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import kotlinx.serialization.Serializable

@Serializable
data class Test(
    val text: String
)

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respond(Test("Here"))
        }
        get("/api/dishes") {
            call.respond(RuntimeStorage.dishes)
        }

        get("/api/categories") {
            call.respond(RuntimeStorage.categories)
        }

        get("/api/order/{table}") {
            call.respond(RuntimeStorage.order)
        }
        post("/api/order/{table}") {
            val dishes = call.receive<Map<Int, Int>>()
            dishes.forEach { (id, quantity) ->
                RuntimeStorage.order.compute(id) { _, value -> (value ?: 0) + quantity }
                call.respond(HttpStatusCode.OK)
            }
        }
    }
}
