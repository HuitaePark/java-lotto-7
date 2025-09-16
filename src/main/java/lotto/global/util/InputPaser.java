package lotto.global.util;

import lotto.domain.PurchaseAmount;

public final class InputPaser {

    private InputPaser() {//인스턴스화 방지
    }

    public static PurchaseAmount toPurchaseAmount(String input) {
        return new PurchaseAmount(Integer.parseInt(input));
    }

}
