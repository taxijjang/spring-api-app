package com.app.global.error

import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import java.lang.StringBuilder

class ErrorResponse(
    private val errorCode: String,
    private val errorMessage: String,
) {
    companion object {
        fun of(errorCode: String, errorMessage: String): ErrorResponse {
            return ErrorResponse(
                errorCode = errorCode,
                errorMessage = errorMessage,
            )
        }

        fun of(errorCode: String, bindingResult: BindingResult): ErrorResponse {
            return ErrorResponse(
                errorCode = errorCode,
                errorMessage = createErrorMessage(bindingResult)
            )
        }

        private fun createErrorMessage(bindingResult: BindingResult): String {
            val sb = StringBuilder()
            var isFirst = true

            val fieldErrors: List<FieldError> = bindingResult.fieldErrors

            for (fieldError in fieldErrors) {
                if (!isFirst) {
                    sb.append(", ")
                } else {
                    isFirst = false
                }
                sb.append("[")
                sb.append(fieldError.field)
                sb.append("]")
                sb.append(fieldError.defaultMessage)
            }
            return sb.toString()
        }

    }
}