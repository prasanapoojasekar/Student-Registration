package com.corpfield.StudentRegistration.exceptions;

import com.corpfield.StudentRegistration.constants.ResponseCodes;
import com.corpfield.StudentRegistration.dto.responseDto.ResponseDto;

public class ServiceException extends RuntimeException{
    private String errorMessage;

    public ServiceException(String errorMessage){
        super(errorMessage);
        this.errorMessage=errorMessage;
    }

    public static ResponseDto sendErrorResponse(Exception e){
        if(e instanceof ServiceException){
            return new ResponseDto(e.getMessage(),ResponseCodes.INVALID_INPUT);
        }
        System.out.println("Internal server Error");
        e.printStackTrace();
        return new ResponseDto("Oops! Error occur in server,we are looking into it",ResponseCodes.SERVER_ERROR);
    }
}
