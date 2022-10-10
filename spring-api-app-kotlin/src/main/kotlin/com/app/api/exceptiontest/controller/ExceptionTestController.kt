package com.app.api.exceptiontest.controller

import com.app.api.exceptiontest.dto.BindExceptionTestDto
import com.app.api.exceptiontest.dto.TestEnum
import com.app.global.error.ErrorCode
import com.app.global.error.exception.BusinessException
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.IllegalArgumentException
import javax.validation.Valid

@RestController
@RequestMapping("/api/exception")
class ExceptionTestController {

    @GetMapping("/bind-exception-test")
    fun bindExceptionTest(@Valid bindExceptionTestDto: BindExceptionTestDto): String{
        return "ok"
    }

    @GetMapping("/type-exception-test")
    fun typeMismatchException(@Valid testEnum: TestEnum) = "ok"

    @GetMapping("/business-exception-test")
    fun businessExceptionTest(isError: String) = when (isError) {
        "true" -> throw BusinessException(ErrorCode.TEST)
        else -> "ok"
    }

    @GetMapping("/exception-test")
    fun exceptionTest(isError: String) = when (isError) {
        "true" -> throw IllegalArgumentException("예외 테스트")
        else -> "ok"
    }
}