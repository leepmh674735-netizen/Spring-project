package com.winter.crucial;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("cloud")
@AutoConfiguration("cloundAutoConfiguration.ORDER")
@ConditionalOnClass(CloundAutoConfiguration.class)
@ConditionalOnMissingBean(cloud.class)
@ConditionalOnProperty(prefix = spring.cloud" name = "enabled" , havingValue = "true", matchIfMissing = true)
@Import(CloudScanConfiguration.class)
public class CloudAutoConfiguation {
	
	public static final int ORDER = Obered.HIGHEST_PRECEDENCE + 20;

}
