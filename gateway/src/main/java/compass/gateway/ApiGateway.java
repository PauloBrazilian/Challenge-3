package compass.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
public class ApiGateway {

    @Autowired
    private LoggingFilter loggingFilter;

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("msauthorization", r -> r.path("/oauth/**")
                        .filters(f -> f.filter(loggingFilter))
                        .uri("http://localhost:8081"))
                .route("msnotification", r -> r.path("/notification/**")
                        .filters(f -> f.filter(loggingFilter))
                        .uri("http://localhost:8082"))
                .route("msproducts", r -> r.path("/products/**")
                        .filters(f -> f.filter(loggingFilter))
                        .uri("http://localhost:8083"))
                .build();
    }

}