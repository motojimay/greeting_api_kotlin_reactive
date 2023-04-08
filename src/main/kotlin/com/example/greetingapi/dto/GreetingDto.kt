package com.example.greetingapi.dto

import org.springframework.lang.NonNull

data class GreetingDto(
    @NonNull val id: String,
    @NonNull val greeting: String,
    @NonNull val country: String
)
