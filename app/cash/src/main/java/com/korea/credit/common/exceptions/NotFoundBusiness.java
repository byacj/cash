package com.korea.credit.common.exceptions;

/**
 * @author sungjun
 * @since 9/8/24
 */
public class NotFoundBusiness extends RuntimeException{
    public NotFoundBusiness (String message) {
        super(message);
    }
}
