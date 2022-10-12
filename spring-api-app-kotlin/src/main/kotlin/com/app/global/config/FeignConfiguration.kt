package com.app.global.config

import com.app.global.error.FeignClientExceptionErrorDecode
import feign.Logger
import feign.Retryer
import feign.codec.ErrorDecoder
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Retry
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@EnableFeignClients(basePackages = ["com.app"]) // todo 패키지 변경
@Import(FeignConfiguration::class)
class FeignConfiguration {
    @Bean
    fun feignLoggerLevel(): Logger.Level {
        return Logger.Level.FULL
    }

    @Bean
    fun errorDecoder(): ErrorDecoder {
        return FeignClientExceptionErrorDecode()
    }

    @Bean
    fun retryer(): Retryer {
        return Retryer.Default(1000, 2000, 3)
    }
}