package com.apigateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@CrossOrigin
public class GatewayConfig {

    @Autowired
    AuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {

        return builder.routes()
                .route("member-service", r -> r.path("/members/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://member-service"))

                .route("POLICY-SERVICE", r -> r.path("/policy/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://POLICY-SERVICE"))

                .route("CLAIM-SERVICE", r -> r.path("/claims/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://CLAIM-SERVICE"))
                .build();
    }

}
