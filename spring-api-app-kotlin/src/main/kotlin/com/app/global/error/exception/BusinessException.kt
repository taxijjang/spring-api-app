package com.app.global.error.exception

import com.app.global.error.ErrorCode
import java.lang.RuntimeException

class BusinessException(
    errorCode: ErrorCode,
) : RuntimeException(
    errorCode.message
)