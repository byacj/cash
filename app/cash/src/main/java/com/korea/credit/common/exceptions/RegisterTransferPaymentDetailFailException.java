package com.korea.credit.common.exceptions;

/**
 * @author sungjun
 * @since 9/8/24
 */
public class RegisterTransferPaymentDetailFailException extends RuntimeException{
    public RegisterTransferPaymentDetailFailException (String message) {
        super(message);
    }
}
