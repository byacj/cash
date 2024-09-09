package com.korea.credit.common.exceptions;

/**
 * @author sungjun
 * @since 9/8/24
 */
public class BadRequest extends RuntimeException{
    public BadRequest(String message) {
        super(message);
    }
}
