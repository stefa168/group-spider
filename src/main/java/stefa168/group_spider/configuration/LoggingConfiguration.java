package stefa168.group_spider.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * <a href=https://andbin.it/blog/java/autowiring-logger-spring-framework-boot>Origin of configuration</a>
 */
@Configuration
public class LoggingConfiguration {

    @Bean
    @Scope("prototype")
    public Logger slf4jLogger(InjectionPoint injectionPoint) {
        Class<?> targetClass = injectionPoint.getMember().getDeclaringClass();
        return LoggerFactory.getLogger(targetClass);
    }

}
