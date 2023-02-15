package org.danduk.oauth2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;



@SpringBootApplication
@RestController
public class Oauth2Application   {
    Logger logger = LoggerFactory.getLogger(Oauth2Application.class);
    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        logger.info(System.getenv("GOOGLE_CLIENT_ID"));
        Map<String, Object> map = new LinkedHashMap<>();
        if (principal != null) {
            map.put("name", principal.getAttribute("name"));
            map.put("authenticated", true);
        }
        else {
            map.put("authenticated", false);
        }
        return map;
    }
    public static void main(String[] args) {
        SpringApplication.run(Oauth2Application.class, args);
    }


}
