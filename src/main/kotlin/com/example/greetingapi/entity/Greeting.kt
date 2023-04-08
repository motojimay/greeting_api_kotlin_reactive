package com.example.greetingapi.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.lang.NonNull

@Document
data class Greeting(
    @Id val id: String,
    @NonNull val greeting: String,
    @NonNull val country: String
)
