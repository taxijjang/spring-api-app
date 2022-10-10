package com.app.global.error

import org.springframework.http.HttpStatus

enum class ErrorCode(
    val httpStatus: HttpStatus,
    val errorCode: String,
    val message: String,
) {
    TEST(HttpStatus.INTERNAL_SERVER_ERROR, "001", "business exception test")
}