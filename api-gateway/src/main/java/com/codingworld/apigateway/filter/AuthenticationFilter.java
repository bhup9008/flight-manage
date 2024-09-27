package com.codingworld.apigateway.filter;

import com.codingworld.apigateway.exception.InvalidTokenException;
import com.codingworld.apigateway.exception.TokenMissing;
import com.codingworld.apigateway.util.JwtUtil;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    @Autowired
    private RouteValidator validator;
    //ServerHttpResponse

    @Autowired
    private RestTemplate template;
    @Autowired
    private JwtUtil jwtUtil;

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        System.out.println("Apply method invoked");
        return ((exchange, chain) -> {
            ServerHttpRequest request=null;
           // try {
                if (validator.isSecured.test(exchange.getRequest())) {
                    //header contains token or not
                    if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {

                        return this.onError(exchange);
                        //return Mono.error(new TokenMissing("HttpStatus.FORBIDDEN"));
                        //return exchange.getResponse().setComplete();
                        //return Mono.error(new TokenMissing(HttpStatus.FORBIDDEN));
                    }

                    String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                    if (authHeader != null && authHeader.startsWith("Bearer ")) {
                        authHeader = authHeader.substring(7);
                    }
                    try {
//                    //REST call to AUTH service
                   //template.getForObject("http://USER-SERVICE/auth/validate?token" + authHeader, String.class);
                        jwtUtil.validateToken(authHeader);
                         request=exchange.getRequest().mutate().
                                header("loggedInUser",jwtUtil.getUserNameFromJwtToken(authHeader)).build();
                        System.out.println("Authentication access full");

                    } catch (Exception e) {
                        return onError(exchange);
                       // throw new InvalidTokenException(HttpStatus.BAD_REQUEST,"nmnmnvgftfyfyh");
                       // System.out.println("invalid access...!");
                       // exchange.getResponse().setComplete();

                    }
                }
                return chain.filter(exchange.mutate().request(request).build());
/*
            }catch (Exception ex){
               return exchange.getResponse().setComplete();
                //throw new TokenMissing(ex.getMessage());
               //return exchange.getResponse().setComplete();
            }
*/


        });
    }
    @Getter
    @Setter
    @Builder
    public static class Config {
        private String headerName;

    }
    private Mono<Void> onError(ServerWebExchange exchange) {
        ServerHttpResponse response = exchange.getResponse();
        System.out.println(exchange);
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        return response.setComplete();
    }

}
