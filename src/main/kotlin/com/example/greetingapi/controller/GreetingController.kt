package com.example.greetingapi.controller

import com.example.greetingapi.dto.GreetingDto
import com.example.greetingapi.service.GreetingService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/greeting")
class GreetingController(val service: GreetingService) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getGreetingList(): Flux<GreetingDto> = service.findAllGreeting()

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getGreetingById(@PathVariable id: String): Mono<GreetingDto> = service.findGreetingById(id)

    @GetMapping("/{country}")
    @ResponseStatus(HttpStatus.OK)
    fun getGreetingByCountry(@PathVariable country: String): Mono<GreetingDto> = service.findGreetingByCountry(country)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createGreeting(@RequestBody @Valid greetingDto: GreetingDto): Mono<GreetingDto> = service.saveGreeting(greetingDto)

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun updateGreeting(@RequestBody @Valid greetingDto: GreetingDto): Mono<GreetingDto> = service.updateGreeting(greetingDto)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteGreeting(@PathVariable id: String): Mono<Void> = service.deleteGreeting(id)

}