package lotto.global.constant;

public enum LottoInfoMessage {

    LOTTO_START_MESSAGE("구입금액을 입력해 주세요."),
    LOTTO_PURCHASED_MESSAGE("%d개를 구매했습니다.");

    private final String message;

    LottoInfoMessage(String message) {
        this.message = message;
    }

    public String getMessage(int value) {
        return String.format(this.message,value);
    }
}
