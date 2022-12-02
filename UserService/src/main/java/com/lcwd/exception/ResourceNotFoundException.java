package com.lcwd.exception;

import com.lcwd.constant.ApplicationConstant;

public class ResourceNotFoundException  extends RuntimeException{

    public ResourceNotFoundException() {
        super(ApplicationConstant.RESOURCE_NOT_FOUND);

    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
