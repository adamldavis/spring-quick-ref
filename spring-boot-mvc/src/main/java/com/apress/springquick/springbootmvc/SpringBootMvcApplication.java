package com.apress.springquick.springbootmvc;

import com.apress.spring_quick.jpa.simple.SimpleCourseRepository;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// by default it would scan the current package and everything under it
// scanning "com.apress.spring_quick.jpa.simple" initializes the SimpleCourseRepository
@SpringBootApplication(scanBasePackages = "com.apress.spring_quick.jpa.simple")
public class SpringBootMvcApplication {

    // Beans can also be defined right here since @SpringBootApplication includes @SpringBootConfiguration
    @Bean
    public CourseController courseController(
            final SimpleCourseRepository courseRepository,
            final MeterRegistry meterRegistry) {
        // MeterRegistry is automatically available due to including the spring-actuator-starter
        return new CourseController(courseRepository, meterRegistry);
    }

    @Bean
	public CustomHealthIndicator customHealthIndicator() {
    	return new CustomHealthIndicator();
	}

	@Bean
	public CustomInfoContributor customInfoContributor(final SimpleCourseRepository courseRepository) {
    	return new CustomInfoContributor(courseRepository);
	}

	// this main method starts up Spring
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMvcApplication.class, args);
    }

}
