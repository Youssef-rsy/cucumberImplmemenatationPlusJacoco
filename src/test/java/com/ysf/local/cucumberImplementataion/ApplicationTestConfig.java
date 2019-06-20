package com.ysf.local.cucumberImplementataion;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;


@ComponentScan(basePackages ="com.ysf.local.cucumberImplementataion" )
@EntityScan(basePackages = "com.ysf.local.cucumberImplementataion")
@EnableJpaRepositories
@DataJpaTest
@ActiveProfiles("TEST")
public class ApplicationTestConfig {
}
