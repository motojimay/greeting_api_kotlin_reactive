package com.example.greetingapi.service

import com.example.greetingapi.dto.GreetingDto
import com.example.greetingapi.mapper.GreetingMapper
import com.example.greetingapi.repository.GreetingReactiveRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class GreetingService(val repository: GreetingReactiveRepository,
                      val mapper: GreetingMapper) {

    fun saveGreeting(greetingDto: GreetingDto): Mono<GreetingDto> {
        val greeting = mapper.dtoToEntity(greetingDto)
        return repository.save(greeting).map { mapper.entityToDto(greeting) }
    }

    fun findAllGreeting(): Flux<GreetingDto>
        = repository.findAll().map(mapper::entityToDto).switchIfEmpty(Flux.empty())

    fun findGreetingById(id: String): Mono<GreetingDto>
        = repository.findById(id).map(mapper::entityToDto).switchIfEmpty(Mono.empty())

    fun findGreetingByCountry(country: String): Mono<GreetingDto>
        = repository.findGreetingByCountry(country).map(mapper::entityToDto).switchIfEmpty(Mono.empty())

    fun updateGreeting(greetingDto: GreetingDto): Mono<GreetingDto>
        = repository.findById(greetingDto.id).flatMap {
            return@flatMap repository.save(mapper.dtoToEntity(greetingDto))
        }.map(mapper::entityToDto)

    fun deleteGreeting(id: String): Mono<Void> = repository.deleteById(id)
}