package lotto.global.error;

public enum ErrorCode {

    INVALID_LOTTO_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 중복된 번호는 입력할수 없습니다."),
    INVALID_LOTTO_RANGE("[ERROR] 로또 범위를 초과하였습니다."),
    INVALID_DELIMITER("[ERROR] 로또 숫자는 쉼표로 구분해야 합니다."),

    INVALID_PURCHASE_AMOUNT("[ERROR] 구입 금액은 숫자를 입력해야 합니다."),
    INVALID_UNIT("[ERROR] 구입 금액은 1000단위로 입력해야 합니다.");

    private final String message;


    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
