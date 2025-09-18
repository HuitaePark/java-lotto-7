package lotto.presentation.ui;

public enum LottoInfoMessage {

    LOTTO_START_MESSAGE("구입금액을 입력해 주세요."),
    LOTTO_PURCHASED_MESSAGE("%d개를 구매했습니다."),
    LOTTO_ENTRY_MESSAGE("당첨 번호를 입력해 주세요."),
    LOTTO_BONUS_MESSAGE("보너스 번호를 입력해 주세요."),
    LOTTO_RESULT_MESSAGE("당첨 통계" + System.lineSeparator() + "---");

    private final String message;

    LottoInfoMessage(String message) {
        this.message = message;
    }

    public String getMessage(int value) {
        return String.format(this.message,value);
    }

    @Override
    public String toString() {
        return message;
    }
}
