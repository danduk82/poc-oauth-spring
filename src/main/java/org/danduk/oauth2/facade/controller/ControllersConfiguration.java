package org.danduk.oauth2.facade.controller;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.danduk.oauth2.gen") // activates generated controllers
public class ControllersConfiguration {
}
