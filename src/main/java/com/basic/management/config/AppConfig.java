package com.basic.management.config;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author fujie
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "app-config")
public class AppConfig {

    /**
     * 访问地址
     */
    private String resHost;

    /**
     * 端口
     */
    private String fastStoragePort;
}
