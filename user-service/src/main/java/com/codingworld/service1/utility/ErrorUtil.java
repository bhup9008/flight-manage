package com.codingworld.service1.utility;

import com.codingworld.service1.response.Error;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.metrics.StartupStep;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Named
public class ErrorUtil {



    public Error getError(String errorCode) {
        Error error = new Error();
        error.setCode(errorCode);
        //error.setMessage(startup.getApiErrorCodes().get(errorCode));
        return error;
    }

    public List<Error> getErrorList(Set<String> errorCodes){
        List<Error> errors = new ArrayList<>();
        if(!CollectionUtils.isEmpty(errorCodes)) {
            for(String errorCode: errorCodes) {
                errors.add(getError(errorCode));
            }
        }
        return errors;
    }

    public List<Error> getErrorList(String errorCode){
        List<Error> errors = new ArrayList<>();
        errors.add(getError(errorCode));
        return errors;
    }
}
