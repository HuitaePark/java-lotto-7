package lotto.domain.common.error.exception;

import lotto.domain.common.error.ErrorCode;

public class PurchaseIllegalArgumentException extends IllegalArgumentException{

    private final ErrorCode errorCode;

    public PurchaseIllegalArgumentException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

}
