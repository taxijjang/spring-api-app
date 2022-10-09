package com.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringApiAppKotlinApplication

fun main(args: Array<String>) {
    runApplication<SpringApiAppKotlinApplication>(*args)
}
