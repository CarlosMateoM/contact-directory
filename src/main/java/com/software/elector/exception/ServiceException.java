package com.software.elector.exception;

public class ServiceException extends RuntimeException{
    
    public ServiceException(String string) {
        super(string);
    }
    
    public ServiceException(Throwable thrwbl) {
        super(thrwbl);
    }    
    
    public ServiceException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
    
    
    
}
