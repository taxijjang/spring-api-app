package com.app.global.config.jpa

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.AuditorAware
import org.springframework.util.StringUtils
import java.util.*
import javax.servlet.http.HttpServletRequest

class AuditorAwareImpl(
    @Autowired private val httpServletRequest: HttpServletRequest
) : AuditorAware<String> {
    override fun getCurrentAuditor(): Optional<String> {
        var modifiedBy = httpServletRequest.requestURI
        if (!StringUtils.hasText(modifiedBy)) {
            modifiedBy = "unkwon"
        }
        return Optional.of(modifiedBy)
    }
}