package com.app.api.health.dto

class HealthCheckResponseDto(
    val health: String,
    val activeProfile: List<String>,
)