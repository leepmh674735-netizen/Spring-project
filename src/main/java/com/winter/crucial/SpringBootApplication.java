package com.winter.crucial;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AliasFor;
import org.springframework.core.annotation.AnnotationAttributes;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Configuration
@EnableAutoConfiguration
@ComponentScan
public @interface SpringBootApplication {
	
	Class<?>[] exclude() default{};
	
	String[] excludeName() default {};
	
	@AliasFor(annotation = ComponentScan.class, attribute = "basePackages")
	String[] scanBasePackges() default {};
	
	@AliasFor(annotation = ComponentScan.class, attribute = "basePackageClasses")
	Class<?>[] scanBasPackageClasses() default {};
	
	
}

protected List<String> getCardidateConfigurations(AnnotationMetadata metadata,
		AnnotationAttributes attributes)  {
	return SpringFactoriesLoader.loadFactoryNames{
		getSpringFactoryClass(). getBeanClassLoader());
	}
