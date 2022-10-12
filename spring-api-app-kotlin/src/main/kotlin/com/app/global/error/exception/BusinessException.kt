package com.app.global.error.exception

import com.app.global.error.ErrorCode
import java.lang.RuntimeException

class BusinessException(val errorCode: ErrorCode) : RuntimeException(
    errorCode.message
)

