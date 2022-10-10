package com.app.api.exceptiontest.dto

import javax.validation.constraints.Max
import javax.validation.constraints.NotBlank

class BindExceptionTestDto(
    @field:NotBlank(message = "해당 값은 필수 입력값입니다.")
    val value1: String,

    @field:Max(value = 10, message = "최대 입력값은 10입니다.")
    val value2: Int?,
)