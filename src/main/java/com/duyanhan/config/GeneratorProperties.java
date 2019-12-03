package com.duyanhan.config;

import com.duyanhan.config.property.Application;
import com.duyanhan.config.property.Base;
import com.duyanhan.config.property.Common;
import com.duyanhan.config.property.Generator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "property")
@Slf4j
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GeneratorProperties {

    private Base base;
    private Common common;
    private Generator generator;
    private List<Application> applications;
}
