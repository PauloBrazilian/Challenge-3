package compass.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGateway {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder buider){
        return buider.routes()
                .route("msnotification", r -> r
                        .path("/v1")
                        .uri("http://localhost:8082"))
                .route("msproducts", r -> r
                        .path("/v2")
                        .uri("http://localhost:8083"))
                .build();
    }

}