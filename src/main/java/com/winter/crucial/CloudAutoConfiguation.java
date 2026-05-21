package com.winter.crucial;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;

@Configuration
@Profile("cloud")
@AutoConfiguration
@ConditionalOnClass(CloudAutoConfiguration.class)
@ConditionalOnMissingBean(name = "cloud")
@ConditionalOnProperty(prefix = "spring.cloud", name = "enabled", havingValue = "true", matchIfMissing = true)
@Import(CloudScanConfiguration.class)
public class CloudAutoConfiguration {
	
	public static final int ORDER = Ordered.HIGHEST_PRECEDENCE + 20;

}