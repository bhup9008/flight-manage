package com.codingworld.apigateway.exception;

import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public class GlobalErrorWebExceptionHandler extends AbstractErrorWebExceptionHandler {
    public GlobalErrorWebExceptionHandler(  GlobalErrorAttributes errorAttributes,
                                            ApplicationContext applicationContext,
                                            ServerCodecConfigurer serverCodecConfigurer) {
        super(errorAttributes, new WebProperties.Resources(), applicationContext);
        this.setMessageWriters(serverCodecConfigurer.getWriters());
        this.setMessageReaders(serverCodecConfigurer.getReaders());
    }
    private Mono<ServerResponse> renderErrorResponse(ServerRequest request) {
        Map<String, Object> errorAttributesMap = getErrorAttributes(request, ErrorAttributeOptions.defaults());

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        if (errorAttributesMap.containsKey("status")) {
            status = HttpStatus.valueOf((Integer) errorAttributesMap.get("status"));
        }

        return ServerResponse.status(status)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(errorAttributesMap));
    }
    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
    }


    /*protected HttpStatus getHttpStatus(Map<String, Object> errorAttributes) {
        if (errorAttributes.containsKey("exception") && errorAttributes.get("exception") instanceof WebExchangeBindException) {
            return HttpStatus.UNPROCESSABLE_ENTITY;
        } else if (errorAttributes.containsKey("exception") && errorAttributes.get("exception") instanceof ResponseStatusException) {
            return ((ResponseStatusException) errorAttributes.get("exception")).getStatus();
        }
        return super.getHttpStatus(errorAttributes);
    }*/

}
