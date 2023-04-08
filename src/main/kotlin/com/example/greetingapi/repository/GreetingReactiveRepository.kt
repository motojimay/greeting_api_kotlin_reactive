package com.example.greetingapi.repository

import com.example.greetingapi.entity.Greeting
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface GreetingReactiveRepository: ReactiveCrudRepository<Greeting, String> {
    fun findGreetingByCountry(country: String): Mono<Greeting>
}