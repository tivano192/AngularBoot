package com.myorga.code.config;

import com.myorga.technique.config.ProjectProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to Sample Application.
 * <p>
 * Properties are configured in the {@code application.properties} file.
 * See {@link ProjectProperties} for a good example.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {}
