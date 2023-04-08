package com.example.greetingapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux


@EnableWebFlux
@SpringBootApplication
class GreetingApiApplication

fun main(args: Array<String>) {
    runApplication<GreetingApiApplication>(*args)
}
