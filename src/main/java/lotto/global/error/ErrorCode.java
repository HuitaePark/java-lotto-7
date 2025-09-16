package lotto.global.error;

public enum ErrorCode {

    INVALID_PRICE("[ERROR] 유효하지 않은 구입 가격입니다.");

    private final String message;


    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
