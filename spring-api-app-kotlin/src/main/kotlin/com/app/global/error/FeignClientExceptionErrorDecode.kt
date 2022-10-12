package com.app.global.error

import feign.FeignException
import feign.Response
import feign.RetryableException
import feign.codec.ErrorDecoder
import org.springframework.http.HttpStatus
import java.lang.Exception

class FeignClientExceptionErrorDecode : ErrorDecoder {
    private val errorDecoder: ErrorDecoder = ErrorDecoder.Default()
    override fun decode(methodKey: String?, response: Response?): Exception {
        val exception: FeignException = FeignException.errorStatus(methodKey, response)
        val httpStatus: HttpStatus = HttpStatus.valueOf(response!!.status())
        if (httpStatus.is5xxServerError) {
            return RetryableException(
                response.status(),
                exception.message,
                response.request().httpMethod(),
                exception,
                null,
                response.request()
            )
        }
        return errorDecoder.decode(methodKey, response)
    }
}