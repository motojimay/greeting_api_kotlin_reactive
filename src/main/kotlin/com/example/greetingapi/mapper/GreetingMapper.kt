package com.example.greetingapi.mapper

import com.example.greetingapi.dto.GreetingDto
import com.example.greetingapi.entity.Greeting
import org.springframework.stereotype.Component

@Component
class GreetingMapper {

    fun dtoToEntity(greetingDto: GreetingDto): Greeting = Greeting(
        greetingDto.id,
        greetingDto.greeting,
        greetingDto.country
    )

    fun entityToDto(greeting: Greeting): GreetingDto = GreetingDto(
        greeting.id,
        greeting.country,
        greeting.country
    )

}