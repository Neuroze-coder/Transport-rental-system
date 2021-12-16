//package com.accenture.russiaatc.irentservice.error;
//
//public class BusinessRuntimeException extends RuntimeException {
//    private ErrorCodeEnum errorCode;
//
//    public BusinessRuntimeException(ErrorCodeEnum errorCode, Throwable cause, Object ...args) {
//        super(errorCode.getMessageTemplate(args), cause);
//        this.errorCode = errorCode;
//    }
//
//    public BusinessRuntimeException(ErrorCodeEnum errorCode, Object ...args) {
//        super(errorCode.getMessageTemplate(args));
//        this.errorCode = errorCode;
//    }
//
//    public ErrorCodeEnum getErrorCode() {
//        return errorCode;
//    }
//}

package com.accenture.russiaatc.irentservice.error;

public class BusinessRuntimeException extends RuntimeException {
    private ErrorCodeEnum errorCode;

    public BusinessRuntimeException(ErrorCodeEnum errorCode, Throwable cause, Object ...args) {
        super(errorCode.getMessageTemplate(args), cause);
        this.errorCode = errorCode;
    }

    public BusinessRuntimeException(ErrorCodeEnum errorCode, Object ...args) {
        super(errorCode.getMessageTemplate(args));
        this.errorCode = errorCode;
    }

    public BusinessRuntimeException (ErrorCodeEnum errorCode, Throwable cause) {
        super(errorCode.getMessageTemplate(new Object[0]), cause);
        this.errorCode = errorCode;
    }

    public ErrorCodeEnum getErrorCode() {
        return errorCode;
    }
}
