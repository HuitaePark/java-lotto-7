package lotto.domain.purchase;

import lotto.domain.common.error.ErrorCode;
import lotto.domain.common.error.exception.PurchaseIllegalArgumentException;

public record PurchaseAmount(int amount) {

    public static PurchaseAmount forInputElement(String element) {
        validateNumberFomat(element);
        int parsedAmount = parseToInt(element);
        return new PurchaseAmount(parsedAmount);
    }

    private static void validateNumberFomat(String element) {
        if (!element.matches("\\d+")) {
            throw new PurchaseIllegalArgumentException(ErrorCode.INVALID_PURCHASE_AMOUNT);
        }
    }

    private static int parseToInt(String element) {
        return Integer.parseInt(element);
    }
}