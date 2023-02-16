package org.danduk.oauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.client.OAuth2LoginConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class Oauth2ApplicationConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        OAuth2LoginConfigurer<HttpSecurity> httpSecurityOAuth2LoginConfigurer = http
                .authorizeRequests(requests -> requests
                        .antMatchers("/users").authenticated()
                        .and()

                )
                .logout(l -> l
                        .logoutSuccessUrl("/")
                )
//                .authorizeHttpRequests(requests -> requests
//                        .requestMatchers("/", "/error", "/logout", "/webjars/**").permitAll()
//                )
//                .authorizeHttpRequests(requests -> requests
//                        .requestMatchers("/").permitAll()
//                )
                .authorizeRequests(requests -> requests
//                        .anyRequest().authenticated()
                                .anyRequest().permitAll()
                )
                .csrf(c -> c

                        //.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                        .disable()
                )

                .exceptionHandling(e -> e
                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                )
                .oauth2Login();

        return http.build();
    }
//         @formatter:off
//        http
//                .authorizeHttpRequests(requests -> requests
//                        .requestMatchers("/", "/error", "/webjars/**").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .exceptionHandling(e -> e
//                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
//                )
//                .oauth2Login();
//        // @formatter:on
//        return http.build();
//    }
}
