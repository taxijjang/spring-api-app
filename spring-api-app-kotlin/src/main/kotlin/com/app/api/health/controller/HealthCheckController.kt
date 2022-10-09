package com.app.api.health.controller

import com.app.api.health.dto.HealthCheckResponseDto
import org.springframework.core.env.Environment
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api")
class HealthCheckController(
    private val environment: Environment
) {
    @GetMapping("/health")
    fun healthCheck(): ResponseEntity<HealthCheckResponseDto> {
        return ResponseEntity.status(200).body(
            HealthCheckResponseDto(
                health = "ok", activeProfile = Arrays.asList(*environment!!.activeProfiles)
            )
        )
    }
}