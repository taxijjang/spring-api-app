package com.app.global.error

import org.springframework.http.HttpStatus

enum class ErrorCode(
    val errorCode: String,
    val httpStatus: HttpStatus,
    val message: String,
)