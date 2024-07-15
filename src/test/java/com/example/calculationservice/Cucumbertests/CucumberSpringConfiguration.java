package com.example.calculationservice.Cucumbertests;

import com.example.calculationservice.TestConfig;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = TestConfig.class) // Use the newly created TestConfig class
public class CucumberSpringConfiguration {
}
