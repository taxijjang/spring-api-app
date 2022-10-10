package com.app.global.error

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(BindException::class)
    protected fun handleBindException(e: BindException): ResponseEntity<ErrorResponse> {
        val errorResponse: ErrorResponse = ErrorResponse.of(HttpStatus.BAD_REQUEST.toString(), e.bindingResult)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse)
    }
}